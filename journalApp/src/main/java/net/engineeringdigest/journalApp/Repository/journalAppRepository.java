package net.engineeringdigest.journalApp.Repository;


import net.engineeringdigest.journalApp.Entity.journalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalAppRepository extends MongoRepository <journalEntry, ObjectId>{


}
