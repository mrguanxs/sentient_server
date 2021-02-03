package com.hoe.sentient.heart.dao.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoe.sentient.heart.dao.PlanRepository;
import com.hoe.sentient.heart.domain.entity.Plan;
import com.hoe.sentient.heart.mapper.PlanMapper;
import org.springframework.stereotype.Repository;

/**
 * 计划表Repository实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:20
 */
@Repository
public class PlanRepositoryImpl extends ServiceImpl<PlanMapper, Plan> implements PlanRepository {

}


