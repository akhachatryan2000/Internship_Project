package com.margin.port.out.mongo.document;

import org.springframework.data.annotation.Id;

public class AbstractMongoDocument {
    @Id
    String _id;
}
