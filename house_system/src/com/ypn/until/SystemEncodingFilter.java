package com.ypn.until;

import org.omg.IOP.Encoding;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ypn
 * @date 2020/8/7
 * @motto I raise pigs in your field
 * @desc
 */
@WebFilter(filterName = "SystemEncodingFilter")
public class SystemEncodingFilter implements Filter {
    String encoding = null;
    FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
       this.encoding= filterConfig.getInitParameter("encoding");
        System.out.println("xixi"+encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        this.encoding=null;
        this.filterConfig=null;
    }
}
