/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Case;
import entities.Document;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Vlad
 */
public class DocumentDao {
    
    private EntityManager em;
    
    public DocumentDao(EntityManager em){
        this.em = em;
    }
    
    public void addDocument(Document document){
        em.persist(document);
    }
    
    
    public List<Document> getDocuments() {
        String sql = "SELECT d FROM DOCUMENT d";
        TypedQuery<Document> q = em.createQuery(sql, Document.class);
        return q.getResultList();
    }
    
    public Document findDocumentById(int documentId){
        return em.find(Document.class, documentId);
    }
    
    public void deleteDocument(Document document){
        em.remove(document);
    }
    
}
