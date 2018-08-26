package com.kristoff.common.filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;

public class LangFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(LangFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if(servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String lang = request.getHeader("Accept-Language");
            LOGGER.info("Accept-Language ====>" + lang);
            if(StringUtils.isBlank(lang)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            Locale locale =  null;
            String[] array = lang.split("_");
            if(array.length == 2) {
                String language = array[0];
                String country = array[1];
                locale = new Locale(language, country);
            } else if (array.length == 1) {
                locale = new Locale(array[0]);
            } else {
                locale = Locale.getDefault();
            }
            LOGGER.info("New locale ====>" + locale);
            LocaleContextHolder.setLocale(locale);
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
