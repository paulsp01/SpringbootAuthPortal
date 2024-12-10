package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.journalEntry;
import net.engineeringdigest.journalApp.Entity.user;
import net.engineeringdigest.journalApp.Repository.journalAppRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@Service
public class journalEntryService {

    @Autowired
    private journalAppRepository  journalAppRepository;
    @Autowired
    private userService userService;


    private static  final Logger logger= LoggerFactory.getLogger(journalEntryService.class);


    @Transactional
    public void saveEntry(journalEntry journalEntry, String userName){
        try{
            user User=userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            journalEntry saved=journalAppRepository.save(journalEntry);
            User.getJournalEntries().add(saved);

            userService.saveUser(User);

        } catch (Exception e) {
          logger.info("successfully runned");
          throw new RuntimeException("err",e);



        }


    }


    public void saveEntryNew(journalEntry journalEntry){

        journalAppRepository.save(journalEntry);

    }
    public List<journalEntry > getAll(){
        return journalAppRepository.findAll();

    }
    public Optional<journalEntry> findById(ObjectId id){
        return journalAppRepository.findById(id);

    }

    @Transactional
    public boolean deleteId(ObjectId id, String userName) {
        boolean removed = false;
        try {
            user user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userService.saveUser(user);
                journalAppRepository.deleteById(id);
            }
        } catch (Exception e) {
          System.out.println("error");
            throw new RuntimeException("An error occurred while deleting the entry.", e);
        }
        return removed;
    }

    public List<journalEntry> findByUserName(String userName) {
        return journalAppRepository.findAll();
    }

}
