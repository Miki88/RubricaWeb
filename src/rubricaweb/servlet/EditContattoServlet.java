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

@WebServlet(urlPatterns = { "/editContatto" })
public class EditContattoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditContattoServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String codId = (String) request.getParameter("id");
        Persona p = null;
 
        String errorString = null;
 
        try {
            p = DBUtils.trovaPersona(conn, codId);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
         
        // If no error.
        // The contact does not exist to edit.
        // Redirect to home page.
        if (errorString != null && p == null) {
            response.sendRedirect(request.getServletPath() + "/home");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("persona", p);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editContattoView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
