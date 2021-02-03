package com.hoe.sentient.mood.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoe.sentient.mood.dao.GuestBookRepository;
import com.hoe.sentient.mood.domain.entity.GuestBook;
import com.hoe.sentient.mood.mapper.GuestBookMapper;
import org.springframework.stereotype.Repository;

/**
 * 留言表Repository实现
 *
 * @author: Gavin
 * @date: 2021-01-28 16:46:01
 */
@Repository
public class GuestBookRepositoryImpl extends ServiceImpl<GuestBookMapper, GuestBook> implements GuestBookRepository {

}


