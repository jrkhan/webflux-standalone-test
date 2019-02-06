package com.paychex.standalone.standalone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class StandaloneRouter {
	
    public static final String REMOTE_REQUEST_PATH = "/remote/person/firstName/{firstNameParam}/lastName/{lastNameParam}";
    public static final String SERVICE_REQUEST_PATH = "/service/person/{firstNameParam}/{lastNameParam}";
    
    @Autowired
    StandaloneRemoteAndServiceHandler handler;
    
	@Bean
    RouterFunction<ServerResponse> personRoutes() {
        return RouterFunctions
                .route(GET(REMOTE_REQUEST_PATH), handler::getPersonRemote)
                .andRoute(GET(SERVICE_REQUEST_PATH), handler::getPersonService);
        
    }
}