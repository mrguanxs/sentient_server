package com.hoe.sentient.common.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 *
 * @Author Gavin
 * @Date 2021/1/28 7:03 下午
 */
@Data
public class PagerRecord<T> {

    private List<T> recordList;
    private int itemCount;
    private int pageSize;
    private int currentPage;
    private int pages;

    public PagerRecord<T> valueOf(IPage iPage, List<T> newRecords) {
        this.setItemCount((int)iPage.getTotal());
        this.setCurrentPage((int)iPage.getCurrent());
        this.setPageSize((int)iPage.getSize());
        this.setPages((int)iPage.getPages());
        this.setRecordList(newRecords);
        return this;
    }
}
