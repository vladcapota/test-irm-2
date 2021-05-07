/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.enums.PhaseDto;
import java.util.List;

/**
 *
 * @author Vlad
 */
public class CaseDto {
    
    private int id;
    
    private String caseName;
    
    private PhaseDto phase;
    
    private List<DocumentDto> documents;
    
    public CaseDto(){
        
    }

    public CaseDto(String caseName) {
        this.caseName = caseName;
    }

    public CaseDto(int id, String caseName) {
        this.id = id;
        this.caseName = caseName;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public PhaseDto getPhase() {
        return phase;
    }

    public void setPhase(PhaseDto phase) {
        this.phase = phase;
    }

    public List<DocumentDto> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentDto> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "CaseDto{" + "id=" + id + ", caseName=" + caseName + ", phase=" + phase + '}';
    }
    
    
    
}
