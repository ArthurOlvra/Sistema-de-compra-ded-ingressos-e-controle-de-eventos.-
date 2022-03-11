/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import enums.TipoAcesso;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author arthur
 */
@Entity
public class Pulseira implements Serializable{
    @Id
    @SequenceGenerator(sequenceName = "seq_pulseira", name = "seq_pulseira", allocationSize = 1)
    @GeneratedValue(generator = "seq_pulseira", strategy = GenerationType.SEQUENCE)
    private Long codigo;
    
    private TipoAcesso acesso;
    @ManyToOne
    private Pessoa pessoa;
    
    @ManyToOne
    private Evento evento;
    
    private boolean ativo = true;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoAcesso getAcesso() {
        return acesso;
    }

    public void setAcesso(TipoAcesso acesso) {
        this.acesso = acesso;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.codigo);
        hash = 71 * hash + Objects.hashCode(this.acesso);
        hash = 71 * hash + Objects.hashCode(this.pessoa);
        hash = 71 * hash + Objects.hashCode(this.evento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pulseira other = (Pulseira) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (this.acesso != other.acesso) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        return true;
    }
    
    
}
