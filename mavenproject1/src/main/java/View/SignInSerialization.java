/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Modele.Metier.Cuenta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DeLL
 */
public class SignInSerialization extends Serialization{

    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject container = new JsonObject();
        Cuenta cuenta = (Cuenta) req.getAttribute("cuenta");
        
        if (cuenta != null) {
            JsonObject cuentaJson = new JsonObject();
            cuentaJson.addProperty("id", cuenta.getId());
            cuentaJson.addProperty("mail", cuenta.getMail());
            cuentaJson.addProperty("rol", Boolean.FALSE);  
            cuentaJson.addProperty("nombre", cuenta.getNombre());
            container.addProperty("connexion", true);
            container.add("cuenta", cuentaJson);
        } else {
            container.addProperty("connexion", false);
        }
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(container));
        out.close();   
        
    }
    
}
