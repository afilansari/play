package com.play.security;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Service
public class HamesRealm extends AuthorizingRealm {

	public HamesRealm() {
		setName("hamesRealm");
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println(principals.toString());
		System.out.println("Doing Authorization Info");
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		
		char[] savedPassword = "af".toCharArray();
		char[] password = upToken.getPassword();
		
		if(!Arrays.equals(savedPassword, password)){
			System.out.println("Password Incorrect");
			throw new IncorrectCredentialsException("Password Incorrect");
		}
		return new SimpleAuthenticationInfo(username,password,getName());
	}

}
