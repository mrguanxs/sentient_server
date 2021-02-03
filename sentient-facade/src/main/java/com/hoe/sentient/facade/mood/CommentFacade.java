package com.hoe.sentient.facade.mood;

import com.hoe.sentient.mood.dao.CommentRepository;
import com.hoe.sentient.mood.domain.entity.Comment;
import com.hoe.sentient.mood.service.CommentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论表Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:24
 */
@Component
public class CommentFacade {
    @Resource
    private CommentService commentService;
    @Resource
    private CommentRepository commentRepository;


}
