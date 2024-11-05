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
public class DisconnectAction extends Action{

    @Override
    public void execute(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.invalidate();
        req.setAttribute("success", true);
    }
    
}
