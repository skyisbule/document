package cn.zdnfjx.wd.service;

import cn.zdnfjx.wd.dao.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userDao user;

    public boolean auth(String name,String passwd){
        String realPasswd = user.getPasswd(name);
        if (realPasswd == null)
            return false;
        if (realPasswd.equals(passwd))
            return true;
        return false;
    }
}
