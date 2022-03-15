/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Pessoa;
import servico.PessoaServico;
import utilitario.Mensagem;

/**
 *
 * @author arthur
 */
@ManagedBean
@ViewScoped
public class PessoaManagerBean {
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    
    @EJB
    PessoaServico pessoaServico;
    
    @PostConstruct
    public void iniciar(){
        this.pessoa = new Pessoa();
        this.pessoas = new ArrayList();
    }
    
    public void salvar(){
        pessoaServico.salvar(pessoa);
        Mensagem.success("Pessoa (" + this.pessoa.getNome() + ") cadastrada com socesso");
        this.pessoa = new Pessoa();
    }
    
    public void atualizar(){
        pessoaServico.atualizar(pessoa);
    }
    
    public void adicionarEvento(){
        this.pessoas.add(this.pessoa);
        this.pessoa = new Pessoa();
    }
    
    public void removerEvento(Pessoa item){
        this.pessoas.remove(item);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    public void ativar(){
        this.pessoa.setAtivo(false);
        pessoaServico.atualizar(pessoa);
    }
    
    public void desativar(){
        this.pessoa.setAtivo(false);
        pessoaServico.atualizar(pessoa);
    }
    
}
