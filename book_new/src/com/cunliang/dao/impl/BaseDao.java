package com.cunliang.dao.impl;

import com.cunliang.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    QueryRunner queryRunner = new QueryRunner();

    /**
     * 用来执行insert，update，delete语句。
     * @param sql
     * @param args
     * @return 返回-1说明执行失败，否则返回受影响的行数。
     */

    public int update(String sql,Object ...args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }


    /**
     *
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回类型的泛型
     * @return
     */

    public <T> T queryForOne(Class<T> type,String sql,Object ...args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    public <T>List<T> queryForList(Class<T> type,String sql,Object ...args){

        Connection connection =  JdbcUtils.getConnection();
        try {
            return  queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    public Object queryForSingleValue(String sql,Object ... args){

        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }




}

