package com.user.filter;

import com.config.Config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by junlai on 2017/1/8.
 */
public class LoginFilter implements Filter {

    @Override
    public void destroy(){

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain arg2)throws IOException,ServletException{
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        HttpSession httpSession=httpServletRequest.getSession();
        Config config=new Config();
        if(httpSession.getAttribute(config.MANAGER_ID)==null
                ||"".equals(httpSession.getAttribute(config.MANAGER_ID).toString())
                || !config.LOGIN_SUCCESS_VALUE.equals(httpSession.getAttribute(config.LOGIN_SUCCESS).toString())||
                httpSession.getAttribute(config.LOGIN_SUCCESS)==null){

                    httpServletResponse.sendRedirect("../login.jsp");
                    return;

        }else{
            arg2.doFilter(request ,response);
        }

    }



    @Override
    public void init (FilterConfig arg0)throws ServletException{

    }
}
