package com.hoe.sentient.mood.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoe.sentient.mood.dao.CommentRepository;
import com.hoe.sentient.mood.domain.entity.Comment;
import com.hoe.sentient.mood.mapper.CommentMapper;
import org.springframework.stereotype.Repository;

/**
 * 评论表Repository实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:24
 */
@Repository
public class CommentRepositoryImpl extends ServiceImpl<CommentMapper, Comment> implements CommentRepository {

}


