package com.hoe.sentient.heart.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoe.sentient.heart.dao.HeartBeatRepository;
import com.hoe.sentient.heart.domain.entity.HeartBeat;
import com.hoe.sentient.heart.mapper.HeartBeatMapper;
import org.springframework.stereotype.Repository;

/**
 * 心动表Repository实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:45:43
 */
@Repository
public class HeartBeatRepositoryImpl extends ServiceImpl<HeartBeatMapper, HeartBeat> implements HeartBeatRepository {

}


