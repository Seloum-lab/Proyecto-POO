/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.Metier;

import java.io.Serializable;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

/**
 *
 * @author DeLL
 */
@Entity
public class MateriaPrima implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    Integer cantitad;
    @ManyToMany(mappedBy = "materiaPrimas")
    Set<Producto> productos;
    @Version
    int version;

    public MateriaPrima() {
    }

    public MateriaPrima(String nombre) {
        this.nombre = nombre;
        this.cantitad = 0;
    }
    
    public MateriaPrima(String nombre, Integer cantitad) {
        this.nombre = nombre;
        this.cantitad = cantitad;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    
    
    

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantitad() {
        return cantitad;
    }

    public void setCantitad(Integer cantitad) {
        this.cantitad = cantitad;
    }
    
    
    
    
}
