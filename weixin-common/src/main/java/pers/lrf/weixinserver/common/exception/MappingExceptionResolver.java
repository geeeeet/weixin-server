package pers.lrf.weixinserver.common.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import pers.lrf.weixinserver.common.BizException;
import pers.lrf.weixinserver.common.utils.HttpUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author lirufeng
 * @date 2019/10/7 16:04
 **/
public class MappingExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (e instanceof BizException) {
            return this.bizExceptionHandler(httpServletRequest, httpServletResponse, o, e);
        } else {
            return this.defaultExceptionHandler(httpServletRequest, httpServletResponse, o, e);
        }
    }

    private ModelAndView bizExceptionHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        OutputStream output = null;
        try {
            output = response.getOutputStream();
            BizException exception = (BizException) ex;
            int status = exception.getCode() == 0 ? 50001 : exception.getCode();
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            ex.printStackTrace();
            output.write((status + "  " + ex.getMessage()).toString().getBytes("UTF-8"));
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            HttpUtil.safeCloseStream(output);
        }
        return null;
    }

    private ModelAndView defaultExceptionHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        OutputStream output = null;
        try {
            output = response.getOutputStream();
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            ex.printStackTrace();
            output.write(("5000 未知服务器错误 | " + ex.getMessage()).toString().getBytes("UTF-8"));
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            HttpUtil.safeCloseStream(output);
        }
        return null;
    }
}
