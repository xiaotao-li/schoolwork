package com.igeek.ch03.prop;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) throws SQLException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans_ch03_prop.xml");
        ComboPooledDataSource dataSource = ac.getBean(ComboPooledDataSource.class);
        System.out.println(dataSource);
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        PreparedStatement preparedStatement = connection.prepareStatement("select name from t_dept where id=?");
        preparedStatement.setInt(1,2);
        connection.setSavepoint("sp");
        ResultSet resultSet = preparedStatement.executeQuery();
        connection.rollback();

        while (resultSet.next()){
            String name = resultSet.getString(1);
            System.out.println(name);
        }

        connection.commit();

        if(resultSet!=null){
            resultSet.close();
        }
        if(preparedStatement!=null){
            preparedStatement.close();
        }
        if(connection!=null){
            connection.close();
        }
        if(dataSource!=null){
            dataSource.close();
        }
    }

}
