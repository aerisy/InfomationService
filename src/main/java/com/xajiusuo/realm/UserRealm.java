package com.xajiusuo.realm;

import com.xajiusuo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户授权信息域
 *
 * @author coderhuang
 */
public class UserRealm extends CasRealm {


    protected final Map<String, SimpleAuthorizationInfo> roles = new ConcurrentHashMap<String, SimpleAuthorizationInfo>();

    /**
     * 设置角色和权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String account = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = null;
        if (authorizationInfo == null) {
            authorizationInfo = new SimpleAuthorizationInfo();
            List<String> pp = new ArrayList<String>();
            pp.add("askcall");
            pp.add("bgs");
            List<String> rr = new ArrayList<String>();
            rr.add("login");
            rr.add("edit");
            authorizationInfo.addStringPermissions(pp);
            authorizationInfo.addRoles(rr);
            roles.put(account, authorizationInfo);
        }

        return authorizationInfo;
    }


    /**
     * 1、CAS认证 ,验证用户身份
     * 2、将用户基本信息设置到会话中
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        AuthenticationInfo authc = super.doGetAuthenticationInfo(token);

        String account = (String) authc.getPrincipals().getPrimaryPrincipal();

        User user = new User();
        user.setName("Halo");
        user.setID(123);

        SecurityUtils.getSubject().getSession().setAttribute("user", user);

        return authc;
    }

    //demo1??

    /*@Resource
    private RoleService roleService;

    @Resource
    private UserService userService;

    protected final Map<String, SimpleAuthorizationInfo> roles = new ConcurrentHashMap<String, SimpleAuthorizationInfo>();

    *//**
     * 设置角色和权限信息
     *//*
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String account = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = null;
        if (authorizationInfo == null) {
            authorizationInfo = new SimpleAuthorizationInfo();
            List<String> pp = new ArrayList<String>();
            pp.add("askcall");
            pp.add("bgs");
            authorizationInfo.addStringPermissions(pp);
            List<String> rr = new ArrayList<String>();
            rr.add("login");
            rr.add("edit");
            authorizationInfo.addRoles(rr);
//            authorizationInfo.addStringPermissions(roleService.getPermissions(account));
//            authorizationInfo.addRoles(roleService.getRoles(account));
            roles.put(account, authorizationInfo);
        }

        return authorizationInfo;
    }


    *//**
     * 1、CAS认证 ,验证用户身份
     * 2、将用户基本信息设置到会话中
     *//*
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        AuthenticationInfo authc = super.doGetAuthenticationInfo(token);
        String account = (String) authc.getPrincipals().getPrimaryPrincipal();
//        User user = userService.getUserByAccount(account);
        User user = userService.get(1);
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        return authc;
    }
*/

}