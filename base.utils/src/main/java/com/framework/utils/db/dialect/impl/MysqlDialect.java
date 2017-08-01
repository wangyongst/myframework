package com.framework.utils.db.dialect.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;


import com.framework.utils.StrUtil;
import com.framework.utils.db.DbUtil;
import com.framework.utils.db.Entity;
import com.framework.utils.db.Page;
import com.framework.utils.db.sql.Order;
import com.framework.utils.db.sql.SqlBuilder;
import com.framework.utils.db.sql.SqlBuilder.LogicalOperator;
import com.framework.utils.db.sql.Wrapper;
import com.framework.utils.exceptions.DbRuntimeException;


/**
 * MySQL方言
 * @author 
 *
 */
public class MysqlDialect extends AnsiSqlDialect{
	
	public MysqlDialect() {
		wrapper = new Wrapper('`');
	}

	@Override
	public PreparedStatement psForPage(Connection conn, Collection<String> fields, Entity where, Page page) throws SQLException {
		//验证
		if(where == null || StrUtil.isBlank(where.getTableName())) {
			throw new DbRuntimeException("Table name is null !");
		}
		
		final SqlBuilder find = SqlBuilder.create(wrapper)
				.select(fields)
				.from(where.getTableName())
				.where(LogicalOperator.AND, DbUtil.buildConditions(where));
		
		final Order order = page.getOrder();
		if(null != order){
			find.orderBy(order);
		}
		
		find.append(" LIMIT ").append(page.getStartPosition()).append(", ").append(page.getNumPerPage());
		
		final PreparedStatement ps = conn.prepareStatement(find.build());
		DbUtil.fillParams(ps, find.getParamValueArray());
		return ps;
	}
}
