package net.engineeringdigest.journalApp.Repository;


import net.engineeringdigest.journalApp.Entity.user;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class userRepositoryimp {

    @Autowired
    private MongoTemplate  MongoTemplate;

public List<user> getUsersForSA(){
    Query query=new Query();
    query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
    query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
    return MongoTemplate.find(query, user.class);
}
}
