package com.hoe.sentient.heart.service.impl;

import com.hoe.sentient.heart.dao.PlanRepository;
import com.hoe.sentient.heart.domain.entity.Plan;
import com.hoe.sentient.heart.service.PlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 计划表Service实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:20
 */
@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanRepository planRepository;

}
