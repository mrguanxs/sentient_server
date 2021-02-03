package com.hoe.sentient.mood.service.impl;

import com.hoe.sentient.mood.dao.MoodRepository;
import com.hoe.sentient.mood.service.MoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 空间表Service实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:56
 */
@Service
public class MoodServiceImpl implements MoodService {
    @Resource
    private MoodRepository moodRepository;

}
