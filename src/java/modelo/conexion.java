package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


    public class conexion {   
    private static  Connection connection = null;
    static Statement s;
    static ResultSet rs; 
    Connection conexion=null;
    
    
    public Connection conexion(){
    
        try
        { 
            Class.forName("org.postgresql.Driver");    
            String BaseDeDatos = "jdbc:postgresql://192.168.101.47:5433/calcularedad";
            //String BaseDeDatos = "jdbc:postgresql://localhost:5433/postgres"; 
            //String BaseDeDatos = "jdbc:postgresql://localhost "direcion ip" :5432/"Nombre de base de datos"";
            conexion=DriverManager.getConnection(BaseDeDatos,"postgres","59291");
            
            if (conexion != null)
            {
                System.out.println("Conectando a Base de Datos...");
            }
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println("Problemas de Conexión");
        }

        return conexion;    
}
     
    public ResultSet consultar(String sql) { 
        try { 
            s = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = s.executeQuery(sql); 
             
        } catch (SQLException e) { 
            return null; 
        } 
        return rs; 
    }
    
    public void cerrarconexion() throws SQLException {       
            conexion.close();       
    }
}
