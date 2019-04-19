package work.idler.my.shop.web.ui.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import work.idler.my.shop.web.ui.constant.SystemConstants;
import work.idler.my.shop.web.ui.dto.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @Auther:http://blog.idler.work
 * @Date:2019/4/18
 * @Description:work.idler.my.shop.web.ui.interceptor
 * @version:1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(SystemConstants.SESSION_USER_KEY);
        // 未登录状态
        if (tbUser == null) {
            return true;
        }

        // 已登录状态
        else {
            httpServletResponse.sendRedirect("/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
