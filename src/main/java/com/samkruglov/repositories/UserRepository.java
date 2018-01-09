package com.samkruglov.repositories;

import com.samkruglov.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
