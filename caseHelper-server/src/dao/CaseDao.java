/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Case;
import static entities.Case_.documents;
import entities.Document;
import entities.User;
import entities.enums.Phase;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Vlad
 */
public class CaseDao {
    
    private EntityManager em;
    
    public CaseDao(EntityManager em){
        this.em = em;
    }
    
    public void addCase(Case currentCase){
        em.persist(currentCase);
        
    }
    
    public List<Case> getCases(){
        String sql = "SELECT c FROM CASE c";
        TypedQuery<Case> query = em.createQuery(sql, Case.class);
        return query.getResultList();
    }
    
    public Case findCaseById (int id){
        return em.find(Case.class, id);
    }
    
    public void updateCase(Case workingCase){
        em.merge(workingCase);
    }
    
    public void deleteCase(Case newCase){
        em.remove(newCase);
    }
    
    public Case addDocumentToCase (int caseId, Document document){
        //get a list of documents to be added to the case
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        
        //get the case and add the list of documents to it
        String query = "SELECT c FROM CASE WHERE c.id = :id";
        TypedQuery<Case> typedQuery = em.createQuery(query, Case.class);
        typedQuery.setParameter("filename", caseId);
        List<Case> cases = typedQuery.getResultList();
        if(cases.isEmpty()) return null;
        else {
            cases.get(0).setDocuments(documents);
            return cases.get(0);
        }
        
    }
    
    public Case changeCasePhase(int caseId, int userId, String phase){
        //get the user that is performing the update
        String sql = "SELECT u FROM USER WHERE u.id = :id";
        TypedQuery<User> typedQuery = em.createQuery(sql, User.class);
        typedQuery.setParameter("id", userId);
        List<User> users = typedQuery.getResultList();
        User user = users.get(0);
        
        //get the case that must be updated and update it with the desired Phase
        String newPhase = phase;
        String query = "SELECT c FROM CASE WHERE c.id = :id";
        TypedQuery<Case> typedQ = em.createQuery(query, Case.class);
        typedQ.setParameter("id", caseId);
        List<Case> cases = typedQ.getResultList();
        if(cases.isEmpty()) return null;
        else {
            Case currentCase = cases.get(0);
            Phase currentPhase = currentCase.getPhase();
            switch(newPhase){
                case "UNDER_REVIEW":
                    currentCase.setPhase(Phase.UNDER_REVIEW);
                    break;
                case "APPROVED":
                    if(user.getRole().toString() == "PARTNER"){
                        currentCase.setPhase(Phase.APPROVED);
                        break;
                    }else{
                        break;
                    }
                case "SENT":
                    currentCase.setPhase(Phase.SENT);
                    break;
                    
                    
            }
            
            return currentCase;
        }
        
    }
    
}
