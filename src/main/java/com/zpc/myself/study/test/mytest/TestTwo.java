package com.zpc.myself.study.test.mytest;

public class TestTwo {
    public static void main(String[] args) {
//        One two = new Two();
//        System.out.println(two);
//        System.out.println("===========");
//        two = new Two();
//        System.out.println(two);
        String s1 = "hello";
        System.out.println(s1);
        String s2 = "he" + new String("llo");
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

class One {
    static {
        System.out.println("1");
    }
    public One() {
        System.out.println("2");
    }

}

class Two extends One {
    static {
        System.out.println("a");
    }
    public Two() {
        System.out.println("b");
    }

}



