/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.CaseDto;
import dto.DocumentDto;
import dto.UserDto;
import dto.enums.PhaseDto;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import webservice.CaseWebService;

/**
 *
 * @author Vlad
 */
public class CaseController {
    
    private CaseWebService caseService;
    
    private CaseController(){
        try {
            String url = "http://localhost:8080/case?wsdl";
            QName qName = new QName("http://webservice/", "CaseWebServiceService");
            Service service = Service.create(new URL(url), qName);
            caseService = service.getPort(CaseWebService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final CaseController SINGLETON = new CaseController();
    }
    
    public static CaseController getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    
    public void addCase(CaseDto caseDto){
        caseService.addCase(caseDto);
    }
    
    
    public List<CaseDto> getCases(){
        return caseService.getCases();
    }
    
    
    public void deleteCase(CaseDto caseDto){
        caseService.deleteCase(caseDto);
    }
    
    
    public void updateCase(CaseDto caseDto){
        caseService.updateCase(caseDto);
    }
    
    
    public void addDocumentToCase(CaseDto caseDto, DocumentDto documentDto){
        caseService.addDocumentToCase(caseDto, documentDto);
    }
    
    
    public void changeCasePhase(UserDto userDto, CaseDto caseDto, PhaseDto phaseDto){
        caseService.changeCasePhase(userDto, caseDto, phaseDto);
    }
    
}
