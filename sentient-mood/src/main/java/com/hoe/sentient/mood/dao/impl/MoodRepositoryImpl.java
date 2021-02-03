package com.hoe.sentient.mood.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoe.sentient.mood.dao.MoodRepository;
import com.hoe.sentient.mood.domain.entity.Mood;
import com.hoe.sentient.mood.mapper.MoodMapper;
import org.springframework.stereotype.Repository;

/**
 * 空间表Repository实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:56
 */
@Repository
public class MoodRepositoryImpl extends ServiceImpl<MoodMapper, Mood> implements MoodRepository {

}


