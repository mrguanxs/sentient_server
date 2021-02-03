package com.hoe.sentient.user.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoe.sentient.user.dao.PartnerRepository;
import com.hoe.sentient.user.domain.entity.Partner;
import com.hoe.sentient.user.mapper.PartnerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 好友表Repository实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:38
 */
@Repository
public class PartnerRepositoryImpl extends ServiceImpl<PartnerMapper, Partner> implements PartnerRepository {

    @Override
    public List<Partner> queryPartners(Long userId) {
        LambdaQueryWrapper<Partner> query = new LambdaQueryWrapper<>();
        query.eq(Partner::getUserId, userId);
        return list(query);
    }
}


