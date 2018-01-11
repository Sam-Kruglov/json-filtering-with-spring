package com.samkruglov.repositories;

import com.samkruglov.entities.User;
import com.samkruglov.entities.dtos.UserUsername;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface UserRepository extends CrudRepository<User, Long> {
    
    @RestResource(path = "username", rel = "getUsername")
    UserUsername findUsernameById(@Param("id") Long id);
    
}
