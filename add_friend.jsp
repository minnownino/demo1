<%-- 
    Document   : add_friend
    Created on : Nov 30, 2014, 4:57:42 PM
    Author     : yuminnow
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Recommend friend list.
        
        <form action="add_friend" method="POST">
            <select name="request">
                
                <%
               
        response.setContentType("text/html;charset=UTF-8");
        
          Connection con=null;
          ResultSet rs=null;
          String b=null;
          int c;
         
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String connectionURL = "jdbc:derby://localhost:1527/IS2560";
        con = DriverManager.getConnection(connectionURL, "IS2560", "IS2560");
        Statement st = con.createStatement();    
       
        c = (Integer)request.getAttribute("id");
         
        String q1 = new String("select * from users where user_id <>"+c);
        rs =  st.executeQuery(q1);
        while(rs.next())
            {
            %>
            <option value=<%=rs.getInt("user_id")%>> <%=rs.getString("username")%>  </option>           
            <%
            b = rs.getString("username");
            }
            //request.setAttribute("id", c);
        %>
            </select>
        <input type="submit" value="ok" />
        </form>
    </body>
</html>
