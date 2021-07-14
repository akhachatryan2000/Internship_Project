package com.margin.port.out.mongo.repository;

import com.margin.port.out.mongo.document.DummyMongoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DummyMongoRepository extends MongoRepository<DummyMongoDocument, String> {
}
