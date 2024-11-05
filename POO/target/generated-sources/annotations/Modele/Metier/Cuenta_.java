package Modele.Metier;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-29T22:27:54", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Cuenta.class)
public abstract class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> password;
    public static volatile SingularAttribute<Cuenta, String> mail;
    public static volatile SingularAttribute<Cuenta, Long> id;
    public static volatile SingularAttribute<Cuenta, String> nombre;
    public static volatile SingularAttribute<Cuenta, String> rol;

}