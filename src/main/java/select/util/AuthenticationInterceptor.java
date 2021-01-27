package select.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yeyuting
 * @create 2021/1/26
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    TokenUtil tokenUtil ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = tokenUtil.getToken(request) ;
        if(StringUtils.isEmpty(token)){
            response.sendRedirect("/login");
            return false ;
        }
        return true;
    }
}
