package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by BHWL on 2016-12-19.
 */
@Entity
public class Menu {
    private int id;
    private String name;
    private String url;
    private Integer parent;
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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "parent", nullable = true)
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
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

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        if (name != null ? !name.equals(menu.name) : menu.name != null) return false;
        if (url != null ? !url.equals(menu.url) : menu.url != null) return false;
        if (parent != null ? !parent.equals(menu.parent) : menu.parent != null) return false;
        if (shunxu != null ? !shunxu.equals(menu.shunxu) : menu.shunxu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (shunxu != null ? shunxu.hashCode() : 0);
        return result;
    }
}
