package com.samkruglov.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.Identifiable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group implements Identifiable<Long> {
    
    @Id
    @GeneratedValue(generator = "SequencePerEntityGenerator")
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "group")
    private Set<User> users = new HashSet<>();
    
    /**
     * A group may only exist with a name.
     */
    public Group(final String name) {
        
        this.name = name;
    }
    
    /**
     * For JPA only.
     */
    protected Group() {}
    
    public Long getId() {
        
        return id;
    }
    
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
        final Group group = (Group) o;
        
        //this entity is managed, compare by id
        if (id != null) {
            return Objects.equals(id, group.id);
        }
        
        //this entity is detached, compare by business id
        return Objects.equals(name, group.name);
    }
    
    public void addUser(User user) {
        
        if (user == null) {
            throw new RuntimeException("Trying to add null as user.");
        }
        if (!users.add(user)) {
            throw new RuntimeException("Trying to add existing user.");
        }
        user.setGroup(this);
    }
    
    public boolean removeUser(User user) {
        
        if (user == null) {
            throw new RuntimeException("Trying to remove null as user.");
        }
        if (user.getId() == null) { //that should not be the case. Don't add a user if then gonna remove them
            throw new RuntimeException("Trying to remove detached user.");
        }
        user.setGroup(null);
        return users.remove(user);
    }
    
    @JsonIgnore//Spring Data REST thinks this is a separate property
    public Set<User> getReadOnlyUsers() {
        
        return Collections.unmodifiableSet(users);
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(final String name) {
        
        this.name = name;
    }
}
