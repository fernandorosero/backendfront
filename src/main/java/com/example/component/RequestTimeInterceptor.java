package com.example.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.repository.LogRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestTimeInterceptor.
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	/** The log repository. */
	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	// Primero
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
		// TODO Auto-generated method stub
		// return super.preHandle(request, response, handler);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	// Segundo
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		long startTime = (Long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = " ";
		if (null != auth && auth.isAuthenticated()) {
			username = auth.getName();
		}
		// com.example.entity.Log log = new com.example.entity.Log(new Date(),
		// auth.getDetails().toString(), username, url);
		try {
			logRepository.save(new com.example.entity.Log(new Date(), auth.getDetails().toString(), username, url));
		} catch (Exception e) {
			LOG.error("ERROR null");
		}
		LOG.info("-Url to: '" + request.getRequestURL().toString() + "' -- in: '"
				+ (System.currentTimeMillis() - startTime) + "'ms");

		// TODO Auto-generated method stub
		// super.afterCompletion(request, response, handler, ex);
	}

}
