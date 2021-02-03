package com.hoe.sentient.facade.mood;

import com.hoe.sentient.common.util.BeanUtilsEx;
import com.hoe.sentient.common.util.GeneralAssembler;
import com.hoe.sentient.mood.dao.MoodRepository;
import com.hoe.sentient.mood.domain.entity.Mood;
import com.hoe.sentient.mood.service.MoodService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 空间表Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:56
 */
@Component
public class MoodFacade {
    @Resource
    private MoodService moodService;
    @Resource
    private MoodRepository moodRepository;


}
