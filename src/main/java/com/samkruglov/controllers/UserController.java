package com.samkruglov.controllers;

import com.samkruglov.entities.User;
import com.samkruglov.entities.dtos.UserUsername;
import com.samkruglov.repositories.UserRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestController
public class UserController {
    
    private final RepositoryEntityLinks links;
    
    private final UserRepository        userRepository;
    
    public UserController(final RepositoryEntityLinks links, final UserRepository userRepository) {
        
        this.links = links;
        this.userRepository = userRepository;
    }
    
    @GetMapping("users/search/username")
    public ResponseEntity<Resource<UserUsername>> addLinksToUserUsername(@RequestParam("id") Long id) {
    
        Resource<UserUsername> usernameResource = new Resource<>(userRepository.findUsernameById(id));
    
        usernameResource.add(links.linkToSearchResource(User.class, "getUsername").withSelfRel());
        usernameResource.add(links.linkToSingleResource(User.class, id));
    
        return ResponseEntity.ok(usernameResource);
    }
}
