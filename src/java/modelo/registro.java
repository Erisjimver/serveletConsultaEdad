package modelo;

import controlador.SettersAndGetters;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class registro {
static Statement s;
static ResultSet rs;
private static PreparedStatement ps;
private static CallableStatement cs;
conexion cn=new conexion(); 
Connection c= cn.conexion();


//metodo registrar persona
    public void registrarPersona(SettersAndGetters to) throws Exception{
 
        String sql="insert into persona(cedula,nombre,apellido,fechaa,edad) values(?,?,?,?,?)";
        ps =c.prepareStatement(sql);
        ps.setString(1, to.getCedula());
        ps.setString(2, to.getNombre());
        ps.setString(3, to.getApellido());   
        ps.setString(4, to.getFechaactual()); 
        ps.setString(5, to.getEdad());
        ps.execute();
    }
    
}
