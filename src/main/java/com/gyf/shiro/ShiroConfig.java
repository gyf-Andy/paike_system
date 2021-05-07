package com.gyf.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 22413
 * @date 2021/4/17-19:34
 * @Description shiro框架的参数配置文件
 */
@Configuration
public class ShiroConfig {

    //1.创建shiroFilter    负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean( DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统受限资源           资源设置不仅可以设置文件资源，如jsp，html文件 ，还可以设置接口资源
        //配置系统公共资源  默认放行的资源
        Map<String,String> map=new HashMap<String,String>();
        map.put("/test/toLoginPage.action","anon");
        map.put("/login.html","anon");//anon 设置为公共资源  （这里的login.action是一个接口）
        map.put("/test/toLogin.action","anon");
        map.put("/**","authc");   //authc 代表请求这个资源需要认证和授权  /**代表拦截所有资源，包括接口和页面

        //需要授权用户才能访问的资源    这里进行设置规则 ShiroRealm中进行授权操作
        map.put("/test/deleteAdmin.action","perms[admin:deleteAdmin]");
        //配置退出过滤器，其中具体的退出代码shiro底层已实现
        map.put("/doLogout.action","logout");

        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/test/toLoginPage.action");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器       自带web容器的SecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager( ShiroRealm shiroRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(shiroRealm);
        return defaultWebSecurityManager;
    }

    @Bean(name="myShiroRealm")
    public ShiroRealm myShiroRealm(HashedCredentialsMatcher matcher){
        ShiroRealm myShiroRealm=new ShiroRealm();
        myShiroRealm.setCredentialsMatcher(matcher);
        return myShiroRealm;
    }

    //密码匹配凭证管理器
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher=new HashedCredentialsMatcher();
        //采用MD5方式加密
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //设置加密次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    //能够在前端页面获取 用户主体信息
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
