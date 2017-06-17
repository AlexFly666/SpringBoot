package com.newcapec.config.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title:
 * @ClassName: com.newcapec.config.exception.GlobalExceptionHandler.java
 * @Description:
 *
 * @Copyright 2016-2017 新开普 - Powered By 研发中心
 * @author: 王延飞
 * @date:2017-03-29 8:07
 * @version V1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @Title: 错误页面
     * @methodName: defaultErrorHandler
     * @param req
     * @param e
     * @return org.springframework.web.servlet.ModelAndView
     * @Description:
     *
     * @author: 王延飞
     * @date: 2017-03-29 8:08
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    /**
     * @Title: 错误信息【返回值JSON格式】
     * @methodName: jsonErrorHandler
     * @param req
     * @param e
     * @return com.newcapec.config.exception.ErrorInfo<java.lang.String>
     * @Description:
     *
     * @author: 王延飞
     * @date: 2017-03-29 8:08
     */
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, CustomException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("业务数据");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

}

