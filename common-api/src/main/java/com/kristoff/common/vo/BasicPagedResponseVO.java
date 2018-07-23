package com.kristoff.common.vo;

import com.github.pagehelper.PageInfo;

public class BasicPagedResponseVO<T> extends BasicResponseVO {
    private PageInfo<T> data;

    public BasicPagedResponseVO(PageInfo<T> data) {
        super(STATUS_OK, "", MESSAGE_OK);
        this.setData(data);
    }

    public PageInfo<T> getData() {
        return data;
    }

    public void setData(PageInfo<T> data) {
        this.data = data;
    }
}
