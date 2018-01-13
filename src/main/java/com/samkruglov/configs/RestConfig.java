package com.samkruglov.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RestConfig extends RepositoryRestConfigurerAdapter {
    
    @Override
    public void configureJacksonObjectMapper(final ObjectMapper objectMapper) {
        
        objectMapper.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false));
    }
}