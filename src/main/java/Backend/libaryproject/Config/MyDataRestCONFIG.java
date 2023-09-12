package Backend.libaryproject.Config;

import Backend.libaryproject.Entity.Book;
import Backend.libaryproject.Entity.Message;
import Backend.libaryproject.Entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

// Enable exposing entity ids in API responses
@Configuration
public class MyDataRestCONFIG implements RepositoryRestConfigurer {

    // Method to configure RepositoryRestConfiguration
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry registry) {

        // Array of HTTP methods to disable
        HttpMethod[] theUnsupportedActions = {HttpMethod.POST, HttpMethod.PATCH, HttpMethod.DELETE,HttpMethod.PUT};

        // Expose ids in API responses
        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Review.class);
        config.exposeIdsFor(Message.class);

        // Disable specified HTTP methods
        disableHttpMethods(config, theUnsupportedActions);

        // Allow API requests from this origin
        String theAllowedOrigin = "https://localhost:3000";

        // Add CORS mapping
        registry.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigin);
    }

    // Helper method to disable HTTP methods
    private void disableHttpMethods(RepositoryRestConfiguration config,
                                    HttpMethod[] theUnsupportedActions) {

        // Disable methods for Book resources
        config.getExposureConfiguration()
                .forDomainType(Book.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

}
