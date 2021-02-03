package com.hoe.sentient.api.user;

import com.hoe.sentient.api.BaseTest;
import com.hoe.sentient.common.base.ItemListRecord;
import com.hoe.sentient.facade.user.PartnerFacade;
import com.hoe.sentient.facade.user.dto.PartnerDTO;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * PartnerTest
 *
 * @Author Gavin
 * @Date 2021/2/2 5:56 下午
 */
public class PartnerTest extends BaseTest {
    @Resource
    private PartnerFacade partnerFacade;

    @Test
    public void queryPartners() {
        ItemListRecord<PartnerDTO> partnerDTOItemListRecord = partnerFacade.queryPartners(1L);
        System.out.println(partnerDTOItemListRecord);
    }

}
