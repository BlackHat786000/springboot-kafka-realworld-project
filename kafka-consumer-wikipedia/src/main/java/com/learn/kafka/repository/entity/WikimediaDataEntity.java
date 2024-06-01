package com.learn.kafka.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@Document(collection = "wikimedia_data")
public class WikimediaDataEntity {

    @Id
    private UUID id;

    private String eventMessage;

}
