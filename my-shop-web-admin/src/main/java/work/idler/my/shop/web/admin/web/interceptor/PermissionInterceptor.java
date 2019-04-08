package work.idler.my.shop.web.admin.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import work.idler.my.shop.commons.constant.ConstantUtils;
import work.idler.my.shop.domain.TbUser;
import work.idler.my.shop.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 * @Auther:http://blog.idler.work
 * @Date:2019/4/3
 * @Description:work.idler.my.shop.web.admin.web.interceptor
 * @version:1.0
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 以 login 结尾的请求
        if (modelAndView != null && modelAndView.getViewName() != null && modelAndView.getViewName().endsWith("login")) {
            TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (tbUser != null) {
                httpServletResponse.sendRedirect("/main");
            }
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
