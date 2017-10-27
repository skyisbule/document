package cn.zdnfjx.wd.service;

import cn.zdnfjx.wd.dao.userDao;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userDao user;

    public boolean auth(String name,String passwd){
        String realPasswd = user.getPasswd(name);
        return realPasswd!=null&&realPasswd.equals(passwd);
    }

    public String getPasswd(String username) {
        System.out.println(user.getPasswd(username));
        return "1";
    }
}
