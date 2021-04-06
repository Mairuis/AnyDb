package com.anydb;

import com.anydb.db.DatabaseClientManager;
import com.anydb.db.DatabaseInfo;
import com.anydb.db.DatabaseTrees;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * @author Mairuis
 * @since 2021/4/6
 */
public class AnyDB {

    private static volatile AnyDB INSTANCE;

    public static AnyDB getInstance() {
        if (INSTANCE == null) {
            synchronized (AnyDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AnyDB();
                }
            }
        }
        return INSTANCE;
    }

    private AnyDB() {

    }

    public void startup() {
        DatabaseClientManager instance = DatabaseClientManager.INSTANCE;
    }



}
