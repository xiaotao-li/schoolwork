package com.igeek.ch05.om;

import com.igeek.pojo.OrdersCustom;

import java.util.List;

public interface OrdersAndDetailMapper {
    public List<OrdersCustom> find();

}
