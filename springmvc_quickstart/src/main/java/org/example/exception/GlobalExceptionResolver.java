package org.example.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: ymm
 * @date: 2022/8/13
 * @version: 1.0.0
 * @description:
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    /**
     * 异常处理，产生异常后跳转到一个最终页面
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 实际抛出的异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e.getMessage());
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
