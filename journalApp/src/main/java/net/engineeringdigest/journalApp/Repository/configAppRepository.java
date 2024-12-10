package net.engineeringdigest.journalApp.Repository;


import net.engineeringdigest.journalApp.Entity.configAppEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface configAppRepository extends MongoRepository <configAppEntity, ObjectId>{


}
