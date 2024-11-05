/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Modele.Metier.Producto;
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
public class ProductoListSerialization extends Serialization{

    @Override
    public void serialize(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Gson gson = new GsonBuilder().serializeNulls().create();
        JsonObject container = new JsonObject();
        JsonArray productosJson = new JsonArray();
        
        List<Producto> productos = (List<Producto>) req.getAttribute("productoList");
        
        for (Producto producto : productos) {
            JsonObject productoJson = new JsonObject();
            productoJson.addProperty("id", producto.getId());
            productoJson.addProperty("nombre", producto.getNombre());
            productoJson.addProperty("cantitad", producto.getCantitad());
            productosJson.add(productoJson);            
        }
        
        container.add("productoList", productosJson);
        
        res.setContentType("application/json;charset=UTF-8");
        PrintWriter out;

        out = res.getWriter();
        out.println(gson.toJson(container));
        out.close(); 
    }
    
}
