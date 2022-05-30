package com.dangwebs.backLinks.routers.resources;

import com.dangwebs.backLinks.models.ResourceDTO;
import com.dangwebs.backLinks.useCases.resources.GetResourceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetResourceRouter {
    @Bean
    public RouterFunction<ServerResponse> getResource(GetResourceUseCase useCase) {
        return route(
                GET("resources/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.apply(
                                        request.pathVariable("id")),
                                ResourceDTO.class
                        ))
        );
    }
}
