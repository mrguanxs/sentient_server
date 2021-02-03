package com.hoe.sentient.facade.mood;

import com.hoe.sentient.mood.dao.GuestBookRepository;
import com.hoe.sentient.mood.service.GuestBookService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 留言表Facade
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:01
 */
@Component
public class GuestBookFacade {
    @Resource
    private GuestBookService guestBookService;
    @Resource
    private GuestBookRepository guestBookRepository;

}
