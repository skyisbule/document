package cn.zdnfjx.wd.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by skyisbule on 2017/10/27.
 * 用于处理请求相关的代码
 */
public class reqestUtil {

    public static Map<String,String> getCookies(HttpServletRequest req){
        Cookie cookies[] = req.getCookies();
        Map<String,String> map = new HashMap<String, String>();
        if (cookies!=null)
        for (Cookie cookie : cookies){
            map.put(cookie.getName(),cookie.getValue());
        }
        return map;
    }
}
