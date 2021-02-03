package com.hoe.sentient.api.heart;

import com.hoe.sentient.facade.heart.HeartBeatFacade;
import com.hoe.sentient.facade.heart.dto.HeartBeatDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *
 * 心动表 Controller
 *
 * @author: Gavin
 * @date: 2021-01-28 16:45:43
 */
@RestController
@AllArgsConstructor
@Validated
//@Api(value = "心动表管理相关接口", tags = "积心动表管理相关接口")
@RequestMapping("/api/vs/manage-heart-beat")
public class HeartBeatManageController {

}
