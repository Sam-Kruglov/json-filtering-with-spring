package com.samkruglov.entities.dtos;

import java.util.Objects;

/**
 * Only defines a {@link com.samkruglov.entities.User#username username}.
 */
public class UserUsername {
    
    private final String username;
    
    public UserUsername(final String username) {
        
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
        final UserUsername userUsername = (UserUsername) o;
        return Objects.equals(username, userUsername.username);
    }
    
    public String getUsername() {
        
        return username;
    }
}
