package com.xajiusuo.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class Page {

    // 页数（第几页）
    private int currentpage;

    // 数据总条数
    private int total;

    // 每页大小
    private int size;

    // 下页
    private int next;

    // 最后一页,总页数
    private int totalpage;

    private List<Object> list;

    public Page() {
        super();
    }

    public int getCurrentpage() {
        return currentpage;
    }

    /****
     *
     * @param currentpage
     * @param total
     * @param pagesize
     */
    public void setCurrentpage(int currentpage, int total, int pagesize) {
        //总记录数
        this.total = total;
        //每页显示多少条
        this.size = pagesize;

        //如果整除表示正好分N页，如果不能整除在N页的基础上+1页
        int totalPages = total % pagesize == 0 ? total / pagesize : (total / pagesize) + 1;

        //总页数
        this.totalpage = totalPages;

        //判断当前页是否越界,如果越界，我们就查最后一页
        if (currentpage > totalPages) {
            this.currentpage = totalPages;
        } else {
            this.currentpage = currentpage;
        }
        if (currentpage <= 0) {
            this.currentpage = 1;
        }

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNext() {
        return currentpage < totalpage ? currentpage + 1 : totalpage;
    }


    //上一页
    public int getUpper() {
        return currentpage > 1 ? currentpage - 1 : currentpage;
    }

    public int getLast() {
        return totalpage;
    }

    //总共有多少页，即末页
    public void setLast(int last) {
        this.totalpage = total % size == 0 ? total / size : (total / size) + 1;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}