package com.hoe.sentient.mood.service.impl;

import com.hoe.sentient.mood.dao.CommentRepository;
import com.hoe.sentient.mood.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 评论表Service实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:24
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentRepository commentRepository;

}
