package com.hoe.sentient.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hoe.sentient.user.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * 用户表Mapper
 *
 * @author: Gavin
 * @date:  2021-01-28 16:43:34
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
