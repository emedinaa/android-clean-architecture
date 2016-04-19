package com.emedinaa.perutravel.data.model;

/**
 * Created by emedinaa on 16/04/16.
 */
public class BaseResponse {

    private static final int SUCCESS=0;
    private int code;
    private String message;


    public boolean isSuccess()
    {
        if(this.code==SUCCESS)return true;
        return false;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
