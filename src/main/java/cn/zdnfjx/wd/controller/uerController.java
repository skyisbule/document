package cn.zdnfjx.wd.controller;

import cn.zdnfjx.wd.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import cn.zdnfjx.wd.util.AuthUtil;
import java.security.NoSuchAlgorithmException;

@RestController
public class uerController {

    @Autowired
    userService user;


    //处理登录
    @RequestMapping("/logining")
    public String login(String username,
                        String passwd,
                        HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        if (user.auth(username,passwd)){
            Cookie passwdCookie = new Cookie("passwd",AuthUtil.StringToMd5(passwd));
            Cookie userCookie = new Cookie("name",username);
            response.addCookie(passwdCookie);
            response.addCookie(userCookie);
            return "success";
        }
        return "error";
    }





}
