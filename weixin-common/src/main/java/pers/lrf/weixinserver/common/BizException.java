package pers.lrf.weixinserver.common;

import lombok.Getter;

/**
 * desc
 */
@Getter
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    public BizException(String message) {
        super(message);
        this.message = message;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
