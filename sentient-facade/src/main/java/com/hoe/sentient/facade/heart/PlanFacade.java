package com.hoe.sentient.facade.heart;

import com.hoe.sentient.common.util.BeanUtilsEx;
import com.hoe.sentient.common.util.GeneralAssembler;
import com.hoe.sentient.heart.dao.PlanRepository;
import com.hoe.sentient.heart.domain.entity.Plan;
import com.hoe.sentient.heart.service.PlanService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 计划表Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:20
 */
@Component
public class PlanFacade {
    @Resource
    private PlanService planService;
    @Resource
    private PlanRepository planRepository;


}
