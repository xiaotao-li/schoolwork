package com.igeek.ch07.trans.service;

import com.igeek.ch07.trans.exception.AccountException;
import com.igeek.ch07.trans.exception.BookStockException;

import java.util.List;

public interface ICashierService {

    public void cash(String username, List<Integer> bookIds) throws AccountException, BookStockException;
}