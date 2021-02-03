package com.hoe.sentient.facade.heart;

import com.hoe.sentient.common.util.BeanUtilsEx;
import com.hoe.sentient.common.util.GeneralAssembler;
import com.hoe.sentient.heart.dao.HeartBeatRepository;
import com.hoe.sentient.heart.domain.entity.HeartBeat;
import com.hoe.sentient.heart.service.HeartBeatService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 心动表Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:45:43
 */
@Component
public class HeartBeatFacade {
    @Resource
    private HeartBeatService heartBeatService;
    @Resource
    private HeartBeatRepository heartBeatRepository;


}
