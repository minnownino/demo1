/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/friendrecommendation"})
public class friendrecommendation extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Statement st; 
        String connectionURL = "jdbc:derby://localhost:1527/IS2560";
        Connection con = DriverManager.getConnection(connectionURL,"IS2560","IS2560");
        HttpSession session = request.getSession();
        IDbean newID = (IDbean)session.getAttribute("IDbean");
        int ID=newID.getstudentID();
        st = con.createStatement();
        //find the current user's diseases
        String q0 = "select disease from disease where user_id = "+ID;
        ResultSet rs0 = st.executeQuery(q0);
        Array mydisease = rs0.getArray("disease");
        int i=0;      
        int j=i;
        //find the current user's address
        String q1 = "select address from users where user_id = "+ID;
        ResultSet rs1 = st.executeQuery("q1");
        String b=null;
        while(rs1.next()){
            b = rs1.getString("address");
        }
        //find the equipment the current user needs
        String    q2="select equipment from equipment as e, disease as d where disease = "+mydisease;
        ResultSet   rs2 = st.executeQuery(q2);
        Array myequipment = rs2.g;
        }   
        //match
        String[] disease= request.getParameterValues("disease");
        
        
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet friendrecommendation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet friendrecommendation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            Logger.getLogger(friendrecommendation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(friendrecommendation.class.getName()).log(Level.SEVERE, null, ex);
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
