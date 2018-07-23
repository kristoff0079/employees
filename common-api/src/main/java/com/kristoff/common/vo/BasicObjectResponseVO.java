package com.kristoff.common.vo;

public class BasicObjectResponseVO<T> extends BasicResponseVO {

    private T data;

    public BasicObjectResponseVO(T data) {
        super(STATUS_OK, "", MESSAGE_OK);
        this.setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
