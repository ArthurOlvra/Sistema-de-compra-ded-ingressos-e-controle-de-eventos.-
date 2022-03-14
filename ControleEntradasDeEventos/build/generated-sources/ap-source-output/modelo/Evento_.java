package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Pulseira;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-14T20:46:53")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, Date> dataEvento;
    public static volatile SingularAttribute<Evento, Boolean> ativo;
    public static volatile ListAttribute<Evento, Pulseira> pulseira;
    public static volatile SingularAttribute<Evento, String> nome;
    public static volatile SingularAttribute<Evento, Long> id;

}