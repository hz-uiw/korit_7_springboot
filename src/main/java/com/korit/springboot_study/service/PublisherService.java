package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqAddPublisherDto;
import com.korit.springboot_study.dto.response.common.SuccessResponseDto;
import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.repository.PublisherRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public SuccessResponseDto<List<Publisher>> getAllPublishers() throws NotFoundException {
        List<Publisher> foundPublishers = publisherRepository.findAllPublisher()
                .orElseThrow(() -> new NotFoundException("출판사 정보가 없습니다."));
        return new SuccessResponseDto<>(foundPublishers);
    }

    public Publisher addPublisher(ReqAddPublisherDto reqAddPublisherDto) {
        return publisherRepository
                .save(reqAddPublisherDto.toPublisher())
                .get();
    }
}
