package com.eloancn.test.testcase;
/**
 * Created by eloancn on 2018/6/1.
 */
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg {
    @Test
    public void test1(){
        System.out.println("套件测试1");
    }

    @Test
    public void test2(){
        System.out.println("套件测试2");
    }

    @Parameters(value = {"paramStr"})
    @Test
    public void test3(String name) {
        System.out.println(name);
    }

    @Parameters(value = {"paramStr"})
    @BeforeTest
    public void getParam(String name) {
        System.out.println(name);
    }


}
