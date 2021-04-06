package com.anydb.db;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author Mairuis
 * @since 2021/4/7
 */
public enum DatabaseClientManager {

    INSTANCE;

    DatabaseClientManager() {
        initDatabaseClient();
    }


    private SqlSessionFactory initSessionFactory(DatabaseInfo databaseInfo) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        PooledDataSource dataSource = new PooledDataSource(databaseInfo.getDriver(), databaseInfo.getUrl(), databaseInfo.getUserName(), databaseInfo.getPassword());
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(DatabaseMapper.class);
        return new SqlSessionFactoryBuilder().build(configuration);
    }

    private void initDatabaseClient() {
        SqlSessionFactory modelDbSessionFactory = initSessionFactory(DatabaseTrees.getModelDatabase());
        System.out.println(modelDbSessionFactory.openSession().getMapper(DatabaseMapper.class).getTableCreateStatement("student"));
    }

}
