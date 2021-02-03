package com.hao.commont.security.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrameTao implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 必须
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 实际设置
		// response.addHeader("x-frame-options","SAMEORIGIN");
		response.setHeader("x-frame-options", "SAMEORIGIN");

		String method = request.getMethod();

		if (!"GET".equals(request.getMethod()) && !"POST".equals(request.getMethod())
				&& !"HEAD".equals(request.getMethod())) {
			response.setContentType("text/html;charset=GBK");
			response.setCharacterEncoding("GBK");
			response.setStatus(403);
		}

		// 调用下一个过滤器（这是过滤器工作原理，不用动）
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

}
