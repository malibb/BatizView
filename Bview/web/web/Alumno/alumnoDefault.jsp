<%
   
    Object x;
   
    try{
  
        x = request.getSession().getAttribute("Sesion");
        x = x.equals(true);
        
    }
    catch(NullPointerException e){
        
        x = false;
    }
    
    if(x.equals(false)){
    
        response.sendRedirect("../public/error.jsp");
    
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=x%></h1>
        
    </body>
</html>
