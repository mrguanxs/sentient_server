package com.hoe.sentient.user.service.impl;

import com.hoe.sentient.user.dao.PartnerRepository;
import com.hoe.sentient.user.service.PartnerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 好友表Service实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:38
 */
@Service
public class PartnerServiceImpl implements PartnerService {
    @Resource
    private PartnerRepository partnerRepository;

}
