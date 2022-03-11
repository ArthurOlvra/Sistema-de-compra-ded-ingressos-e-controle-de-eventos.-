/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author arthur
 */
@Entity
public class Evento implements Serializable{
    @Id
    @SequenceGenerator(sequenceName = "seq_evento", name = "seq_evento", allocationSize = 1)
    @GeneratedValue(generator = "seq_evento", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String nome;
    
    @OneToMany
    private List<Pulseira> pulseira;
    
    @Temporal(TemporalType.DATE)
    private Date dataEvento;
    
    private boolean ativo = true;

    public Long getId() {
        return id;
    }

    public void setId(Long codigo) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pulseira> getPulseira() {
        return pulseira;
    }

    public void setPulseira(List<Pulseira> pulseira) {
        this.pulseira = pulseira;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
        
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.pulseira);
        hash = 97 * hash + Objects.hashCode(this.dataEvento);
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
        final Evento other = (Evento) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pulseira, other.pulseira)) {
            return false;
        }
        if (!Objects.equals(this.dataEvento, other.dataEvento)) {
            return false;
        }
        return true;
    }
    
    
    
}
