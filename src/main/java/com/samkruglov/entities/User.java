package com.samkruglov.entities;

import org.springframework.hateoas.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Identifiable<Long> {
    
    @Id
    @GeneratedValue(generator = "SequencePerEntityGenerator")
    private Long id;
    
    @Column(length = 16, nullable = false, unique = true)
    private String username;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Group group;
    
    /**
     * A user may only exist with all first and second names and the username.
     */
    public User(final String username, final String firstName, final String lastName) {
        
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * For JPA only.
     */
    protected User() {}
    
    @Override
    public int hashCode() {
        
        /* Hash needs to return the same value for entity disregarding its persistent state.
         * todo this hashCode kills all performance benefits from hash collections but it works
         * see https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
         * Main argument - this is fine unless we're loading thousands of records into hashtables.
         */
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        
        //this entity is managed, compare by id
        if (id != null) {
            return Objects.equals(id, user.id);
        }
        
        //this entity is detached, compare by business id
        return Objects.equals(username, user.username);
    }
    
    @Override
    public Long getId() {
        
        return id;
    }
    
    public Group getGroup() {
        
        return group;
    }
    
    public String getUsername() {
        
        return username;
    }
    
    public String getFirstName() {
        
        return firstName;
    }
    
    public String getLastName() {
        
        return lastName;
    }
    
    public void setUsername(final String username) {
        
        this.username = username;
    }
    
    public void setFirstName(final String firstName) {
        
        this.firstName = firstName;
    }
    
    public void setLastName(final String secondName) {
        
        this.lastName = secondName;
    }
    
    /**
     * Only for usage in {@link Group}.
     */
    void setGroup(final Group group) {
        
        this.group = group;
    }
}
