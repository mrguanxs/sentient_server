package com.hoe.sentient.common.util;

/**
 * TODO
 *
 * @Author Gavin
 * @Date 2021/1/28 5:29 下午
 */
public class MyUtils {
    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        myUtils.abc(()->{return new Ha() {
            @Override
            public Ha getHa() {
                return null;
            }
        };
        });
    }

    public String abc(Ha ha){
        return "abc" + ha.toString();
    }



     static interface Ha{
        public Ha getHa();
    }


}
