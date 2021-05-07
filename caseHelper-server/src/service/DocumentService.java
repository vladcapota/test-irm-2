/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import dao.DocumentDao;
import dto.DocumentDto;
import entities.Document;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vlad
 */
public class DocumentService {
    
    private EntityManagerFactory emf;
    
    private DocumentService(){
        emf = Persistence.createEntityManagerFactory("caseHelper-serverPU");
    }
    
    private static final class SingletonHolder {
        private static final DocumentService SINGLETON = new DocumentService();
    }
    
    public static DocumentService getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    public void addDocument(DocumentDto documentDto){
        
        EntityManager em = emf.createEntityManager();
        DocumentDao caseDao = new DocumentDao(em);
        
        em.getTransaction().begin();
        
        Document document = new Document();
        document.setDocumentName(documentDto.getDocumentName());
        
        em.getTransaction().commit();
    }
    
    public void deleteDocument(DocumentDto documentDto){
        
        EntityManager em = emf.createEntityManager();
        DocumentDao documentDao = new DocumentDao(em);
        
        em.getTransaction().begin();
        
        Document newDocument = documentDao.findDocumentById(documentDto.getId());
        documentDao.deleteDocument(newDocument);
        
        em.getTransaction().commit();
    }
}
