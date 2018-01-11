package com.samkruglov.entities.projections;

import com.samkruglov.entities.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "username_only", types = User.class)
public interface UserUsername {
    
    String getUsername();
}
