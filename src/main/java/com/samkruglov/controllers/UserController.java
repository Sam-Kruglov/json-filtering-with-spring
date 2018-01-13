package com.samkruglov.controllers;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.samkruglov.repositories.UserRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestController
public class UserController {
    
    private final UserRepository userRepository;
    
    public UserController(final UserRepository userRepository) {
        
        this.userRepository = userRepository;
    }
    
    @GetMapping(value = "users/{id}", params = "fields")
    public ResponseEntity<MappingJacksonValue> getUser(@PathVariable("id") Long id,
                                                       @RequestParam("fields") String fields) {
        
        MappingJacksonValue wrapper = new MappingJacksonValue(userRepository.findOne(id));
        
        wrapper.setFilters(new SimpleFilterProvider()
                                   .addFilter("userFilter",
                                              SimpleBeanPropertyFilter.filterOutAllExcept(fields.split(","))));
        return ResponseEntity.ok(wrapper);
    }
}