/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import generico.ServicoGenerico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Pulseira;

/**
 *
 * @author arthur
 */
@Stateless
public class PulseiraServico extends ServicoGenerico<Pulseira>{
    
    private Pulseira p;
    
    public PulseiraServico() {
        super(Pulseira.class);
    }
    
    @PersistenceContext
    EntityManager em;
    
    

    
    
}
