package utilitario;

import javax.faces.context.FacesContext;

/**
 *
 * @author andre
 */
public class FacesUtil {
    
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
    
    public static String getRequestParameter(String name) {
        return getFacesContext()
                .getExternalContext()
                .getRequestParameterMap()
                .get(name);
    }
    
}