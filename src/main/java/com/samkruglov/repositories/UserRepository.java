package com.samkruglov.repositories;

import com.samkruglov.dtos.UserDTO;
import com.samkruglov.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface UserRepository extends CrudRepository<User, Long> {
    
    @RestResource(path = "username", rel = "getUsername")
    UserDTO findById(@Param("id") Long id);
    
}
