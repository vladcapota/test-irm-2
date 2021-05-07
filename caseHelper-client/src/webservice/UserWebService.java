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

/**
 *
 * @author Vlad
 */

@WebService
public interface UserWebService {
    @WebMethod
    public void addUser(@WebParam UserDto userDto);
    
    @WebMethod
    public boolean registerUser(@WebParam UserDto userDto);
    
    @WebMethod
    public void updateUser(@WebParam UserDto userDto);
    
}
