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
@WebServlet(urlPatterns = {"/saveuser"})
public class saveuser extends HttpServlet {
    ResultSet rs;
    Statement st;
    String a;
    int b;
    private RequestDispatcher rd;
       /**
     * @return the newname
     */
   
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
        //Connection con = (Connection)request.getSession(false).getAttribute("myconn");
        String connectionURL = "jdbc:derby://localhost:1527/IS2560";
        Connection con = DriverManager.getConnection(connectionURL,"IS2560","IS2560");
            st = con.createStatement();            
            String q1 = "insert into users (username, password) values ("+"'"+request.getParameter("usernamer")+"','"+request.getParameter("passwordr")+"')";
            //String q2 = "insert into customer values ('yue','er')";        
            st.executeUpdate(q1);
            st.close();
            
            st=con.createStatement();
            String q2 = "select user_id from users where username='"+request.getParameter("usernamer")+"'";
            rs = st.executeQuery(q2);
            while(rs.next()){
                //a = rs.getString("username");
                b = rs.getInt("user_id");
            }
            IDbean sid = new IDbean();
            sid.setstudentID(b);
            HttpSession session = request.getSession();
            session.setAttribute("IDbean",sid);
            request.setAttribute("id",b);
            rd = getServletContext().getRequestDispatcher("/profile.jsp");
            rd.forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet saveuser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(b);
            out.println("insert successfully username:"+request.getParameter("usernamer"));
            out.println("<h3><a href =\"index.jsp\">Click here for login</a></h3>");
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
            Logger.getLogger(saveuser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(saveuser.class.getName()).log(Level.SEVERE, null, ex);
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
