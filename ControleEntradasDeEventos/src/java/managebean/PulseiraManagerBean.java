/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebean;

import enums.TipoAcesso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import modelo.Evento;
import modelo.Pessoa;
import modelo.Pulseira;
import servico.EventoServico;
import servico.PessoaServico;
import servico.PulseiraServico;


/**
 *
 * @author arthur
 */
@ManagedBean
@ViewScoped
public class PulseiraManagerBean implements Serializable{
    private Pulseira pulseira;
    private List<Pulseira> pulseiras;
    private List<Evento> eventos;
    private Pessoa p;
    
    @EJB
    PulseiraServico pulseiraServico;
    @EJB
    EventoServico eventoServico;
    @EJB
    PessoaServico pessoaServico;
    
    @PostConstruct
    public void iniciar(){
        this.p = new Pessoa();
        this.pulseira = new Pulseira();
        this.pulseiras = new ArrayList();
        this.pulseiras = pulseiraServico.findAll();
        this.eventos = new ArrayList();
        this.eventos = eventoServico.findAll();
    }
    
    public List<SelectItem> itens() {
        // CRIAÇÃO DE SELECT DE ITENS
        List<SelectItem> items = new ArrayList<>();
        
        // PERCORRENDO O ENUM DE TipoAcesso
        for (TipoAcesso item : TipoAcesso.values()) {
            
            // ADCIONA NA LISTA DE SELECT ITENS        
            items.add(new SelectItem(item, item.name()));
        }
        
        return items;
    }
    
    public void salvar(){
        pessoaServico.salvar(this.p);
        pessoaServico.find(this.p.getId());
        this.pulseira.setPessoa(this.p);
        pulseiraServico.salvar(this.pulseira);
        this.pulseira = new Pulseira();
        this.p = new Pessoa();
    }
    
    public void atualizar(){
        pulseiraServico.atualizar(pulseira);
    }
    
    public void adicionarEvento(){
        this.pulseiras.add(this.pulseira);
        this.pulseira = new Pulseira();
    }
    
    public void removerEvento(Pulseira item){
        this.pulseiras.remove(item);
    }   

    public List<Evento> getEventos() {
        return eventos;
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }
    
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public Pulseira getPulseira() {
        return pulseira;
    }

    public void setPulseira(Pulseira pulseira) {
        this.pulseira = pulseira;
    }

    public List<Pulseira> getPulseiras() {
        return pulseiras;
    }

    public void setPulseiras(List<Pulseira> pulseiras) {
        this.pulseiras = pulseiras;
    }
    
    public void ativar(){
        this.pulseira.setAtivo(false);
        pulseiraServico.atualizar(pulseira);
    }
    
    public void desativar(){
        pulseiraServico.delete(this.pulseira);
    }
    
    public List<Evento> autoCompleteEventos(){
        return eventoServico.findAll();
    }
}
