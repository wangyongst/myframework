package com.framework.utils.db;


import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.framework.utils.CollectionUtil;
import com.framework.utils.FileUtil;
import com.framework.utils.IoUtil;
import com.framework.utils.StrUtil;
import com.framework.utils.exceptions.DbRuntimeException;
import com.framework.utils.lang.Dict;




public class Entity extends Dict{
	private static final long serialVersionUID = -1951012511464327448L;
	
	//--------------------------------------------------------------- Static method start

	public static Entity create() {
		return new Entity();
	}
	
	
	public static Entity create(String tableName) {
		return new Entity(tableName);
	}
	
	
	public static <T> Entity parse(T vo) {
		return create(null).fromVo(vo);
	}
	//--------------------------------------------------------------- Static method end
	
	private String tableName;
	private List<String> fieldNames;
	
	//--------------------------------------------------------------- Constructor start
	public Entity() {
	}
	
	
	
	public Entity(String tableName) {
		this.tableName = tableName;
	}
	//--------------------------------------------------------------- Constructor end
	
	//--------------------------------------------------------------- Getters and Setters start
	public String getTableName() {
		return tableName;
	}
	
	public Entity setTableName(String tableName) {
		this.tableName = tableName;
		return this;
	}
	
	
	public List<String> getFieldNames() {
		return fieldNames;
	}
	
	public Entity setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
		return this;
	}
	
	
	public Entity setFieldNames(String... fieldNames) {
		this.fieldNames = Arrays.asList(fieldNames);
		return this;
	}
	
	public Entity addFieldNames(String... fieldNames) {
		final List<String> fieldList = Arrays.asList(fieldNames);
		if(null == this.fieldNames){
			this.fieldNames = fieldList;
		}else{
			this.fieldNames.addAll(fieldList);
		}
		return this;
	}
	
	//--------------------------------------------------------------- Getters and Setters end
	@Override
	public <T> Entity fromVo(T vo) {
		String tableName = vo.getClass().getSimpleName();
		tableName = StrUtil.lowerFirst(tableName);
		this.setTableName(tableName);
		
		return (Entity) super.fromVo(vo);
	}
	
	//-------------------------------------------------------------------- Put and Set start
	@Override
	public Object put(String key, Object value) {
		if(CollectionUtil.isEmpty(fieldNames) || fieldNames.contains(key)){
			super.put(key, value);
		}
		return super.put(key, value);
	}
	
	@Override
	public Entity set(String attr, Object value) {
		return (Entity) super.set(attr, value);
	}
	
	@Override
	public Entity setIgnoreNull(String attr, Object value) {
		return (Entity) super.setIgnoreNull(attr, value);
	}
	//-------------------------------------------------------------------- Put and Set end
	
	//-------------------------------------------------------------------- Get start
	
	public Clob getClob(String attr){
		return get(attr, null);
	}
	
	@Override
	public String getStr(String attr) {
		Object obj = get(attr);
		if(obj instanceof Clob){
			Clob clob = (Clob)obj;
			Reader reader = null;
			try {
				try {
					reader = clob.getCharacterStream();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return IoUtil.read(reader);
			} catch (IOException e) {
				throw new DbRuntimeException(e);
			}finally{
				FileUtil.close(reader);
			}
		}
		return super.getStr(attr);
	}
	
	//-------------------------------------------------------------------- Get end
	
	//-------------------------------------------------------------------- 特殊方法 start
	@Override
	public Entity clone() {
		return (Entity) super.clone();
	}
	//-------------------------------------------------------------------- 特殊方法 end
	
	@Override
	public String toString() {
		return "Entity {tableName=" + tableName + ", fieldNames=" + fieldNames + ", fields=" + super.toString() + "}";
	}
}
