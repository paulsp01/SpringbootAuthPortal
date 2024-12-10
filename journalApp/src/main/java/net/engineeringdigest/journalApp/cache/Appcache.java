package net.engineeringdigest.journalApp.cache;


import net.engineeringdigest.journalApp.Entity.configAppEntity;
import net.engineeringdigest.journalApp.Repository.configAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Appcache {

    @Autowired
    private configAppRepository configAppRepository;

    public Map<String,String> APP_CACHE;

    @PostConstruct
    public void init(){
        APP_CACHE=new HashMap<>();
        List<configAppEntity> all = configAppRepository.findAll();

     for(configAppEntity configAppEntity:all){
         APP_CACHE.put(configAppEntity.getKey(),configAppEntity.getValue());
     }


       
    }
}
