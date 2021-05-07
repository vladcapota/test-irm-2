/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;

/**
 *
 * @author Vlad
 */
public class DocumentDto {
    
    private int id;
    
    private String documentName;
    
    private List<CaseDto> cases;
    
    public DocumentDto(){
        
    }

    public DocumentDto(String documentName) {
        this.documentName = documentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public List<CaseDto> getCases() {
        return cases;
    }

    public void setCases(List<CaseDto> cases) {
        this.cases = cases;
    }

    @Override
    public String toString() {
        return "DocumentDto{" + "id=" + id + ", documentName=" + documentName + '}';
    }
    
    
    
}
