package com.learn.kafka.repository;

import com.learn.kafka.repository.entity.WikimediaDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WikimediaRepository extends MongoRepository<WikimediaDataEntity, UUID> {
}
