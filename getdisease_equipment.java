/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chi
 */
@WebServlet(urlPatterns = {"/getdisease_equipment"})
public class getdisease_equipment extends HttpServlet {
    
     private Connection conn;
    private Statement st;
    private ResultSet rs,sc;
   // public String ID;
    String sql_equipment;
            String sql_disease;
;
   // int sclength=0;
    
    int ID;
    private RequestDispatcher rd;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        //Statement st;      
      // HttpSession session = request.getSession();
         
            
                    try{
              Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/IS2560";
            conn = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");
            st = conn.createStatement();
          
            HttpSession session = request.getSession();
            IDbean newID = (IDbean)session.getAttribute("IDbean");
            ID=newID.getstudentID();  
           // IDbean newID = (IDbean)session.getAttribute("IDbean");
          //  ID=newID.getstudentID();
            String[] disease= request.getParameterValues("disease");
            String[] equipment= request.getParameterValues("equipment");
            
            for (int i = 0; i < disease.length; i++) {  
                        sql_disease =("INSERT INTO PEOPLE_DISEASE VALUES ("+ID+",'"+disease[i]+"')");

            
            st.executeUpdate(sql_disease);

            }
                 for (int j = 0; j < equipment.length; j++) {  
          
             sql_equipment =("INSERT INTO PEOPLE_EQUIPMENT VALUES ("+ID+",'"+equipment[j]+"')");
            st.executeUpdate(sql_equipment);

            }
          //  String sql_listselected = new String("SELECT * FROM SELECTED_COURSE WHERE ID='"+ID+"'");
         //   sc =  st.executeQuery(sql_listselected);

        rd = getServletContext().getRequestDispatcher("/success.jsp");
        request.setAttribute("id", ID);
        rd.forward(request, response);         
           
        }        
        catch (SQLException se)
        {   
            se.printStackTrace();  
        } catch (ClassNotFoundException ex) {
           out.println("class not found");
        }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourseList</title>");            
            out.println("</head>");
            out.println("<body>");
          
            out.println("<h1>Hello "+ID+"</h1>");
            out.println("<p>Please enter your grade for each course</p>");
      
            
                 
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
