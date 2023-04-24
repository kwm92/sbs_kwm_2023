package com.kwm.exam.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kwm.exam.demo.service.MemberService;
import com.kwm.exam.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor {
	private Rq rq;

	public BeforeActionInterceptor(Rq rq) {
		this.rq = rq;
	}

	@Autowired
	private MemberService memberService;

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		// 이제는 Rq 객체가 자동으로 만들어지기 때문에 필요 없음.
		rq.initOnBeforeActionInterceptor();
		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}
}
