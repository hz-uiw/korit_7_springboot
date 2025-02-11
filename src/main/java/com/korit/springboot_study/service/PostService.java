package com.korit.springboot_study.service;

import com.korit.springboot_study.dto.request.ReqCreatePostDto;
import com.korit.springboot_study.entity.Post;
import com.korit.springboot_study.repository.PostRepository;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional(rollbackFor = Exception.class)
    public Post createPost(ReqCreatePostDto reqCreatePostDto) {
        return postRepository.save(reqCreatePostDto.toPost()).get();
    }

    @Transactional(rollbackFor = Exception.class)
    public Post getPostById(int postId) throws Exception {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("해당 PostId의 게시글이 존재하지 않습니다."));
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Post> getAllPostsByKeywordContaining(int page, int size, String keyword) throws NotFoundException {
        int startIndex = (page - 1) * size;
        List<Post> posts = postRepository.findAllByKeywordContaining(startIndex, size, keyword)
                .orElseThrow(() -> new NotFoundException("검색된 정보가 없습니다."));
        return posts;
    }
}
