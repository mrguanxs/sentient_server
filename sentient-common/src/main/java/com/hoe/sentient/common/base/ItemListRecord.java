package com.hoe.sentient.common.base;

import lombok.Data;

import java.util.List;

/**
 * TODO
 *
 * @Author Gavin
 * @Date 2021/1/28 7:01 下午
 */
@Data
public class ItemListRecord<T> {
    private List<T> recordList;

    public ItemListRecord<T> valueOf(List<T> newRecords) {
        this.setRecordList(newRecords);
        return this;
    }
}
