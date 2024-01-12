package com.hoe.sentient.user.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hoe.sentient.user.domain.entity.Partner;

import java.util.List;

/**
 *
 * 好友表Repository
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:38
 */
public interface PartnerRepository extends IService<Partner> {

    List<Partner> queryPartners(Long userId);
}
