package com.ztiany.springf.test.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:transaction3.xml")

public class Transaction3Test {

    @Resource(name = "accountService")
    private AccountService as;

    @Test
    public void fun1() {
        as.transfer(1, 2, 100d);
    }

}
