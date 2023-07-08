package com.project1.libaryproject.Config;

import com.project1.libaryproject.Entity.Book;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestCONFIG implements RepositoryRestConfigurer {

private String theAllowedOrgin = "http://localhost:3000";
public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry registry){
    HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PATCH, HttpMethod.DELETE,HttpMethod.PUT};

    config.exposeIdsFor(Book.class);

    disableHttpMethods(Book.class,config, theUnsupportedActions);

}

    private void disableHttpMethods(Class bookClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
    }


}
