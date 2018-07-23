package com.kristoff.common.vo;

import java.util.List;

public class BasicListResponseVO<T> extends BasicResponseVO {
    private List<T> data;

    public BasicListResponseVO(List<T> data) {
        super(STATUS_OK, "", MESSAGE_OK);
        this.setData(data);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
