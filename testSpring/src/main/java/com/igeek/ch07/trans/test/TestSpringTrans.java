package com.igeek.ch07.trans.test;

import com.igeek.ch07.trans.dao.IBookShopDao;
import com.igeek.ch07.trans.exception.AccountException;
import com.igeek.ch07.trans.exception.BookStockException;
import com.igeek.ch07.trans.service.IBookShopService;
import com.igeek.ch07.trans.service.ICashierService;
import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringTrans {

    private ApplicationContext ac;
    private IBookShopDao bookShopDao;
    private IBookShopService bookShopService;
    private ICashierService cashierService;

    {
        ac = new ClassPathXmlApplicationContext("beans_trans.xml");
        bookShopDao = (IBookShopDao)ac.getBean("bookShopDao");
        bookShopService = (IBookShopService)ac.getBean("bookShopService");
        cashierService = (ICashierService)ac.getBean("cashierService");
    }

    @Test
    public void testSelectPrice() {
        int price = bookShopDao.selectPrice(1);
        System.out.println(price);
    }

    @Test
    public void testUpdateStock() throws BookStockException {
        bookShopDao.updateStock(1);
    }

    @Test
    public void testUpdateBalance() throws AccountException {
        bookShopDao.updateBalance("张三", 40);
    }

    @Test
    public void testPurchase() throws AccountException, BookStockException {
        bookShopService.purchase("张三", 1);
    }

    @Test
    public void testCash() throws AccountException, BookStockException {
        cashierService.cash("张三", Arrays.asList(1,2));
    }

}