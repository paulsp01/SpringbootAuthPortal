package net.engineeringdigest.journalApp.Entity;




import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import net.engineeringdigest.journalApp.enums.Sentiment;

import java.time.LocalDateTime;


@Document(collection = "journal_entries")

@Data
@NoArgsConstructor
public class journalEntry {
    private ObjectId id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    private LocalDateTime date;
    private Sentiment sentiment ;


}
