package com.paychex.standalone.standalone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class StandaloneRemoteAndServiceHandler {
	
    private WebClient webClient;

    @Autowired
    WebClient.Builder webClientBuilder;

    String serviceUrl = "http://localhost:8080/";

    @PostConstruct
    public void init() {
        this.webClient = webClientBuilder.baseUrl(serviceUrl).build();
    }
	
	public Mono<ServerResponse> getPersonRemote(ServerRequest request) {
		return webClient
				.get()
				.uri(builder -> builder.path(StandaloneRouter.SERVICE_REQUEST_PATH)
						.build(request.pathVariable("firstNameParam"), 
							   request.pathVariable("lastNameParam")))
				.exchange()
				.flatMap(response -> response.bodyToMono(String.class))
				.flatMap( body -> buildResponse(HttpStatus.OK, "Name is: " + body));
				 
	}
	
	public Mono<ServerResponse> getPersonService(ServerRequest request) {
		return buildResponse(HttpStatus.OK, 
				request.pathVariable("firstNameParam") + " " + request.pathVariable("lastNameParam"));
	}
	
	private Mono<ServerResponse> buildResponse(
			HttpStatus status,
			String responseBody) {

		return ServerResponse
				.status(status)
				.body(BodyInserters.fromObject(responseBody));
	}
}
