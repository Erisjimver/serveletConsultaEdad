<%-- 
    Document   : buscar
    Created on : 23-ago-2018, 9:31:18
    Author     : Israel
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.conexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="modelo.consultas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/> 
        <title>Consulta Persona</title>
    </head>
    <body style="margin-top: 30px">
        
       <%
       Statement s;
       ResultSet rs;
       conexion cn=new conexion();
       Connection c= cn.conexion();
       PreparedStatement ps;
       s = c.createStatement();
       rs = s.executeQuery("select * from persona"); 
       %>

            <div class="container">            
            <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#myModal">New Add</button>
            <div style="padding-left: 800px">                  
                <input type="text" class="form-control" value="Buscar"/>                            
            </div>
            </div> 
        <br>
         <div class="container"> 
        <table class="table table-bordered"  id="tablaDatos">
            <thead>
            <tr>
            <th>Cedula</th>
            <th>nombre</th>
            <th>apellido</th>
            <th>Fecha de consulta</th>
            <th>Edad</th>
            <th>Acciones</th>
            </tr>
           </thead>
           <tbody id="tbodys">
            <%while(rs.next()){%>

            <tr>
                  <td><%=rs.getString(1)%></td>
                  <td><%=rs.getString(2)%></td>
                  <td><%=rs.getString(3)%></td>
                  <td><%=rs.getString(4)%></td>
                  <td><%=rs.getString(5)%></td>
                
                    <td class="Opcion">
                   <input type="button" name="btnEliminar" value="Eliminar" id="btnEliminar" class="btn btn-danger" onclick="location.href='Servlet_Usu?codigoU=<%=rs.getString(1)%>&&accion=eliminar'">
                    </td>
                </tr>
            <%}%>
  

 </table>
            </div>    
        <div class="container">          
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document" style="z-index: 9999; width: 450px">
                    <div class="modal-content">
                        <div class="modal-header">                            
                            <h4 class="modal-title" id="myModalLabel">Agregar Registro</h4>
                        </div>
                        <div class="modal-body">
                            <form action="serveletRegistro" method="post">
                                <label>Cedula:</label>   <input type="text" name="cedula" class="form-control"/>
                                <label>Nombre:</label>   <input type="text" name="nombre" class="form-control"/> 
                                <label>Apellido:</label> <input type="text" name="apellido" class="form-control"/> 
                                <label>Dia:</label>      <input type="text" name="dia" class="form-control"/> 
                                <label>Mes:</label>      <input type="text" name="mes" class="form-control"/> 
                                <label>Año:</label>      <input type="text" name="anio" class="form-control"/> 
                                
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>                            
                                    <input type="submit" value="Guardar" class="btn btn-primary"/>
                                </div>
                            </form>
                        </div>
                    </div>                    
                </div>
            </div>

        </div>   
        <script src="js/jquery.js" type="text/javascript"></script>             
        <script src="js/bootstrap.min.js" type="text/javascript"></script>  
    </body>
</html>
