package com.p2.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;



@Configuration
@EnableWebSecurity
public class SecurityConfig {


	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/home", "/products","/profile", "/categories").permitAll() 
                                .requestMatchers("/cart", "/orders", "/login","/register").authenticated() 
                                .anyRequest().permitAll() 
                )
                .oauth2Login(login -> login 
                        .defaultSuccessUrl("/home1", true))
        		.logout(logout -> logout
        				.logoutSuccessHandler(oidcLogoutSuccessHandler()) 
        				.invalidateHttpSession(true) 
        				.clearAuthentication(true)
        				.deleteCookies("JSESSIONID") 
        				.logoutSuccessUrl("/home2")); 
      
       
        

        return http.build();
    }
	
	
		
	
	
	
	
	private LogoutSuccessHandler oidcLogoutSuccessHandler() {
        return (request, response, authentication) -> {
            String logoutUrl = "https://dev-m0pu2uuglyzgrxx5.us.auth0.com/v2/logout?client_id=R2cFlMGSpRXmdCaeui4d0xZgdafgeMLm&returnTo=http://localhost:8081/home2";
            response.sendRedirect(logoutUrl);
        };
    }
	
}

