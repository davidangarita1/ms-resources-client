package com.dangwebs.backLinks.routers.resources;

import com.dangwebs.backLinks.models.ResourceDTO;
import com.dangwebs.backLinks.useCases.resources.ListResourcesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ListResourcesRouter {
    @Bean
    public RouterFunction<ServerResponse> getAllResources(ListResourcesUseCase useCase) {
        return route(GET("resources/getAll"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), ResourceDTO.class))
        );
    }
}
