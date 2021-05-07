/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.enums.RoleDto;

/**
 *
 * @author Vlad
 */
public class UserDto {
    
    private int id;
    
    private String username;
    
    private String password;
    
    private RoleDto role;
    
    public UserDto(){
        
    }

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" + "id=" + id + ", username=" + username + ", role=" + role + '}';
    }
    
    
    
}
