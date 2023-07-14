package com.project1.libaryproject.Config;
import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;



@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Disable Cross Site Request Forgery
        //Cross Site Request Forgery is an
        // attack that forces an end user to execute unwanted actions on a web application

        http.csrf((csrf) -> csrf.ignoringRequestMatchers("/api/**"));
//the http.csrf().disable() method is deprecated in Spring Security 5.7.0 and above.
//
//The recommended alternative is to use http.csrf((csrf) -> csrf.ignoringAntMatchers("/api/**")) instead.
//
//This ignores CSRF protection for specific ant pattern matchers,
// rather than disabling it completely.

      //So instead of .disable(), you call .ignoringAntMatchers() and
        // pass in ant-style patterns for URLs you want to ignore CSRF protection on.
        //
        //This is considered more secure than globally disabling CSRF protection.
        // It allows you to keep CSRF checks on sensitive endpoints,
        // while excluding REST API endpoints that don't use session state
        // and are typically protected by other means like OAuth.
        //
        //The key is to use ant matchers to selectively ignore CSRF for specific URLs
        // rather than disabling it completely. This maintains security while excluding
        // APIs that don't need CSRF checks.









        // Protect endpoints at /api/<type>/secure
        http.authorizeHttpRequests(configurer -> //authorizeRequests is a method that takes a configurer;
                // however, it deprecated,
                        // so we have to use the below method

                        configurer
                                .requestMatchers("/api/books/secure/**",
                                        "/api/reviews/secure/**",
                                        "/api/messages/secure/**",
                                        "/api/admin/secure/**")
                                .authenticated())
                .oauth2ResourceServer((oauth2) -> oauth2
                        .jwt(Customizer.withDefaults())
                );

        // Add CORS filters
       http.cors(Customizer.withDefaults());

        // Add content negotiation strategy
        http.setSharedObject(ContentNegotiationStrategy.class,
                new HeaderContentNegotiationStrategy());

        // Force a non-empty response body for 401's to make the response friendly
        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }

}














