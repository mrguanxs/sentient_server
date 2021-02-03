package com.hoe.sentient.common.result;

import java.io.Serializable;

/**
 * TODO
 *
 * @Author Gavin
 * @Date 2021/2/2 3:58 下午
 */
public interface IResultCodeEnum extends IEnum {

    int value();

    String desc();

    @Override
    default Serializable getValue() {
        return value();
    }

    default String resDesc() {
//        String msg = Resources.getMessage("MSGCODE_" + this.value());
//        if (StringUtils.isEmpty(msg)) {
//            msg = this.desc();
//        }
        return this.desc();
    }
}
