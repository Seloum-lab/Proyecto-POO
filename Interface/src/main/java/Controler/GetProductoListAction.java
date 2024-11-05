/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Metier.Producto;
import Modele.Service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeLL
 */
public class GetProductoListAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        List<Producto> result = null;
        
        try {
            result = Service.getListeProducto();
        } catch(Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("productoList", result);
        }
    }
    
}
