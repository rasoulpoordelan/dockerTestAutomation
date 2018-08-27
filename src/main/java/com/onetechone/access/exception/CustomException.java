package com.onetechone.access.exception;


public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errMsg;

    private String msg;

    public CustomException(String errMsg) {
        this.errMsg = errMsg;
    }

    public CustomException(String errMsg, String msg) {

        this.errMsg = errMsg;
        this.msg = msg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
