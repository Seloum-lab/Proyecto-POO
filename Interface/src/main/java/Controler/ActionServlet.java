/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.JpaUtil;
import View.GetMateriaIdSerialization;
import View.GetProductoIdSerialization;
import View.MateriaListSerialization;
import View.MateriaSerialization;
import View.ProductoListSerialization;
import View.ProductoSerialization;
import View.SignInSerialization;
import View.SignUpSerialization;
import View.SuccessSerialization;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sbenbouzid
 */




@WebServlet(name = "ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
   
            /* TODO output your page here. You may use following sample code. */
            String todo = request.getParameter("todo");
            System.out.println("-------------------------------- todo = " + todo);
            
            
            switch(todo) {
                case "signUp":
                    System.out.println("--------------------------SignUp");
                    SignUpAction signUpAction = new SignUpAction();
                    signUpAction.execute(request);
                    SignUpSerialization signUpSerialization = new SignUpSerialization();
                    signUpSerialization.serialize(request, response);
                    break;
                    
                case "signIn":
                    System.out.println("--------------------------SignUp");
                    SignInAction signInAction = new SignInAction();
                    signInAction.execute(request);
                    SignInSerialization signInSerialization = new SignInSerialization();
                    signInSerialization.serialize(request, response);
                    break;
                    
                case "addMateria":
                    System.out.println("--------------------------SignUp");
                    AddMateriaPrimaAction addMateriaPrimaAction = new AddMateriaPrimaAction();
                    addMateriaPrimaAction.execute(request);
                    SuccessSerialization successSerialization = new SuccessSerialization();
                    successSerialization.serialize(request, response);
                    break;
                    
                case "addProducto":
                    System.err.println("--------------------------SignUp");
                    AddProductoAction addProductoAction = new AddProductoAction();
                    addProductoAction.execute(request);
                    SuccessSerialization successSerialization1 = new SuccessSerialization();
                    successSerialization1.serialize(request, response);
                    break;
                    
                case "getListProduct":
                    System.err.println("--------------------------getListProducto");
                    GetProductoListAction getProductoListAction = new GetProductoListAction();
                    getProductoListAction.execute(request);
                    ProductoListSerialization productoListSerialization = new ProductoListSerialization();
                    productoListSerialization.serialize(request, response);
                    break;
                    
                    
                case "getListMateria":
                    System.err.println("--------------------------getListMateria");
                    GetMateriaListAction getMateriaListAction = new GetMateriaListAction();
                    getMateriaListAction.execute(request);
                    MateriaListSerialization materiaListSerialization = new MateriaListSerialization();
                    materiaListSerialization.serialize(request, response);
                    break;
                    
                case "getProductoID":
                    System.err.println("--------------------------getProductoID");
                    GetProductoIdAction getProductoIdAction = new GetProductoIdAction();
                    getProductoIdAction.execute(request);
                    GetProductoIdSerialization getProductoIdSerialization = new GetProductoIdSerialization();
                    getProductoIdSerialization.serialize(request, response);
                    break;
                    
                case "getMateriaID":
                    System.err.println("--------------------------getMateriaID");
                    GetMateriaIdAction getMateriaIdAction = new GetMateriaIdAction();
                    getMateriaIdAction.execute(request);
                    GetMateriaIdSerialization getMateriaIdSerialization = new GetMateriaIdSerialization();
                    getMateriaIdSerialization.serialize(request, response);
                    break;
                    
                case "setMateriaID":
                    System.err.println("--------------------------setMateriaID");
                    SetMateriaIdAction setMateriaIdAction = new SetMateriaIdAction();
                    setMateriaIdAction.execute(request);
                    SuccessSerialization successSerialization3 = new SuccessSerialization();
                    successSerialization3.serialize(request, response);
                    break;
                    
                    
                case "setProductoID":
                    System.err.println("--------------------------setProductoID");
                    SetProductoIdAction setProductoIdAction = new SetProductoIdAction();
                    setProductoIdAction.execute(request);
                    SuccessSerialization successSerialization7 = new SuccessSerialization();
                    successSerialization7.serialize(request, response);
                    break;
                    
                case "verifyMateriaId":
                    System.err.println("--------------------------verifyMateriaId");
                    VerifyMateriaIdAction verifyMateriaIdAction = new VerifyMateriaIdAction();
                    verifyMateriaIdAction.execute(request);
                    SuccessSerialization successSerialization4 = new SuccessSerialization();
                    successSerialization4.serialize(request, response);
                    break;
                    
                case "verifyProductoId":
                    System.err.println("--------------------------verifyProductoId");
                    VerifyProductoIdAction verifyProductoIdAction = new VerifyProductoIdAction();
                    verifyProductoIdAction.execute(request);
                    SuccessSerialization successSerialization8 = new SuccessSerialization();
                    successSerialization8.serialize(request, response);
                    break;
                    
                case "getMateriaInfo":
                    System.err.println("--------------------------getMateriaInfo");
                    GetMateriaInformationAction getMateriaInformationAction = new GetMateriaInformationAction();
                    getMateriaInformationAction.execute(request);
                    MateriaSerialization materiaSerialization = new MateriaSerialization();
                    materiaSerialization.serialize(request, response);
                    break;
                    
                    
                case "getProductoInfo":
                    System.err.println("--------------------------getProductoInfo");
                    GetProductoInformationsAction getProductoInformationsAction = new GetProductoInformationsAction();
                    getProductoInformationsAction.execute(request);
                    ProductoSerialization productoSerialization = new ProductoSerialization();
                    productoSerialization.serialize(request, response);
                    break;
                    
                case "addQuantityMateria":
                    System.err.println("--------------------------addQuantityMateria");
                    AddQuantityMateriaPrimaAction addQuantityMateriaPrimaAction = new AddQuantityMateriaPrimaAction();
                    addQuantityMateriaPrimaAction.execute(request);
                    SuccessSerialization successSerialization5 = new SuccessSerialization();
                    successSerialization5.serialize(request, response);
                    break;
                    
                    
                case "addQuantityProducto":
                    System.err.println("--------------------------addQuantityproducto");
                    AddQuantityProductoAction addQuantityProductoAction = new AddQuantityProductoAction();
                    addQuantityProductoAction.execute(request);
                    SuccessSerialization successSerialization6 = new SuccessSerialization();
                    successSerialization6.serialize(request, response);
                    break;
                    
                    
                case "getProductoComponents":
                    System.err.println("--------------------------getProductoComponents");
                    GetProductoComponentsAction getProductoComponentsAction = new GetProductoComponentsAction();
                    getProductoComponentsAction.execute(request);
                    MateriaListSerialization materiaListSerialization1 = new MateriaListSerialization();
                    materiaListSerialization1.serialize(request, response);
                    break;
                    
                case "removeFromProducto":
                    System.err.println("--------------------------removeFromProducto");
                    RemoveMateriaFromProductoAction removeMateriaFromProductoAction = new RemoveMateriaFromProductoAction();
                    removeMateriaFromProductoAction.execute(request);
                    SuccessSerialization successSerialization9 = new SuccessSerialization();
                    successSerialization9.serialize(request, response);
                    break;
                    
                case "verifyConnection":
                    System.err.println("--------------------------verifyConnection");
                    VerifyConnectionAction verifyConnectionAction = new VerifyConnectionAction();
                    verifyConnectionAction.execute(request);
                    SuccessSerialization successSerialization10 = new SuccessSerialization();
                    successSerialization10.serialize(request, response);
                    break;
                    
                    
                case "getMateriaExceptoProducto":
                    System.err.println("--------------------------getMateriaExceptoProducto");
                    GetMateriaExceptoProducto getMateriaExceptoProducto = new GetMateriaExceptoProducto();
                    getMateriaExceptoProducto.execute(request);
                    MateriaListSerialization materiaListSerialization3 = new MateriaListSerialization();
                    materiaListSerialization3.serialize(request, response);
                    break;
                    
                    
                case "addMateriaEnProducto":
                    System.err.println("--------------------------addMateriaEnProducto");
                    AddMateriaPrimaEnProductoAction addMateriaPrimaEnProductoAction = new AddMateriaPrimaEnProductoAction();
                    addMateriaPrimaEnProductoAction.execute(request);
                    SuccessSerialization successSerialization11 = new SuccessSerialization();
                    successSerialization11.serialize(request, response);
                    break;
                    
                case "verifyAdmin":
                    System.err.println("--------------------------verifyAdmin");
                    VerifyAdminAction verifyAdminAction = new VerifyAdminAction();
                    verifyAdminAction.execute(request);
                    SuccessSerialization successSerialization12 = new SuccessSerialization();
                    successSerialization12.serialize(request, response);
                    break;
                    
                case "disconnect":
                    System.err.println("--------------------------disconnect");
                    DisconnectAction disconnectAction = new DisconnectAction();
                    disconnectAction.execute(request);
                    SuccessSerialization successSerialization13 = new SuccessSerialization();
                    successSerialization13.serialize(request, response);
                    break;

                case "clearSession" :
                    System.err.println("--------------------------clearSession");
                    ClearSessionObjectsAction clearSessionObjectsAction = new ClearSessionObjectsAction();
                    clearSessionObjectsAction.execute(request);
                    SuccessSerialization successSerialization14 = new SuccessSerialization();
                    successSerialization14.serialize(request, response);
                    break;
                    

                    
            }
           
            
            
            
            System.out.println(" [TEST] Appel de l’ActionServlet : todo = " + todo);
          }
    
    
    @Override
    public void init() throws ServletException {
        super.init();
        JpaUtil.creerFabriquePersistance();
    }

    @Override
    public void destroy() {
        JpaUtil.fermerFabriquePersistance();
        super.destroy();
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}