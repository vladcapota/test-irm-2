/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dto.UserDto;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import service.UserService;

/**
 *
 * @author Vlad
 */
@WebService
public class UserWebService {
    
    @WebMethod
    public void addUser(@WebParam UserDto userDto){
        UserService.getInstance().addUser(userDto);
    }
    
    @WebMethod
    public boolean registerUser(@WebParam UserDto userDto){
        return UserService.getInstance().registerUser(userDto);
    }
    
    @WebMethod
    public void updateUser(@WebParam UserDto userDto){
        UserService.getInstance().updateUser(userDto);
    }
}
