/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modele.Metier.MateriaPrima;
import Modele.Service.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class GetMateriaInformationAction extends Action {
        @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        Long id = (Long) session.getAttribute("MateriaID");
        MateriaPrima materia = null;
        
        try {
            materia = Service.getMateriaById(id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            req.setAttribute("Materia", materia);
        }
        
        
        
        
    }
    
}
