package com.igeek.ch07.trans.dao;

import com.igeek.ch07.trans.exception.AccountException;
import com.igeek.ch07.trans.exception.BookStockException;

public interface IBookShopDao {

    public int selectPrice(int bookId);
    public void updateStock(int bookId) throws BookStockException;
    public void updateBalance(String username, int price) throws AccountException;

}