package com.insightfullogic.java8.examples.chapter4;

// BEGIN body
public class OverridingChild extends OverridingParent implements Child {

    // todo 注意这种重载，类中重写的方法更具体
    public static void main(String[] args) {
        OverridingChild child = new OverridingChild();

        //调用了继承的父类的接口
        child.welcome();
        String lastMessage = child.getLastMessage();
        System.out.println(lastMessage);
    }

}
// END body
