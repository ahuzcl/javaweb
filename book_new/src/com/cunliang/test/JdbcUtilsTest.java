package com.cunliang.test;

import com.cunliang.utils.JdbcUtils;
import org.junit.Test;

public class JdbcUtilsTest {

    @Test
    public void Test(){
        System.out.println(JdbcUtils.getConnection());

    }

}
