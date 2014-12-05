/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yuminnow
 */
@WebServlet(urlPatterns = {"/check"})
public class checkpassword extends HttpServlet {
    private Statement st;
    private int b;
    private RequestDispatcher rd;
    Integer c;
    String ID;
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
        String connectionURL = "jdbc:derby://localhost:1527/IS2560";
        Connection con = DriverManager.getConnection(connectionURL,"IS2560","IS2560");
        String a = request.getParameter("username");
        String sql = "select user_id,password from users where username = "+"'"+request.getParameter("username")+"'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){                
                if(request.getParameter("password").equals(rs.getString("password").trim())){
                c= rs.getInt("user_id");
                
                          //more spaces in setting username in table, trim is very useful
                rd = getServletContext().getRequestDispatcher("/personalinfo.jsp"); }                             
                else
                    rd = getServletContext().getRequestDispatcher("/register.jsp");
                    
                    
            }        
        IDbean sid = new IDbean();
        sid.setstudentID(c);
        HttpSession session = request.getSession();
        session.setAttribute("IDbean", sid);
        request.setAttribute("id",c);
        rd.forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet check</title>");            
            out.println("</head>");            
            out.println("<body>");
            out.println(request.getParameter("username")+"\t"+request.getParameter("password"));
            out.println("<h1>Servlet check at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        //if(b==1){
        //        rd = getServletContext().getRequestDispatcher("/welcome.jsp");}
        //else{
        //        rd = getServletContext().getRequestDispatcher("/register.jsp");}
        //rd.forward(request, response);
        //rs.close();
        //st.close();
        //con.close();
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
            Logger.getLogger(checkpassword.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(checkpassword.class.getName()).log(Level.SEVERE, null, ex);
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
