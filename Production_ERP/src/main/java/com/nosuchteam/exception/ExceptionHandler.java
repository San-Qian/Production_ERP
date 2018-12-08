package com.nosuchteam.exception;

import com.nosuchteam.exception.exceptions.IllegalUserException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Evan
 * @Date: 2018/11/29 20:57
 * @Description:
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("message",e.getMessage());
        modelAndView.setViewName("error");

        if(e instanceof IllegalUserException){
            modelAndView.setViewName("refuse");
        }
        return modelAndView;
    }
}
