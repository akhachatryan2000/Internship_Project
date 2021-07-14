package com.margin.port.out.elastic.document;

import org.springframework.data.annotation.Id;

public class AbstractElasticDocument {
    @Id
    String _id;
}
