package pers.lrf.weixinserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.lrf.weixinserver.common.interceptor.CheckUtil;

/**
 * @author lirufeng
 * @date 2019/10/7 11:57
 **/
public abstract class BaseController {

    protected class ResultJson<T> {
        private int code = 200;                                //状态码
        private String msg = "暂无信息";                       //信息
        private T rt;                                          //结果封装

        public ResultJson() {
        }

        public ResultJson(String msg, T rt) {
            this.msg = msg;
            this.rt = rt;
        }

        public ResultJson setSuccess(T rt) {
            this.code = 200;
            this.rt = rt;
            return this;
        }

        public ResultJson setSuccessMsg(String successMsg, T rt) {
            this.code = 200;
            this.msg = successMsg;
            this.rt = rt;
            return this;
        }

        public ResultJson setErrorMsg(String errorMsg, T rt) {
            this.code = 500;
            this.msg = errorMsg;
            this.rt = rt;
            return this;
        }

        public ResultJson setErrorMsg(String errorMsg) {
            return setErrorMsg(errorMsg, null);
        }

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

        public T getRt() {
            return rt;
        }

        public void setRt(T rt) {
            this.rt = rt;
        }
    }
}
