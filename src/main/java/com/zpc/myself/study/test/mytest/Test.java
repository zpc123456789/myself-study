package com.zpc.myself.study.test.mytest;

import lombok.Data;

public class Test {
    public static void main(String[] args) {
        Dog dog1 = new Dog("1");
        Dog dog2 = new Dog("1");

        System.out.println(dog1 == dog2);

//        System.out.println("a".equals("b"));
//        System.out.println("a" == "b");
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(dog1.equals(dog2));

    }
}

@Data
class Dog{
    private String name;
    public Dog() {

    }
    public Dog(String name) {

        this.name = name;
    }
}
