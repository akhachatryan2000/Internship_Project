package com.margin.port.out.elastic.repository;

import com.margin.port.out.elastic.document.DummyElasticDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface DummyElasticRepository extends ElasticsearchRepository<DummyElasticDocument, String> {
}
