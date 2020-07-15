package com.igeek.pojo;

import java.util.Date;
import java.util.List;

public class UserCustom extends User {

    private List<OrdersCustom> orderList;

    public UserCustom(){

    }

    public UserCustom(String username, String sex, Date birthday, String address, List<OrdersCustom> orderList) {
        super(username, sex, birthday, address);
        this.orderList = orderList;
    }

    public UserCustom(Integer id, String username, String sex, Date birthday, String address, List<OrdersCustom> orderList) {
        super(id, username, sex, birthday, address);
        this.orderList = orderList;
    }

    public List<OrdersCustom> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrdersCustom> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "UserCustom{" +
                super.toString() +
                ", orderList=" + orderList +
                '}';
    }
}
