/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dto.DocumentDto;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import service.DocumentService;

/**
 *
 * @author Vlad
 */

@WebService
public class DocumentWebService {
    
    @WebMethod
    public void addDocument(@WebParam DocumentDto documentDto){
        DocumentService.getInstance().addDocument(documentDto);
    }
    
    public void deleteDocument(@WebParam DocumentDto documentDto){
        DocumentService.getInstance().deleteDocument(documentDto);
    }
    
}
