package com.mtgs.kafka.consumer.entity;

import javax.persistence.*;

@Entity
@Table(name = "wikiMedia")
@lombok.Getter
@lombok.Setter
public class WikiMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;
}
