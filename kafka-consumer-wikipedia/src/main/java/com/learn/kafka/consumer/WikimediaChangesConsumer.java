package com.learn.kafka.consumer;

import com.learn.kafka.repository.WikimediaRepository;
import com.learn.kafka.repository.entity.WikimediaDataEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class WikimediaChangesConsumer {

    private final WikimediaRepository wikimediaRepository;

    public WikimediaChangesConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recent_changes",
            groupId = "myGroup"
    )
    public void consume(String eventMessage) {
        log.info(String.format("event message received -> %s", eventMessage));
        WikimediaDataEntity entity = new WikimediaDataEntity();
        entity.setId(UUID.randomUUID());
        entity.setEventMessage(eventMessage);
        this.wikimediaRepository.save(entity);
    }
}
