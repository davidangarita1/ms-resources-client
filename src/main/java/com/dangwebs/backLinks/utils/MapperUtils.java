package com.dangwebs.backLinks.utils;

import com.dangwebs.backLinks.collections.Resource;
import com.dangwebs.backLinks.models.ResourceDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {
    public Function<Resource, ResourceDTO> mapEntityToResourceDTO() {
        return entity -> new ResourceDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getUrl(),
                entity.getCategory(),
                entity.getDate(),
                entity.getImage(),
                entity.getFavorite()
        );
    }
}
