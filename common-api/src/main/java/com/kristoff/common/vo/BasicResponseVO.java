package com.kristoff.common.vo;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

public class BasicResponseVO implements Serializable {

    public static final int STATUS_ERROR = 0;
    public static final int STATUS_OK = 1;
    public static final int STATUS_NO_DATA = 99;
    public static final int STATUS_NO_RIGHT = 403;

    public static final String MESSAGE_OK = "Successfully";
    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_NO_DATA = "No data found";
    public static final String MESSAGE_NO_RIGHT = "You have no right.";

    private int status;
    private String messageCode;
    private String messageText;

    public BasicResponseVO() {

    }

    protected BasicResponseVO(int status, String messageCode, String messageText) {
        this.status = status;
        this.messageCode = messageCode;
        this.messageText = messageText;
        if(this.status == STATUS_ERROR && this.messageText == null) {
            this.messageText = MESSAGE_ERROR;
        } else if(this.status == STATUS_OK && this.messageText == null) {
            this.messageText = MESSAGE_OK;
        } else if(this.status == STATUS_NO_RIGHT && this.messageText == null) {
            this.messageText = MESSAGE_NO_RIGHT;
        } else if(this.status == STATUS_NO_DATA && this.messageText == null) {
            this.messageText = MESSAGE_NO_DATA;
        }
    }

    public static BasicResponseVO ok() {
        return new BasicResponseVO(STATUS_OK, "", MESSAGE_OK);
    }

    public static <T> BasicObjectResponseVO ok(T data) {
        return new BasicObjectResponseVO<T>(data);
    }

    public static <T> BasicListResponseVO ok(List<T> data) {
        return new BasicListResponseVO<>(data);
    }

    public static <T> BasicPagedResponseVO ok(PageInfo<T> data) {
        return new BasicPagedResponseVO<>(data);
    }

    public static BasicResponseVO error(String messgeCode, String messageText) {
        return new BasicResponseVO(STATUS_ERROR, messgeCode, messageText);
    }

    public static BasicResponseVO nodata() {
        return new BasicResponseVO(STATUS_NO_DATA, null, MESSAGE_NO_DATA);
    }

    public static BasicResponseVO nodata(String messgeCode, String messageText) {
        return new BasicResponseVO(STATUS_NO_DATA, messgeCode, messageText);
    }

    public static BasicResponseVO noright(String messgeCode, String messageText) {
        return new BasicResponseVO(STATUS_NO_RIGHT, messgeCode, messageText);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
