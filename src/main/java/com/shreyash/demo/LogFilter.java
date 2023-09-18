package com.shreyash.demo;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class LogFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Check");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Deck");
    }
}
