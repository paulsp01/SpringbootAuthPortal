package net.engineeringdigest.journalApp.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "config_app")

@Data
@NoArgsConstructor
public class configAppEntity {

    private String key;

    private String value;



}
