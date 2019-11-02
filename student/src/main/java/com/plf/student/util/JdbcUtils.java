package com.plf.student.util;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 初始化数据库连接
 */
public class JdbcUtils {

    private static QueryRunner queryRunner;

    static {
        String dbFileName = "config/db.properties";
        HikariDataSource dataSource = new HikariDataSource();
        Configurations configs = new Configurations();
        try {
            Configuration properties = configs.properties(dbFileName);
            dataSource.setUsername(properties.getString("jdbc.username"));
            dataSource.setPassword(properties.getString("jdbc.password"));
            dataSource.setJdbcUrl(properties.getString("jdbc.url"));
            dataSource.setDriverClassName(properties.getString("jdbc.driver"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        queryRunner = new QueryRunner(dataSource);
    }

    public static <T> List<T> queryObjectList(String sql, Class<T> clazz, Object... params) {
        BeanListHandler<T> handler = new BeanListHandler<>(clazz);
        try {
            return queryRunner.query(sql, handler, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T queryObject(String sql, Class<T> clazz, Object... params) {
        BeanHandler<T> handler = new BeanHandler<>(clazz);
        try {
            return queryRunner.query(sql, handler, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int execute(String sql,Object... params){
        try {
            return queryRunner.execute(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
