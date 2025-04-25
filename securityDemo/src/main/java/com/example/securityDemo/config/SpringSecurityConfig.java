package com.example.securityDemo.config;


import com.example.securityDemo.model.MyUser;
import com.example.securityDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtProcessFilter jwtProcessFilter;
    @Bean
    public SecurityFilterChain getFilter(HttpSecurity httpSecurity) throws Exception {
        //disable the csrf settings
        httpSecurity.csrf(customizer->customizer.disable());


        // enable authentication for all incoming requests

        httpSecurity.authorizeHttpRequests(request->request
                .requestMatchers("register","login")
                .permitAll()
                .anyRequest().authenticated());
        //use defaults
        httpSecurity.httpBasic(Customizer.withDefaults());
        //stateless session
        httpSecurity.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // diable csrf for frmaes
        httpSecurity.headers(httpSecurityHeadersConfigurer -> {
            httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> {
                frameOptionsConfig.disable();
            });
        });

        httpSecurity.addFilterAfter(jwtProcessFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
    @Bean
    public AuthenticationProvider getAuthProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }

    @Bean
    public AuthenticationManager getAuthManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
