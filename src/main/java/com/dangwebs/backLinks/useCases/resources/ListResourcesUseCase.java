package com.dangwebs.backLinks.useCases.resources;

import com.dangwebs.backLinks.models.ResourceDTO;
import com.dangwebs.backLinks.repositories.ResourceRepository;
import com.dangwebs.backLinks.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ListResourcesUseCase implements Supplier<Flux<ResourceDTO>> {
    private final ResourceRepository repository;
    private final MapperUtils mapper;

    public ListResourcesUseCase(ResourceRepository repository, MapperUtils mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Flux<ResourceDTO> get() {
        return repository.findAll()
                .map(mapper.mapEntityToResourceDTO());
    }
}
