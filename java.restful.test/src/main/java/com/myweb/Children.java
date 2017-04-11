package com.myweb;

/**
 * Created by BHWL on 2017-01-13.
 */
public class Children extends Father{
    public String getCname() {
        return getFname();
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Children(){
        cname = getFname();
    }

    private String cname;

    public static void main(String[] args) {
        Children children = new Children();
        children.setFname("fname");
        //Children children = (Children)father;
        System.out.println(children.getCname());
    }

}
