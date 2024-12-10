package net.engineeringdigest.journalApp.Repository;


import net.engineeringdigest.journalApp.Entity.journalEntry;
import net.engineeringdigest.journalApp.Entity.user;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository <user, ObjectId>{

user findByUserName(String username);

void deleteByUserName(String username);
}
