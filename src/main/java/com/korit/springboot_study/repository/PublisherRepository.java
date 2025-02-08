package com.korit.springboot_study.repository;

import com.korit.springboot_study.entity.Publisher;
import com.korit.springboot_study.exception.CustomDuplicateKeyException;
import com.korit.springboot_study.mapper.PublisherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PublisherRepository {

    @Autowired
    private PublisherMapper publisherMapper;

    public Optional<List<Publisher>> findAllPublisher() {
        List<Publisher> foundPublishers = publisherMapper.selectPublishersAll();
        return foundPublishers.isEmpty()
                ? Optional.empty()
                : Optional.ofNullable(foundPublishers);
    }

    public Optional<Publisher> save(Publisher publisher) {
        try {
            publisherMapper.insertPublisher(publisher);
        } catch (DuplicateKeyException e) {
            throw new CustomDuplicateKeyException(e.getMessage());
        }
        return Optional.of(publisher);
    }
}
