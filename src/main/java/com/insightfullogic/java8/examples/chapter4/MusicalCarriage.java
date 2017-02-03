package com.insightfullogic.java8.examples.chapter4;

// BEGIN body
public class MusicalCarriage
        implements Carriage, Jukebox {

    @Override
    public String rock() {

        // 多重继承的情况，将接口中包含相同签名的方法 必须进行重载
        return Carriage.super.rock();
    }

}
// END body
