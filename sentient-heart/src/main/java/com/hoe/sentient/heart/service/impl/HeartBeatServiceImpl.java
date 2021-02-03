package com.hoe.sentient.heart.service.impl;

import com.hoe.sentient.heart.dao.HeartBeatRepository;
import com.hoe.sentient.heart.service.HeartBeatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 心动表Service实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:45:43
 */
@Service
public class HeartBeatServiceImpl implements HeartBeatService {
    @Resource
    private HeartBeatRepository heartBeatRepository;

}
