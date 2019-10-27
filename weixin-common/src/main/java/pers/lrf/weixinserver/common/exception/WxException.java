package pers.lrf.weixinserver.common.exception;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lirufeng
 * @date 2019/10/18 11:14
 **/
@Data
@Slf4j
public class WxException extends Exception {

    private String json;
    private String errorCode;
    private String errorMsg;
    private String errorMsgCn;

    public WxException(String json){
        this.json=json;
        handleJson(json);
    }

    private void handleJson(String json) {
        JSONObject object = JSONObject.parseObject(json);
        this.errorCode = object.getString("errcode");
        this.errorMsg = object.getString("errmsg");
        this.errorMsgCn = CodeMeans.getExceptionOfCode(errorCode);
    }

    @Override
    public String toString(){
        log.error("errorCode:"+errorCode+", errorMsg:"+errorMsg+", errorMsgCn:"+errorMsgCn);
        return "errorCode:"+errorCode+", errorMsg:"+errorMsg+", errorMsgCn:"+errorMsgCn;
    }
}
