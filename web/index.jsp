<%-- 
    Document   : index
    Created on : 17-ago-2018, 19:58:57
    Author     : Israel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        
            <center><h1><strong>Aplicacion web para el calculo de la edad</strong></h1></center>
            <center><h4><strong>Ingrese su fecha de nacimiento en formato (DD/MM/AAA)</strong></h4></center>
            <br>
    <form action="serveletRegistro" method="post">  
    <table align="center" style="width: 28%; height: 127px">
        <tr>
		<td style="width: 160px">Cedula: </td>
		<td><input type="text" id="Name" name="cedula"/></td>
        </tr>
        <tr>
		<td style="width: 160px">Nombre: </td>
		<td><input type="text" id="Name" name="nombre"/></td>
        </tr> 
        <tr>
		<td style="width: 160px">Apellido: </td>
		<td><input type="text" id="Name" name="apellido"/></td>
        </tr> 
        <tr>
		<td style="width: 160px">Dia</td>
		<td><input type="text" id="Name" name="dia"/></td>
        </tr>
	<tr>
		<td style="width: 160px">Mes</td>
		<td><input type="text" id="Name" name="mes"/></td>
	</tr>
	<tr>
		<td style="width: 160px">Año</td>
		<td><input type="text" id="Name" name="anio"/></td>
	</tr>
    </table>
                <br>
                <center><label for="male">................................................</label>  </center>
                <br>
                <center><input type="submit" value="ENVIAR">  <input type="reset" value="LIMPIAR"> <input type="button" onclick="location='buscar.jsp'" value="BUSCAR" name="buscar">  </center>
    </form>
    </body>
</html>
