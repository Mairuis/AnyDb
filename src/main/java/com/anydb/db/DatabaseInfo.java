package com.anydb.db;

import com.mysql.jdbc.Driver;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Mairuis
 * @since 2021/4/6
 */
@Data
@Accessors(chain = true)
public class DatabaseInfo {
    private String password;
    private String userName;
    private String url;
    private String driver = Driver.class.getName();
}
