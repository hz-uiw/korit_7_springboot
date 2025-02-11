package com.korit.springboot_study.mapper;

import com.korit.springboot_study.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    int insert(Post post);
    Post selectById(@Param(value = "PostId") int postId);
    List<Post> selectAllByKeywordContaining(
            @Param(value = "startIndex") int startIndex,
            @Param(value =  "limitCount")int limitCount,
            @Param(value = "keyword") String keyword);
}
