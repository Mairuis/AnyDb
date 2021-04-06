package com.anydb.db;

/**
 * @author Mairuis
 * @since 2021/4/6
 */
public class DatabaseTrees {

    public static DatabaseInfo getModelDatabase() {
        return new DatabaseInfo()
                .setUrl("jdbc:mysql://localhost:3306/position-system")
                .setUserName("root")
                .setPassword("root");
    }

}
