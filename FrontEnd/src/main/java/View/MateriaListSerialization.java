/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Modele.Metier.MateriaPrima;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DeLL
 */
public class MateriaListSerialization extends Serialization{
    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject container = new JsonObject();
        JsonArray materiasJson = new JsonArray();
        
        List<MateriaPrima> materias = (List<MateriaPrima>) req.getAttribute("materiaList");
        
        for (MateriaPrima materia : materias) {
            JsonObject materiaJson = new JsonObject();
            materiaJson.addProperty("id", materia.getId());
            materiaJson.addProperty("nombre", materia.getNombre());
            materiaJson.addProperty("cantitad", materia.getCantitad());
            materiasJson.add(materiaJson);            
        }
        
        container.add("materiaList", materiasJson);
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(container));
        out.close(); 
    }
    
}
