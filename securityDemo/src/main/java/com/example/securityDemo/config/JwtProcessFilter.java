package com.example.securityDemo.config;

import com.example.securityDemo.service.JwtService;
import com.example.securityDemo.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


@Component
public class JwtProcessFilter extends OncePerRequestFilter {

    @Autowired
    JwtService jwtService;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        //check the validity of the token
        String username = null;
        String token = null;
        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7);
            username = jwtService.getUsername(token);
        }
        if (null != username && SecurityContextHolder.getContext().getAuthentication() == null){
            // get the user details based on the username from the incoming request token.
            UserDetails userDetails = applicationContext.getBean(MyUserDetailsService.class).loadUserByUsername(username);
            // now extract the token
            try {
                if(jwtService.isValidToken(token,userDetails)) {
                    //if the validation passes then set the userdetails object in the security context
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        filterChain.doFilter(request,response);
    }

}
