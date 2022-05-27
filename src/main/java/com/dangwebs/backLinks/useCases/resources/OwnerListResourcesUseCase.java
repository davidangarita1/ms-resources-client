package com.dangwebs.backLinks.useCases.resources;

import com.dangwebs.backLinks.models.ResourceDTO;
import com.dangwebs.backLinks.repositories.ResourceRepository;
import com.dangwebs.backLinks.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class OwnerListResourcesUseCase implements Function<String, Flux<ResourceDTO>> {
    private final ResourceRepository repository;
    private final MapperUtils mapper;

    public OwnerListResourcesUseCase(ResourceRepository repository, MapperUtils mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Flux<ResourceDTO> apply(String userId) {
        return repository.findByUserId(userId)
                .map(mapper.mapEntityToResourceDTO());
    }
}
