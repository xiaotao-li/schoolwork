package com.igeek.ch07.trans.service;

import com.igeek.ch07.trans.exception.AccountException;
import com.igeek.ch07.trans.exception.BookStockException;

public interface IBookShopService {

    public void purchase(String username, int bookId) throws BookStockException, AccountException;
}
