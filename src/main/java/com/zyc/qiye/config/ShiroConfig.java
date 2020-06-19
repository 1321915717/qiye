package com.zyc.qiye.config;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
     //   System.out.println("执行shiroFilterBean");

        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //必须设置securitymanager
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        //需要登陆的接口 如果访问某个接口。没登陆就会调用这个接口（如何不是前后端分离，则跳转页面）
        shiroFilterFactoryBean.setLoginUrl("/admin/login/needLogin");
        //已经登陆没权限就会调用这个  先验证登陆 再验证是否有权限
        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/login/noPermission");

        //拦截器路径 一定要用linkedhashmap！！！
        Map<String,String> filterChainDefinitionMap =new LinkedHashMap<>();

        filterChainDefinitionMap.put("/admin/login/**","anon");
        filterChainDefinitionMap.put("/admin/**","authc");


/*
        //登陆成功，跳转url，如果是前后端分离 则没有这个调用
        shiroFilterFactoryBean.setSuccessUrl("/admin/index");




        //退出过滤器
        filterChainDefinitionMap.put("/logout","logout");
        // 匿名可以访问，也就是游客模式
        filterChainDefinitionMap.put("/admin/pass","anon");
        //登陆可以访问的
        filterChainDefinitionMap.put("/admin/video","authc");

        //角色为管理员才可以访问
        filterChainDefinitionMap.put("/admin/guanli","roles[admin]");
        //有编辑权限才可以访问
        filterChainDefinitionMap.put("/admin/shenhe","perms[video]_update");
        *//*
        拦截器 顺序从上到下执行
        * *//*  */
      //  shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return  shiroFilterFactoryBean;



    }

  @Bean
  public SecurityManager securityManager(){
      DefaultWebSecurityManager securityManager =new DefaultWebSecurityManager();

      securityManager.setSessionManager(sessionManager());
      securityManager.setRealm(customRealm());
      return  securityManager;
  }

    @Bean
    public   CustomRealm customRealm(){
        CustomRealm customRealm =new CustomRealm();
        //设置加密
       /* customRealm.setCredentialsMatcher(hashedCredentialsMatcher());*/
        return  customRealm;
    }

    @Bean
    public SessionManager sessionManager(){
        CustomSessionManager customSessionManager =new CustomSessionManager();
        //超时时间 默认30分钟 单位毫秒
        customSessionManager.setGlobalSessionTimeout(4000000);
       return  customSessionManager;
    }

    //密码加密bean
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher =new HashedCredentialsMatcher();

        //设置散列算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //加密次数为2
        credentialsMatcher.setHashIterations(2);
        return  credentialsMatcher;

    }
}
