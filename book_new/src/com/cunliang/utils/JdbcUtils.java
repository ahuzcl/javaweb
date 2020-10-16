package com.cunliang.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

   private static DruidDataSource dataSource;

   static {

       try {
           Properties properties = new Properties();
           InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
           properties.load(resourceAsStream);

           //创建数据库连接池
           dataSource  = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

       } catch (Exception e) {
           e.printStackTrace();
       }


   }

    public static void main(String[] args) throws SQLException {

    }


    /**
     * 获取数据库连接池中的连接
     * @return
     */

    public static Connection getConnection()  {

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;
    }

    /**
     * 关闭连接
     * @param connection
     */
    public static void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
