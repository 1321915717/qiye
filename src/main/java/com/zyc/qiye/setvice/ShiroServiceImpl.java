package com.zyc.qiye.setvice;


import com.zyc.qiye.mapper.UserMapper;
import com.zyc.qiye.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User finduserByUserName(String username) {
       return userMapper.findByUserName(username);

    }
}
