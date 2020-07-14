package com.igeek.ch07.trans.service;

import java.util.List;

import javax.annotation.Resource;
import com.igeek.ch07.trans.exception.AccountException;
import com.igeek.ch07.trans.exception.BookStockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashierService")
public class CashierServiceImpl implements ICashierService {
    @Resource
    private IBookShopService bookShopService;

    @Transactional
    @Override
    public void cash(String username, List<Integer> bookIds) throws AccountException, BookStockException {
        for (Integer bookId : bookIds) {
            bookShopService.purchase(username, bookId);
        }
    }

}