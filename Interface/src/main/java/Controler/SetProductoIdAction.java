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
public class SetProductoIdAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("ProductoID"));
        HttpSession session = req.getSession(false);
        session.setAttribute("ProductoID", id); 
        req.setAttribute("success", true); 
    }
    
}
