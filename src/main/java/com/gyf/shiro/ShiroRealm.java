package com.gyf.shiro;

import com.gyf.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 22413
 * @date 2021/4/17-19:26
 * @Description TODO
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private AdminService adminService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权认证");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        String account= (String) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> admin=adminService.Login(account);

        System.out.println(admin.toString());
        //System.out.println(admin.getIdentity().equals("root"));
        if (admin.get("identity").equals("root")){
            //给指定身份的用户资源使用权限
            info.addRole("root");
            info.addStringPermission("admin:deleteAdmin");
        }
        System.out.println(account);

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("执行登陆认证！");
        SimpleAuthenticationInfo info=null;
        //将token转换成UsernamePasswordToken
        UsernamePasswordToken upToken= (UsernamePasswordToken) authenticationToken;
        //获取用户名
        String username=upToken.getUsername();
        //查询数据库是否查询到用户名和密码的用户
        Subject subject= SecurityUtils.getSubject();

        Map<String,Object> admin=adminService.Login(username);
        if (admin!=null){
            Object principal = admin.get("account");
            Object credentials = admin.get("password");

            //把账号当作盐值
            ByteSource salt=ByteSource.Util.bytes(username);
            String realmName=this.getName();
            //将账号，密码,盐值，realmName实例化到SimpleAuthenicationInfo中交给shiro来管理
            info=new SimpleAuthenticationInfo(principal,credentials,salt,realmName);
        }else{
            //没有查询到抛出一个异常
            throw new AuthenticationException();
        }
        return info;
    }
}
