package com.hoe.sentient.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hoe.sentient.common.base.ItemListRecord;
import com.hoe.sentient.common.base.PagerRecord;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @Author Gavin
 * @Date 2021/1/28 7:04 下午
 */
public class GeneralAssembler<T> {
    private Class<T> targetClz;

    public GeneralAssembler(Class<T> targetClz) {
        this.targetClz = targetClz;
    }

    public T convertFrom(Object source) {
        if (source == null) {
            return null;
        } else {
            try {
                T target = this.targetClz.newInstance();
                BeanUtilsEx.copyPropertiesEx(source, target, new String[0]);
                return target;
            } catch (Exception var3) {
                throw new RuntimeException(var3.getMessage());
            }
        }
    }

    public T convertFromAndAesDecrypt(Object source, String key) {
        if (source == null) {
            return null;
        } else {
            try {
                T target = this.targetClz.newInstance();
                BeanUtilsEx.copyPropertiesExDecrypt(source, target, key, new String[0]);
                return target;
            } catch (Exception var4) {
                throw new RuntimeException(var4.getMessage());
            }
        }
    }

    public T convertNotNullFrom(Object source) {
        try {
            T target = this.targetClz.newInstance();
            if (source == null) {
                return target;
            } else {
                BeanUtilsEx.copyPropertiesEx(source, target, new String[0]);
                return target;
            }
        } catch (Exception var3) {
            throw new RuntimeException(var3.getMessage());
        }
    }

    public PagerRecord<T> convertPagerFromAndAesDecrypt(IPage sourceIpage, String key) {
        try {
            if (sourceIpage == null) {
                return null;
            } else {
                List<T> targetList = new ArrayList();
                Iterator var4 = sourceIpage.getRecords().iterator();

                while(var4.hasNext()) {
                    Object source = var4.next();
                    T target = this.convertFromAndAesDecrypt(source, key);
                    targetList.add(target);
                }

                return (new PagerRecord()).valueOf(sourceIpage, targetList);
            }
        } catch (Exception var7) {
            throw new RuntimeException(var7.getMessage());
        }
    }

    public PagerRecord<T> convertPagerFrom(IPage sourceIpage) {
        try {
            if (sourceIpage == null) {
                return null;
            } else {
                List<T> targetList = new ArrayList();
                Iterator var3 = sourceIpage.getRecords().iterator();

                while(var3.hasNext()) {
                    Object source = var3.next();
                    T target = this.convertFrom(source);
                    targetList.add(target);
                }

                return (new PagerRecord()).valueOf(sourceIpage, targetList);
            }
        } catch (Exception var6) {
            throw new RuntimeException(var6.getMessage());
        }
    }

    public ItemListRecord<T> convertItemListFromAndAesDecrypt(List sourceList, String key) {
        if (sourceList == null) {
            return null;
        } else {
            List<T> targetList = new ArrayList();
            Iterator var4 = sourceList.iterator();

            while(var4.hasNext()) {
                Object source = var4.next();
                T target = this.convertFrom(source);
                BeanUtilsEx.copyPropertiesExDecrypt(source, target, key, new String[0]);
                targetList.add(target);
            }

            return (new ItemListRecord()).valueOf(targetList);
        }
    }

    public ItemListRecord<T> convertItemListFrom(List sourceList) {
        if (sourceList == null) {
            return null;
        } else {
            List<T> targetList = new ArrayList();
            Iterator var3 = sourceList.iterator();

            while(var3.hasNext()) {
                Object source = var3.next();
                T target = this.convertFrom(source);
                BeanUtilsEx.copyPropertiesEx(source, target, new String[0]);
                targetList.add(target);
            }

            return (new ItemListRecord()).valueOf(targetList);
        }
    }

    public ItemListRecord<T> convertItemListFrom(ItemListRecord sourceItemList) {
        if (sourceItemList == null) {
            return null;
        } else {
            List<T> targetList = new ArrayList();
            Iterator var3 = sourceItemList.getRecordList().iterator();

            while(var3.hasNext()) {
                Object source = var3.next();
                T target = this.convertFrom(source);
                BeanUtilsEx.copyPropertiesEx(source, target, new String[0]);
                targetList.add(target);
            }

            return (new ItemListRecord()).valueOf(targetList);
        }
    }

    public List<T> convertListFrom(List sourceList) {
        if (sourceList == null) {
            return null;
        } else {
            List<T> targetList = new ArrayList();
            Iterator var3 = sourceList.iterator();

            while(var3.hasNext()) {
                Object source = var3.next();
                T target = this.convertFrom(source);
                BeanUtilsEx.copyPropertiesEx(source, target, new String[0]);
                targetList.add(target);
            }

            return targetList;
        }
    }
}
