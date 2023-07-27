package com.project1.libaryproject.Config;

import com.project1.libaryproject.Entity.Book;
import com.project1.libaryproject.Entity.Message;
import com.project1.libaryproject.Entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestCONFIG implements RepositoryRestConfigurer {

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry registry){
    HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PATCH, HttpMethod.DELETE,HttpMethod.PUT};

    config.exposeIdsFor(Book.class);
    config.exposeIdsFor(Review.class);
    config.exposeIdsFor(Message.class);

    disableHttpMethods(config, theUnsupportedActions);
    String theAllowedOrgin = "https://localhost:3000";
    registry.addMapping(config.getBasePath() + "/**").allowedOrigins(theAllowedOrgin);
}

    private void disableHttpMethods(RepositoryRestConfiguration config,
                                    HttpMethod[] theUnsupportedActions) {

    config.getExposureConfiguration().forDomainType(Book.class).withItemExposure((metdata, httpMethods)
                    -> httpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods)
                    -> httpMethods.disable(theUnsupportedActions));


    }


}
