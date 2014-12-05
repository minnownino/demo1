/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yuminnow
 */
@WebServlet(urlPatterns = {"/checkname"})
public class checkname extends HttpServlet {
    private Statement st;
    private int b=0;
    private RequestDispatcher rd;
    String a;

    //RequestDispatcher rdr;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected int processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        String connectionURL = "jdbc:derby://localhost:1527/IS2560";
        Connection con = DriverManager.getConnection(connectionURL,"IS2560","IS2560");
        
        //String a = request.getParameter("username");
        String q1 = "SELECT username FROM users";
        st = con.createStatement();
        ResultSet rs = st.executeQuery(q1);
        while(rs.next()){
                a=rs.getString("username");
                if(request.getParameter("username").equals(rs.getString("username").trim()))//more spaces in setting username in table, trim is very useful
                {   rd = getServletContext().getRequestDispatcher("/check");
                    
                    rd.forward(request, response);}
                    
            }
        request.setAttribute("error", "invalid username");
        rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet checkname</title>");            
            out.println("</head>");
            out.println("<body>");            
            out.println("<h1>Servlet checkname at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }
        return b;
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkname.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(checkname.class.getName()).log(Level.SEVERE, null, ex);
        }
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
