package Modele.Metier;

import Modele.Metier.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-08T00:08:53", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MateriaPrima.class)
public class MateriaPrima_ { 

    public static volatile SingularAttribute<MateriaPrima, Integer> cantitad;
    public static volatile SingularAttribute<MateriaPrima, Long> id;
    public static volatile SingularAttribute<MateriaPrima, String> nombre;
    public static volatile SetAttribute<MateriaPrima, Producto> productos;
    public static volatile SingularAttribute<MateriaPrima, Integer> version;

}