/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dto.CaseDto;
import dto.DocumentDto;
import dto.UserDto;
import dto.enums.PhaseDto;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Vlad
 */

@WebService
public interface CaseWebService {
    
    @WebMethod
    public void addCase(@WebParam CaseDto caseDto);
    
    @WebMethod
    public List<CaseDto> getCases();
    
    @WebMethod
    public void deleteCase(@WebParam CaseDto caseDto);
    
    @WebMethod
    public void updateCase(@WebParam CaseDto caseDto);
    
    @WebMethod
    public void addDocumentToCase(@WebParam CaseDto caseDto, @WebParam DocumentDto documentDto);
    
    @WebMethod
    public void changeCasePhase(@WebParam UserDto userDto, @WebParam CaseDto caseDto, @WebParam PhaseDto phaseDto);
    
}
