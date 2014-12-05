<%-- 
    Document   : mypage
    Created on : Dec 5, 2014, 12:13:02 AM
    Author     : yuminnow
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
       
        //c = (Integer)request.getAttribute("id");
        c= 0; 
        //display all people who the current user helps
        String q1 = new String("select u.username from people_helper as p,users as u where p.user_id = u.user_id and helper_id = "+c);
        rs =  st.executeQuery(q1);
        %>
        <table border="2">
        <%
        while(rs.next())
            {
            
         %>   
         <tr><td><%=rs.getString("username")%></td> </tr>       
        <% }
        %>
        </table>
         <%//display all people who help the current
        String q2 = new String("select u.username from people_helper as p,users as u where p.helper_id = u.user_id and p.user_id ="+c);
        rs = st.executeQuery(q2);
         %>
        <table border="2">
        <%
        while(rs.next())
            {
            
         %>   
         <tr><td><%=rs.getString("username")%></td> </tr>       
        <% }
        %>
        </table>
        <%
        //current users' request without reply
        String q3 = new String("select username from friend as f, users as u where f.user_2 = u.user_id and f.user_1 = "+c);
        rs = st.executeQuery(q3);
        %>
        <table border="2">
        <%
        while(rs.next())
            {
            
         %>   
         <tr><td><%=rs.getString("username")%></td> </tr>       
        <% }
        %>
        </table>
        
        <h1>Hello World!</h1>
    </body>
</html>
