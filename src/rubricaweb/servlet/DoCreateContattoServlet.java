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

@WebServlet(urlPatterns = { "/doCreateContatto" })
public class DoCreateContattoServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
 
   public DoCreateContattoServlet() {
       super();
   }
 
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       Connection conn = MyUtils.getStoredConnection(request);
 
       String nome = (String) request.getParameter("nome");
       String cognome = (String) request.getParameter("cognome");
       String indirizzo = (String) request.getParameter("indirizzo");
       String telefono = (String) request.getParameter("telefono");
       String etaIns = (String) request.getParameter("eta");
       int  eta = 0;
       String errorString = null;
       try {
           eta = Integer.parseInt(etaIns);
       } catch (Exception e) {
    	   errorString = "Età inserita non valida!";
    	   
       }
       
       if(!MyUtils.verificaDati(nome, cognome, indirizzo, telefono)){
    	   errorString ="Uno o più dati mancanti o non validi!";
       }
       
       Persona p = new Persona(nome, cognome, indirizzo, telefono, eta);

       if (errorString == null) {
           try {
               DBUtils.inserisciPersona(conn, p);
           } catch (SQLException e) {
               e.printStackTrace();
               errorString = e.getMessage();
           }
       }
        
       // Store infomation to request attribute, before forward to views.
       request.setAttribute("errorString", errorString);
       request.setAttribute("persona", p);
 
       // If error, forward to Edit page.
       if (errorString != null) {
           RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createContattoView.jsp");
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