package com.hoe.sentient.mood.service.impl;

import com.hoe.sentient.mood.dao.GuestBookRepository;
import com.hoe.sentient.mood.service.GuestBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 留言表Service实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:01
 */
@Service
public class GuestBookServiceImpl implements GuestBookService {
    @Resource
    private GuestBookRepository guestBookRepository;

}
