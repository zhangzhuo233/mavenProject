package com.bd.jdbcTest;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: connectionTest
 * @description: druid连接池使用
 * @author: Mr.zhang
 * @create: 2019-08-30 10:18
 **/
public class PoolTest {
    static Properties properties = new Properties();
    static DataSource dataSource = null;
    static {
        try {
            properties.load(PoolTest.class.getClassLoader().getResourceAsStream("druid.properties"));
            // 创建连接池(数据源)
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("cactch1");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch2");
        }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 获取连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            String sql = "select count(distinct bname) count from book";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("catch3");
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (resultSet != null)
                    resultSet.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        // System.out.println("啊".getBytes("ASCII").length);
    }
}
