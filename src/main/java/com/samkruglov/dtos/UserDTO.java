package com.samkruglov.dtos;

import java.util.Objects;

/**
 * Only defines a {@link com.samkruglov.entities.User#username username}.
 */
public class UserDTO {
    
    private final String username;
    
    public UserDTO(final String username) {
        
        this.username = username;
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(username);
    }
    
    @Override
    public boolean equals(final Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserDTO userDTO = (UserDTO) o;
        return Objects.equals(username, userDTO.username);
    }
    
    public String getUsername() {
        
        return username;
    }
}