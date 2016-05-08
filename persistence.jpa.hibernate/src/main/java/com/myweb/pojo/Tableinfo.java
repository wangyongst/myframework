package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangy on 2016/5/8.
 */
@Entity
public class Tableinfo {
    private int id;
    private String tablename;
    private String columnname;
    private String chinese;
    private String type;
    private Integer shunxu;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tablename", nullable = true, length = 255)
    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    @Basic
    @Column(name = "columnname", nullable = true, length = 255)
    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    @Basic
    @Column(name = "chinese", nullable = true, length = 255)
    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "shunxu", nullable = true)
    public Integer getShunxu() {
        return shunxu;
    }

    public void setShunxu(Integer shunxu) {
        this.shunxu = shunxu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tableinfo tableinfo = (Tableinfo) o;

        if (id != tableinfo.id) return false;
        if (tablename != null ? !tablename.equals(tableinfo.tablename) : tableinfo.tablename != null) return false;
        if (columnname != null ? !columnname.equals(tableinfo.columnname) : tableinfo.columnname != null) return false;
        if (chinese != null ? !chinese.equals(tableinfo.chinese) : tableinfo.chinese != null) return false;
        if (type != null ? !type.equals(tableinfo.type) : tableinfo.type != null) return false;
        if (shunxu != null ? !shunxu.equals(tableinfo.shunxu) : tableinfo.shunxu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tablename != null ? tablename.hashCode() : 0);
        result = 31 * result + (columnname != null ? columnname.hashCode() : 0);
        result = 31 * result + (chinese != null ? chinese.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shunxu != null ? shunxu.hashCode() : 0);
        return result;
    }
}
