package com.pnlorf.datatable.entity;

import java.util.List;

/**
 * Description:dataTable返回值封装对象
 *
 * @author PNLORF
 * @version 1.0
 * @since 2016/2/2.
 */
public class DataTableResponse {

    // 总数
    private long iTotalRecords;

    // 经过搜索条件要显示的数据
    private long iTotalDispalyRecords;

    private List aaData;

    public long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public long getiTotalDispalyRecords() {
        return iTotalDispalyRecords;
    }

    public void setiTotalDispalyRecords(long iTotalDispalyRecords) {
        this.iTotalDispalyRecords = iTotalDispalyRecords;
    }

    public List getAaData() {
        return aaData;
    }

    public void setAaData(List aaData) {
        this.aaData = aaData;
    }
}
