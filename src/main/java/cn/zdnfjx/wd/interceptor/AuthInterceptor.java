package cn.zdnfjx.wd.interceptor;

import cn.zdnfjx.wd.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import cn.zdnfjx.wd.util.reqestUtil;
import cn.zdnfjx.wd.util.AuthUtil;

/**
 * Created by skyisbule on 2017/10/27.
 * 用于核心增删查改API鉴权
 */
public class AuthInterceptor implements HandlerInterceptor{

    @Autowired
    userService user;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        return true;
        /*
        Map<String,String> cookies = reqestUtil.getCookies(request);
        //如果cookie不存在
        if (! cookies.containsKey("name")&& ! cookies.containsKey("passwd")){
            response.getWriter().print("you shuold login!");
            return false;//false
        }
        //处理一下异常
        String password = user.getPasswd(cookies.get("name"));
        if (password==null){
            response.getWriter().print("couldn't find your info from database!");
            return false;
        }

        String real = AuthUtil.StringToMd5(password);
        return real.equals(cookies.get("passwd"));
        // 只有返回true才会继续向下执行，返回false取消当前请求

        */
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //donothing
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //donothing
    }
}
