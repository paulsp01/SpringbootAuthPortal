package net.engineeringdigest.journalApp.services;


import net.engineeringdigest.journalApp.APIResponse.WeatherResponse;
import net.engineeringdigest.journalApp.cache.Appcache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private static  String apikey;


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private Appcache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("weather_of" + city, WeatherResponse.class);
        if(weatherResponse!=null){
          return weatherResponse;
        }else{
            String finalAPI=appCache.APP_CACHE.get("weather-api").replace("<city>",city).replace("<apikey>",apikey);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if (body != null) {
                redisService.set("weather_of_" + city, body, 300l);
            }
            return body;
        }




    }


}
