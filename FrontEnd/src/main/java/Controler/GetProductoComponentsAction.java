/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Metier.MateriaPrima;
import Modele.Service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class GetProductoComponentsAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        List<MateriaPrima> listMateria = null;
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("ProductoID");
        
        try {
            listMateria = Service.getMateriPrimaDeUnProducto(id);
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            req.setAttribute("materiaList", listMateria);
        }
    }
    
}
