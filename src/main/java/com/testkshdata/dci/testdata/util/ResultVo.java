package com.testkshdata.dci.testdata.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

@Data
public class ResultVo<T> {
    private int code;//状态码
    private String msg;//失败原因
    private T data;  //数据值

    public static <T> ResultVo parseResultJsonArray(String json,Class<T> clazz) {
        JSONObject jsonObject = JSON.parseObject(json);
        //data 属性值 取出来，得到json字符串 转化为java对象
        Object jsonData = jsonObject.get("data");
        List<T> list = null;
        if (jsonData!=null){
            list = JSONObject.parseArray(jsonData.toString(),clazz);
        }
        int code = (Integer) jsonObject.get("code");
        String msg = (String) jsonObject.get("msg");
        return new ResultVo(code,msg,list);
    }
        //将resultVo
    public static <T> ResultVo parseResultJson(String json,Class<T> clazz){
        if (json == null || "".equals(json)){
            return ResultVo.error(CodeMsg.ERROR);
        }
        JSONObject jsonObject = JSON.parseObject(json);
        //data 属性值 取出来，得到json字符串 转化为java对象
        Object jsonData = jsonObject.get("data");

        T value = null;
        if (jsonData!=null){
            if (clazz==int.class||clazz==Integer.class){
                value = (T)((Integer)jsonData);
            }else if (clazz==long.class||clazz==Long.class){
                value = (T)((Long)jsonData);
            }else if (clazz==String.class){
                value = (T)((String)jsonData);
            }else if (clazz==boolean.class||clazz==Boolean.class){
                value = (T)((Boolean)jsonData);
            }else {
                JSONObject obj = (JSONObject)jsonData;
                value = JSON.parseObject(obj.toJSONString(),clazz);
            }

        }

        int code = (Integer) jsonObject.get("code");
        String msg = (String) jsonObject.get("msg");
        return new ResultVo(code,msg,value);
    }

    private ResultVo(){

    }
    private ResultVo(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = (T) data;
    }

    public static ResultVo success(Object data){
       return new ResultVo(200,"ok",data);
    }

    public static ResultVo success(){
        return new ResultVo(200,"ok",null);
    }

    public static ResultVo error(CodeMsg codeMsg){
        return new ResultVo(codeMsg.getCode(),codeMsg.getMsg(),null);
    }
}
