/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.DocumentDto;
import java.net.URL;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import webservice.DocumentWebService;

/**
 *
 * @author Vlad
 */
public class DocumentController {
    
    private DocumentWebService documentService;
    
    private DocumentController(){
        try {
            String url = "http://localhost:8080/document?wsdl";
            QName qName = new QName("http://webservice/", "DocumentWebServiceService");
            Service service = Service.create(new URL(url), qName);
            documentService = service.getPort(DocumentWebService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private static final class SingletonHolder {
        private static final DocumentController SINGLETON = new DocumentController();
    }
    
    public static DocumentController getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    
    public void addDocument(DocumentDto documentDto){
        documentService.addDocument(documentDto);
    }
    
    
    public void deleteDocument(DocumentDto documentDto){
        documentService.deleteDocument(documentDto);
    }
    
    
    
}
