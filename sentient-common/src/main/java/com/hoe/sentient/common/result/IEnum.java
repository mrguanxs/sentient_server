package com.hoe.sentient.common.result;

import java.io.Serializable;

/**
 * TODO
 *
 * @Author Gavin
 * @Date 2021/2/2 4:16 下午
 */
public interface IEnum<T extends Serializable> {

    T getValue();
}
