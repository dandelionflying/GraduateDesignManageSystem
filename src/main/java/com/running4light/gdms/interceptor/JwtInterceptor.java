package com.running4light.gdms.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.running4light.gdms.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器只负责把请求头中包含token的令牌进行解析验证
 * 需要通过请求头获取token（前端将token写入请求头发送,后端根据约定的名称获取）
 */
@Component
public class JwtInterceptor implements HandlerInterceptor{

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private HttpServletRequest request;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("拦截器生效");
        String tokenheader = request.getHeader("Authorization");
        if(tokenheader!=null && !"".equals(tokenheader)){
            if(tokenheader.startsWith("miao_")){
                String token = tokenheader.substring(5);
                try {
                    Claims claims =  jwtUtil.parseJWT(token);
                    String role = (String)claims.get("roles");
                    if(role!=null && role.equals("admin")){
                        request.setAttribute("claims_admin",token);
                    }
                    if(role!=null && role.equals("user")){
                        request.setAttribute("claims_user",token);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌不正确");
                }
            }
        }
        return true;
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
