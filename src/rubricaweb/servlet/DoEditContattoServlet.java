package rubricaweb.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import rubricaweb.classi.Persona;
import rubricaweb.utils.DBUtils;
import rubricaweb.utils.MyUtils;

@WebServlet(urlPatterns = { "/doEditContatto" })
public class DoEditContattoServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public DoEditContattoServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
       
       int id = Integer.parseInt(request.getParameter("id"));
       String nome = (String) request.getParameter("nome");
       String cognome = (String) request.getParameter("cognome");
       String indirizzo = (String) request.getParameter("indirizzo");
       String telefono = (String) request.getParameter("telefono");
       String etaStr = (String) request.getParameter("eta");
       int eta = 0;
       String errorString = null;
       try {
           eta = Integer.parseInt(etaStr);
       } catch (Exception e) {
    	   errorString = "Età inserita non valida!";
       }
       
       if(!MyUtils.verificaDati(nome, cognome, indirizzo, telefono)){
    	   errorString ="Uno o più dati mancanti o non validi!";
       }
       
       Persona pers = new Persona(id, nome, cognome, indirizzo, telefono, eta);
 

       try {
           DBUtils.modificaPersona(conn, pers);
       } catch (SQLException e) {
           e.printStackTrace();
           errorString = e.getMessage();
       }
 
       // Store infomation to request attribute, before forward to views.
       request.setAttribute("errorString", errorString);
       request.setAttribute("persona", pers);
 
 
       // If error, forward to Edit page.
       if (errorString != null) {
           RequestDispatcher dispatcher = request.getServletContext()
                   .getRequestDispatcher("/WEB-INF/views/editContattoView.jsp");
           dispatcher.forward(request, response);
       }
        
       // Redirect to the home page.            
       else {
           response.sendRedirect(request.getContextPath() + "/home");
       }
 
   }
 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }
 
}