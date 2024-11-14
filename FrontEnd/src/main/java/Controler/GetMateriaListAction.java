/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Metier.MateriaPrima;
import Modele.Service.Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeLL
 */
public class GetMateriaListAction extends Action {

    @Override
    public void execute(HttpServletRequest req) {
        List<MateriaPrima> result = null;
        
        try {
            result = Service.getListeMateriaPrima();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("materiaList", result);
        }
    }
    
}
