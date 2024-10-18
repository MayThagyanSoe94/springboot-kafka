package com.mtgs.kafka.consumer;

import com.mtgs.kafka.consumer.entity.WikiMedia;
import com.mtgs.kafka.consumer.repository.WikiMediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private WikiMediaDataRepository wikiMediaDataRepository;

    public KafkaConsumer(WikiMediaDataRepository wikiMediaDataRepository) {
        this.wikiMediaDataRepository = wikiMediaDataRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recent_change",
            groupId = "myConsumerGroup"
    )
    public void consume(String eventMessage) {
        LOGGER.info(String.format("event message received -> %s", eventMessage));
        WikiMedia wikiMedia = new WikiMedia();
        wikiMedia.setWikiEventData(eventMessage);
        wikiMediaDataRepository.save(wikiMedia);
    }
}
