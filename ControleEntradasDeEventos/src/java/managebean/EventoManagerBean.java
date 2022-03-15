/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Evento;
import servico.EventoServico;
import utilitario.Mensagem;

/**
 *
 * @author arthur
 */
@ManagedBean
@ViewScoped
public class EventoManagerBean implements Serializable{
    private Evento evento;
    private List<Evento> eventos;
    
    @EJB
    EventoServico eventoServico;
    
    @PostConstruct
    public void iniciar(){
        this.evento = new Evento();
        this.eventos = new ArrayList();
        this.eventos = eventoServico.findAll();
    }
    
    public void salvar(){
        eventoServico.salvar(evento);
        Mensagem.success("Evento ("+ this.evento.getNome() + ") registrado com sucesso");
        this.evento = new Evento();
    }
    
    public void atualizar(){
        eventoServico.atualizar(evento);
    }
    
    public void adicionarEvento(){
        this.eventos.add(this.evento);
        this.evento = new Evento();
    }
    
    public void removerEvento(Evento item){
        this.eventos.remove(item);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public void desativar(){
        this.evento.setAtivo(false);
        eventoServico.atualizar(this.evento);
        Mensagem.successAndRedirect("Operação realizada com sucesso!", "listarEventos.xhtml");
    }
    
    public void contar(){
        Mensagem.success("O numero de eventos ativos é: " + eventoServico.count());
    }
    
}
