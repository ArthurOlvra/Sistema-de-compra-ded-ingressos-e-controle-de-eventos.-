/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author elybezerra
 */
public class MensagemSimples {
    
    
    public static void mensagemInfo(String mensagemTitulo){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensagemTitulo));
    }
    
}
