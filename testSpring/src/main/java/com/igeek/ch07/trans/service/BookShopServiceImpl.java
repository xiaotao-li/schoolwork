package com.igeek.ch07.trans.service;


import javax.annotation.Resource;
import com.igeek.ch07.trans.dao.IBookShopDao;
import com.igeek.ch07.trans.exception.AccountException;
import com.igeek.ch07.trans.exception.BookStockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;

@Service("bookShopService")
public class BookShopServiceImpl implements IBookShopService {
    @Resource
    private IBookShopDao bookShopDao;


    @Transactional(propagation= Propagation.REQUIRES_NEW,
            isolation= Isolation.READ_COMMITTED,
            rollbackFor={IOException.class, SQLException.class},
            noRollbackFor={ArithmeticException.class},
            readOnly=false,
            timeout=3)
    @Override
    public void purchase(String username, int bookId) throws BookStockException, AccountException {
        int price = bookShopDao.selectPrice(bookId);
        bookShopDao.updateStock(bookId);
        bookShopDao.updateBalance(username, price);
    }

}
