/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.UserDto;
import java.net.URL;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import webservice.UserWebService;

/**
 *
 * @author Vlad
 */
public class UserController {
    
    private UserWebService userService;
    
    private UserController(){
        try {
            String url = "http://localhost:8080/user?wsdl";
            QName qName = new QName("http://webservice/", "UserWebServiceService");
            Service service = Service.create(new URL(url), qName);
            userService = service.getPort(UserWebService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final UserController SINGLETON = new UserController();
    }
    
    public static UserController getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    
    public void addUser(UserDto userDto){
        userService.addUser(userDto);
    }
    
    
    public boolean registerUser(UserDto userDto){
        return userService.registerUser(userDto);
    }
    
    
    public void updateUser(UserDto userDto){
        userService.updateUser(userDto);
    }
    
}
