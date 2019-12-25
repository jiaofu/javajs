package com.page.shui.fenye.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class AdminResult<T> {
    /**
     * 0 是成功 (和api 保持统一)
     */
    private int code;
    private T data;
    private String msg;
    private long ts;

    public AdminResult(){
        this.code = 0;
        this.ts = System.currentTimeMillis();
    }
    public AdminResult(T t){
        this.code = 0;
        this.ts = System.currentTimeMillis();
        this.data = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
      return   JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
    }
}
