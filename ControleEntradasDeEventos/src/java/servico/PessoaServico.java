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
import modelo.Pessoa;

/**
 *
 * @author arthur
 */
@Stateless
public class PessoaServico extends ServicoGenerico<Pessoa>{
    public PessoaServico() {
        super(Pessoa.class);
    }
    
    @PersistenceContext
    EntityManager em;
    
}
