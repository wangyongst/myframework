package com.framework.utils.db.dialect.impl;

import com.framework.utils.db.sql.Wrapper;




/**
 * SqlLite3方言
 * @author 
 *
 */
public class PostgresqlDialect extends AnsiSqlDialect{
	public PostgresqlDialect() {
		wrapper = new Wrapper('"');
	}

}
