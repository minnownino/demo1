/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.regex.*;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/StorepersonInfo"})
public class StorepersonInfo extends HttpServlet {
    private RequestDispatcher rd;
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
     
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        boolean valid = false;
         String name, gender, email,address,cellphone,sosmessage,er,eer;
        int ID; // delete the 6!
        
    
       Statement st;      
       HttpSession session = request.getSession();
       IDbean newID = (IDbean)session.getAttribute("IDbean");
       ID=newID.getstudentID();
       
// get session above
        

       // ID=Integer.parseInt(request.getParameter ("ID"));
        name = request.getParameter ("name");
         gender = request.getParameter ("gender");
          email = request.getParameter ("email");
           address = request.getParameter ("address");
            cellphone = request.getParameter ("cellphone");
             sosmessage = request.getParameter ("sosmessage");
              er="1";eer="2";
              Date birthday=new Date();
        try {
            birthday = sdf.parse(request.getParameter ("birthday"));
        } catch (ParseException ex) {
            Logger.getLogger(StorepersonInfo.class.getName()).log(Level.SEVERE, null, ex);
            eer="here1";
        }
 
        
        //open the DBMS and insert the record
        try{
             Class.forName("org.apache.derby.jdbc.ClientDriver");
             String connectionURL = "jdbc:derby://localhost:1527/IS2560";
             Connection con = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");        
             st = con.createStatement();           
             String q1 = new String("INSERT INTO PEOPLE_CONTACTINFO VALUES ("+ID+",'"+name+"','"+gender+"','"+email+"','"+address+"','"+cellphone+"','"+sosmessage+"','"+sdf.format(birthday)+"')");
             //System.out.println(q1);
             st.executeUpdate(q1);
             valid=true;
        }        
        catch (SQLException se)
        {
            se.printStackTrace();  
            er="heresql";
        } catch (ClassNotFoundException ex) {
           
            er="hereclass";
        }
        rd = getServletContext().getRequestDispatcher("/setdisease_equipment.jsp");
        request.setAttribute("id", ID);
        //rd.forward(request, response);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        if (valid)
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Message Confirmation</title>");
        out.println("</head>");
        out.println("<body>");
      
      
        out.println("<h3><a href =\"listMessages\">Click here for list</a></h3>");        
        out.println("</body>");
        out.println("</html>");
        }
        else
        {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Message Storage Problem</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(ID);
        out.println(name);
        out.println(gender);
        out.println(email);
        out.println(address);
        out.println(cellphone);
        out.println(sosmessage);
        out.println(birthday);
        out.println("<a href =\"listMessages\">nope</a>"); 
        out.println("<a >"+ request.getParameter("birthday")+er+"</a>"); 
        out.println("<a >"+ eer+"</a>"); 
         out.println(birthday); 
        
        out.println("</body>");
        out.println("</html>");   
        }
        out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}

