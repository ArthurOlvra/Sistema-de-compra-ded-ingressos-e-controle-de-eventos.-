package modelo;

import enums.TipoAcesso;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Evento;
import modelo.Pessoa;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-15T12:49:12")
@StaticMetamodel(Pulseira.class)
public class Pulseira_ { 

    public static volatile SingularAttribute<Pulseira, Long> codigo;
    public static volatile SingularAttribute<Pulseira, Evento> evento;
    public static volatile SingularAttribute<Pulseira, Boolean> ativo;
    public static volatile SingularAttribute<Pulseira, Pessoa> pessoa;
    public static volatile SingularAttribute<Pulseira, TipoAcesso> acesso;

}