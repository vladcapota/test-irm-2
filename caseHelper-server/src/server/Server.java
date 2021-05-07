/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.xml.ws.Endpoint;
import webservice.CaseWebService;
import webservice.DocumentWebService;
import webservice.UserWebService;

/**
 *
 * @author Vlad
 */
public class Server {

    
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/case", new CaseWebService());
        Endpoint.publish("http://localhost:8080/user", new UserWebService());
        Endpoint.publish("http://localhost:8080/document", new DocumentWebService());
    }
    
}
