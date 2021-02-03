package com.hoe.sentient.facade.user;

import com.hoe.sentient.common.base.ItemListRecord;
import com.hoe.sentient.common.util.GeneralAssembler;
import com.hoe.sentient.facade.user.dto.PartnerDTO;
import com.hoe.sentient.user.dao.PartnerRepository;
import com.hoe.sentient.user.domain.entity.Partner;
import com.hoe.sentient.user.service.PartnerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * 好友表Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:44:38
 */
@Component
public class PartnerFacade {
    @Resource
    private PartnerService partnerService;
    @Resource
    private PartnerRepository partnerRepository;

    public ItemListRecord<PartnerDTO> queryPartners(Long userId) {
        List<Partner> partnerList = partnerRepository.queryPartners(userId);
        return new GeneralAssembler<>(PartnerDTO.class).convertItemListFrom(partnerList);
    }
}
