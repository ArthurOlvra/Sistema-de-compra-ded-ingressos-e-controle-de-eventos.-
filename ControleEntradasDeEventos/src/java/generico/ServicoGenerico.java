/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generico;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author arthur
 * @param <T>
 */
public class ServicoGenerico<T> {
    
    private final Class<T> entity;
    
    @PersistenceContext
    EntityManager em;
    
    public ServicoGenerico(Class<T> entity){
        this.entity = entity;
    }
    
    public void salvar(T entidade){
        em.persist(entidade);
    }
    
    public void delete(T entidade){
        em.merge(entidade);
    }
    
    public void atualizar(T entidade){
        em.merge(entidade);
        em.flush();
    }
    
    public T find(Long entidadeID){
        T objeto = getEm().find(entity, entidadeID);
        return objeto;
    }
    
    public List<T> findAll(){
        return em.createQuery("select e from " + entity.getSimpleName() + " e WHERE e.ativo = true").getResultList();
    }
                    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class<T> getEntity() {
        return entity;
    }
    
    public Long count(){        
        return(Long)em.createQuery("select count(o) from " + entity.getSimpleName() + " o WHERE o.ativo = true ").getSingleResult();
    }
    
}