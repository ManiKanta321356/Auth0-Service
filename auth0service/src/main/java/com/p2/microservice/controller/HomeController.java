package com.p2.microservice.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
    	
    	return "home";  
    }
    @GetMapping("/home1")
    public String home1(@AuthenticationPrincipal OidcUser oidcUser) {
    	String email = oidcUser.getEmail();
    	if(email.endsWith("@demo.com")) {
    		return "redirect:/seller";
    	}
            return "home1";  
    }
    @GetMapping("/home2")
    public String home2() {
            return "home2";  
    }

    @GetMapping("/categories")
    public String categories() {
        return "categories"; 
    }
    @GetMapping("/seller")
    public String seller() {
        return "seller"; 
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart";  
    }

    @GetMapping("/orders")
    public String orders() {
        return "orders";  
    }

    @GetMapping("/login")
    public String login() {
        return "login";  
    }

 

    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal OidcUser oidcUser, HttpSession session) {




    	
    	model.addAttribute("profile", oidcUser.getClaims());
    	
    	if (oidcUser.getUserInfo() != null) {
            OidcUserInfo userInfo = oidcUser.getUserInfo();
            System.out.println("User Info Claims: " + userInfo.getClaims());
            System.out.println("User Email: " + userInfo.getEmail());  
            System.out.println("User Name: " + userInfo.getNickName()); 
            System.out.println("User Name: " + userInfo.getGender()); 
            String email = userInfo.getEmail();
            System.out.println("Email of User"+email);
            String str=userInfo.getSubject();
            String str1=str.replaceAll("[^0-9]","");
            long userId=Long.parseLong(str1);
            System.out.println(((Object)userId).getClass().getSimpleName());
            System.out.println("User Id"+userId);
        } else {
            System.out.println("No UserInfo available");
        }

        OidcIdToken idToken = oidcUser.getIdToken();
        System.out.println("ID Token Claims: " + idToken.getClaims());
        System.out.println("ID Token Subject: " + idToken.getSubject());  
        System.out.println("ID Token Issuer: " + idToken.getIssuer()); 
        System.out.println(idToken.getTokenValue());
        return "profile"; 
    }
    


}

