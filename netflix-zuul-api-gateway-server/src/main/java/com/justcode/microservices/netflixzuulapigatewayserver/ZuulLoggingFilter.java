package com.justcode.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public Object run() throws ZuulException {
		// Actual logic goes here
	HttpServletRequest request=	RequestContext.getCurrentContext().getRequest();
	logger.info("request -> {} ,request uri -> {}",request,request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// should this filter be executed or not
		return true;
	}

	@Override
	public int filterOrder() {
		// if we have multiple filter ,we can set priotrity order between them
		return 1;
	}

	@Override
	public String filterType() {
		// when should the filter be happening  like before request has executed or after request has executed
		//or when request caused an exception
		return "pre";
	}}
