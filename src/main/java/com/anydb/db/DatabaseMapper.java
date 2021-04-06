package com.anydb.db;

import org.apache.ibatis.annotations.*;

/**
 * @author Mairuis
 * @since 2021/4/7
 */
@Mapper
public interface DatabaseMapper {

    @Select("SHOW CREATE TABLE ${tableName}")
    @Results({
            @Result(property = "table", column = "Table", javaType = String.class),
            @Result(property = "createTable", column = "Create Table", javaType = String.class)
    })
    DatabaseStatement getTableCreateStatement(@Param("tableName") String tableName);

}
