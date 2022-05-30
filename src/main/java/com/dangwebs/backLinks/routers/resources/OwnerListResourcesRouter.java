package com.dangwebs.backLinks.routers.resources;

import com.dangwebs.backLinks.models.ResourceDTO;
import com.dangwebs.backLinks.useCases.resources.OwnerListResourcesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OwnerListResourcesRouter {
    @Bean
    public RouterFunction<ServerResponse> getOwnerAllResources(OwnerListResourcesUseCase useCase) {
        return route(
                GET("resources/owner/{userId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                useCase.apply(request.pathVariable("userId")),
                                ResourceDTO.class
                        ))
        );
    }
}
