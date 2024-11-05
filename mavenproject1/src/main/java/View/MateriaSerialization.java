/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Modele.Metier.MateriaPrima;
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
public class MateriaSerialization extends Serialization {
    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject container = new JsonObject();
        MateriaPrima materia = (MateriaPrima) req.getAttribute("Materia");
        container.addProperty("id", materia.getId());
        container.addProperty("nombre", materia.getNombre());
        container.addProperty("cantitad", materia.getCantitad());
        
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(container));
        out.close();  
        
        
    }
    
}