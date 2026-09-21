
package com.fleetcore.model;

import com.fleetcore.util.Validator;

/**
 *
 * @author mlamu
 */
public class User {
    private int id;
    private String username;
    private String passwordHash;
    private UserRole role;

    public User(String username, String passwordHash, UserRole role) {
        this(0, username, passwordHash, role);    
    }
    
    public User(int id, String username, String passwordHash, UserRole role) {
        Validator.requireNotBlank(username, "Username");
        Validator.requireNotBlank(passwordHash, "Password hash");
        Validator.requireNotNull(role, "Role");
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserRole getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
