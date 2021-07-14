package com.margin.listener;

import com.margin.port.out.elastic.document.DummyElasticDocument;
import com.margin.port.out.elastic.repository.DummyElasticRepository;
import com.margin.port.out.jpa.entity.DummyJpaEntity;
import com.margin.port.out.jpa.repository.DummyJpaRepository;
import com.margin.port.out.mongo.document.DummyMongoDocument;
import com.margin.port.out.mongo.repository.DummyMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {

    public static final String WELCOME_TEXT = "Welcome to Java internship . I hope this will be a great journey for you.";

    @Autowired
    private DummyJpaRepository userJpaRepository;

    @Autowired
    private DummyMongoRepository toDoMongoRepository;

    @Autowired
    private DummyElasticRepository toDoElasticRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onContextRefreshedEvent() {
        userJpaRepository.save(new DummyJpaEntity(WELCOME_TEXT));
        toDoMongoRepository.save(new DummyMongoDocument(WELCOME_TEXT));
        toDoElasticRepository.save(new DummyElasticDocument(WELCOME_TEXT));
    }


}
