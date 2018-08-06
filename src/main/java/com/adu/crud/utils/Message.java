package com.adu.crud.utils;

import java.util.HashMap;
import java.util.Map;

public class Message {
    /**
     * code=200成功代码，其它代码可以自定义
     */
    private int code;
    /**
     * 表示成功还是错误
     */
    private boolean isSuccess;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回前台数据源
     */
    private Map<String,Object> maps = new HashMap<>();

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public boolean isSuccess() {
        return isSuccess;
    }
    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    /**
     * 成功返回
     * @return
     */
    public static Message getSuccess() {
        Message message = new Message();
        message.setCode(200);
        message.isSuccess = true;
        message.setMsg("操作成功");
        return message;
    }
    /**
     * 错误返回
     * @return
     */
    public static Message getError() {
        Message message = new Message();
        message.setCode(100);
        message.isSuccess = false;
        message.setMsg("操作失败");
        return message;
    }
    /**
     * 数据源添加数据
     * @param key
     * @param value
     * @return
     */
    public Message addAttribute(String key,Object value) {
        maps.put(key,value);
        return this;
    }
}
