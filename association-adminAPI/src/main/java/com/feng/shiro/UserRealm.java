package com.feng.shiro;

import com.feng.entity.User;
import com.feng.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rf on 2019/6/3.
 */
@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        AuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
      String account = (String)authenticationToken.getPrincipal();
      User user = userService.getOneByAccount(account);
      if(user==null){
          throw new UnknownAccountException("用户账号错误");
      }
        return new SimpleAuthenticationInfo(account,user.getPassword(),getName());
    }
}
