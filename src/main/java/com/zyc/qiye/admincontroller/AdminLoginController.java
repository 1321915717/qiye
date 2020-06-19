package com.zyc.qiye.admincontroller;


import com.zyc.qiye.mapper.UserMapper;
import com.zyc.qiye.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/login")
public class AdminLoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/needLogin")
    @CrossOrigin
    public  Object needLogin(){
        return ResponseUtil.fail(-100,"需要登陆");

    }

    @RequestMapping("/noPermission")
    public  Object noPermission(){

        return  ResponseUtil.fail(-2,"没有权限");
    }

    @RequestMapping("/startLogin")
    public  Object startLogin(@RequestParam("username")String username,
                              @RequestParam("pwd")String pwd){

        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken =new UsernamePasswordToken(username,pwd);
            subject.login(usernamePasswordToken);

            return  ResponseUtil.ok();
        }catch (AuthenticationException Ae){
            return  ResponseUtil.fail(-2,"密码错误");
        }
        catch (Exception e){

            return  ResponseUtil.fail();
        }


    }

    @RequestMapping("/update")
    public  Object zhanghao(
            @RequestParam("name")String name,
            @RequestParam("pwd")String pwd
    ){

        int code=userMapper.update(name,pwd);

        if(code>0){
            Subject subject = SecurityUtils.getSubject();
            if(subject.getPrincipals()!=null){
                SecurityUtils.getSubject().logout();
            }

            return ResponseUtil.ok();
        }
        return  ResponseUtil.fail();

    }
    @RequestMapping("/logout")
    public  Object logout(){

        try {
            Subject subject = SecurityUtils.getSubject();
           if(subject.getPrincipals()!=null){

           }
            SecurityUtils.getSubject().logout();
            return  ResponseUtil.ok();
        }catch (Exception e){

            return  ResponseUtil.fail();
        }


    }


}
