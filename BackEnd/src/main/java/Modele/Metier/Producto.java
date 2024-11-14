/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modele.Metier;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

/**
 *
 * @author DeLL
 */
@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    Integer cantitad;
    @ManyToMany
    @JoinTable(name = "fabricado_con", joinColumns = @JoinColumn(name = "id_producto"), inverseJoinColumns = @JoinColumn(name = "id_materia"))
    Set<MateriaPrima> materiaPrimas;
    @Version
    int version;

    public Producto() {
    }

    public Producto(String nombre, Integer cantitad) {
        this.nombre = nombre;
        this.cantitad = cantitad;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    
    
    

    public Set<MateriaPrima> getMateriaPrimas() {
        return materiaPrimas;
    }

    public void setMateriaPrimas(Set<MateriaPrima> materiaPrimas) {
        this.materiaPrimas = materiaPrimas;
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
