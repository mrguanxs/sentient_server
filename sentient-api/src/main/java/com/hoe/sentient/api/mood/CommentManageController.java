package com.hoe.sentient.api.mood;

import com.hoe.sentient.facade.mood.CommentFacade;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *
 * 评论表 Controller
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:24
 */
@RestController
@AllArgsConstructor
@Validated
//@Api(value = "评论表管理相关接口", tags = "积评论表管理相关接口")
@RequestMapping("/api/vs/manage-comment")
public class CommentManageController {


}
