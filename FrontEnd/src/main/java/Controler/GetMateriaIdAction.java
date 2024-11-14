/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DeLL
 */
public class GetMateriaIdAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        Long id;
        HttpSession session = req.getSession();
        if (session == null) {
            req.setAttribute("success", false);
        } else {
            id = (Long) session.getAttribute("MateriaID");
            if (id == null) {
                req.setAttribute("success", false);
            } else {
                req.setAttribute("success", true);
                req.setAttribute("MateriaID", id);
            }
        }
    }
    
}
