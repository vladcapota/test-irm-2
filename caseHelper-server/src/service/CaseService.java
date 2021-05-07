/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CaseDao;
import dao.DocumentDao;
import dao.UserDao;
import dto.CaseDto;
import dto.DocumentDto;
import dto.UserDto;
import dto.enums.PhaseDto;
import entities.Case;
import entities.Document;
import entities.enums.Phase;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 *
 * @author Vlad
 */
public class CaseService {
    
    private EntityManagerFactory emf;
    
    private CaseService(){
        emf = Persistence.createEntityManagerFactory("caseHelper-serverPU");
    }
    
    private static final class SingletonHolder {
        private static final CaseService SINGLETON = new CaseService();
    }
    
    public static CaseService getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    public void addCase(CaseDto caseDto){
        
        EntityManager em = emf.createEntityManager();
        CaseDao caseDao = new CaseDao(em);
        
        em.getTransaction().begin();
        
        Case freshCase = new Case();
        freshCase.setCaseName(caseDto.getCaseName());
        freshCase.setPhase(Phase.NEW);
        caseDao.addCase(freshCase);
        
        em.getTransaction().commit();
    }
    
    
    public List<CaseDto> getCases(){
        
        EntityManager em = emf.createEntityManager();
        CaseDao caseDao = new CaseDao(em);
        
        return caseDao.getCases()
                        .stream()
                        .map(c -> new CaseDto(c.getId(), c.getCaseName())).collect(Collectors.toList());
        
        
    }
    
    public void deleteCase(CaseDto caseDto){
        
        EntityManager em = emf.createEntityManager();
        CaseDao caseDao = new CaseDao(em);
        
        em.getTransaction().begin();
        
        Case newCase = caseDao.findCaseById(caseDto.getId());
        caseDao.deleteCase(newCase);
        
        em.getTransaction().commit();
        
    }
    
    public void updateCase(CaseDto caseDto){
        
        EntityManager em = emf.createEntityManager();
        CaseDao caseDao = new CaseDao(em);
        
        Case newCase = caseDao.findCaseById(caseDto.getId());
        
        em.getTransaction().begin();
        
        if(newCase == null){
        
            throw new EntityNotFoundException();
        
        }else{
            
            caseDao.updateCase(newCase);
        
        }
        
        em.getTransaction().commit();
        
    }
    
    public void addDocumentToCase(CaseDto caseDto, DocumentDto documentDto){
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        DocumentDao documentDao = new DocumentDao(em);
        CaseDao caseDao = new CaseDao(em);
        Document currentDocument = documentDao.getDocuments().get(0);
        Case newCase = caseDao.addDocumentToCase(caseDto.getId(), currentDocument);
        
        em.getTransaction().commit();
        
    }
    
    public void changeCasePhase(UserDto userDto, CaseDto caseDto, PhaseDto phaseDto){
        
         EntityManager em = emf.createEntityManager();
        
         em.getTransaction().begin();
         
         CaseDao caseDao = new CaseDao(em);
         String newPhase = phaseDto.values().toString();
         Case updatedCase = caseDao.changeCasePhase(caseDto.getId(), userDto.getId(), newPhase);
         
         em.getTransaction().commit();
         
    }
    
    
}
