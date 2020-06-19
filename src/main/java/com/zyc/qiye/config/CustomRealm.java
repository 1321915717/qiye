package com.zyc.qiye.config;


import com.zyc.qiye.pojo.User;
import com.zyc.qiye.setvice.ShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       // String username= (String) principals.getPrimaryPrincipal();
        return null;
    }


    /**
     * 用户登陆认证
     * @Param token
     * @return
     * @throws
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username= (String) token.getPrincipal();
        User user =shiroService.finduserByUserName(username);
     //   System.out.println(user.getUserName()+"--"+user.getPassword());
        if(null!=user){
            String pwd=user.getPassword();
            if(pwd.equals("")||null==pwd){
                return  null;
            }

        }  else{
            return  null;
        }



        return  new SimpleAuthenticationInfo(username,user.getPassword(),this.getName());
    }
}
