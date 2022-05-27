package com.dangwebs.backLinks.useCases.resources;

import com.dangwebs.backLinks.models.ResourceDTO;
import com.dangwebs.backLinks.repositories.ResourceRepository;
import com.dangwebs.backLinks.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class GetResourceUseCase implements Function<String, Mono<ResourceDTO>> {
    private final ResourceRepository repository;
    private final MapperUtils mapper;

    public GetResourceUseCase(ResourceRepository repository, MapperUtils mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<ResourceDTO> apply(String id) {
        Objects.requireNonNull(id, "Id is required");
        return repository.findById(id)
                .map(mapper.mapEntityToResourceDTO());
    }
}
