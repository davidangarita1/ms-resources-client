package com.dangwebs.backLinks.repositories;

import com.dangwebs.backLinks.collections.Resource;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ResourceRepository extends ReactiveCrudRepository<Resource, String> {
    Flux<Resource> findByUserId(String userId);
}
