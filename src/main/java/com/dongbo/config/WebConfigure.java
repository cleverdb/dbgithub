package com.dongbo.config;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dongbo.utils.Constants;
import com.dongbo.utils.DES;

/**
 * @author V.Bo.Dong
 *
 */
/**
 * @author V.Bo.Dong
 *
 */
@Configuration
public class WebConfigure {

	private static final Logger logger = LoggerFactory.getLogger(WebConfigure.class);
	@Bean
	public RemoteIpFilter getAndRemoteIpFilter(){
		return new RemoteIpFilter();
	}
	
	@Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
    
    public class MyFilter implements Filter {
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
		}

		@Override
		public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
				throws IOException, ServletException {
			// TODO Auto-generated method stub
			HttpServletRequest request = (HttpServletRequest) srequest;
			if(request.getSession().getAttribute(Constants.SESSION_U_I) == null && request.getSession().getAttribute(Constants.SESSION_U_N) == null){
				filterChain.doFilter(srequest, sresponse);
				}else{
			RequestParameterWrapper requestWrapper = null;
			try {
				 requestWrapper = new RequestParameterWrapper(request);
				requestWrapper.addParameter(Constants.USER_ID, DES.decrypt(request.getSession().getAttribute(Constants.SESSION_U_I).toString(), Constants.DES_KEY));
			} catch (Exception e) {
				logger.error(" process filter,add user id in the parameter :"+e.getMessage());
			}
			System.out.println("this is MyFilter,url :"+request.getRequestURI());
			filterChain.doFilter(requestWrapper, sresponse);
			}
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
			// TODO Auto-generated method stub
		}

    }
}
