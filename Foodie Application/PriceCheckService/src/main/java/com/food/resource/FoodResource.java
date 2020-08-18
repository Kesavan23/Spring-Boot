package com.food.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/foodPrice")
public class FoodResource {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{username}")
    public User getStock(@PathVariable("username") final String userName) {

        ResponseEntity<List<String>> userResp = restTemplate.exchange("http://db-service/rest/db/" + userName, HttpMethod.GET,
                null, new ParameterizedTypeReference<String>() {
                });


        List<String> user = userResp.getBody();
        return user;
       
    }
    @GetMapping("/{item}")
    public String getFoodItemPrice(String item) {
        try {
            return FoodPanda.get(item);
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    private class User {
    	
    	
        private String userName;
        private int id;

        

        
    }
}
