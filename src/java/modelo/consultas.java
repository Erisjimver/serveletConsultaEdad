package modelo;

import controlador.SettersAndGetters;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class consultas {

    static Statement s;
    static ResultSet rs;
    static conexion cn=new conexion(); 
    Connection c= cn.conexion();
    static SettersAndGetters sg = new SettersAndGetters();
          

       public static ArrayList<SettersAndGetters> MostrarPersona(){
        ArrayList<SettersAndGetters> lista = new ArrayList();
             try
                {
                    rs = cn.consultar("select * from persona");  

                    while (rs.next())
                    {
                        sg = new SettersAndGetters(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                        lista.add(sg);
                    }
                    rs.close();
                    cn.cerrarconexion();
                }
                catch (SQLException e){}
                return lista;
        }

       public String acceso(String usuario){
           String datos="";
       try
       {
            rs = cn.consultar("select * from persona where cedula='"+usuario+"'");  
            while(rs.next()){ 

                    System.out.println(rs.next());
                    datos=rs.getString(1);
                
            } 
       }
       catch(SQLException e)
       {
           System.out.println("Error: "+e);
       }
       return datos;
    }

    public  boolean eliminarUsuario(SettersAndGetters to){
        boolean resp = false;

        
        try{
            CallableStatement cs = c.prepareCall("delete from persona where cedula ?");
            cs.setString(1, to.getCedula());
            int i = cs.executeUpdate();
            System.out.println(""+to.getCedula());
            if(i==1)
                resp = true;
            else
                resp = false;
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        return resp;
    }

    public  boolean eliminarUsuario(){
        boolean resp = false;

        String cedul="numero de cedula a borrar";
        try{
        s = c.createStatement();
        rs = s.executeQuery("delete from persona where cedula='"+cedul+"'");
        if(rs.next()){
            System.out.println(""+rs.getString(1));
        }

            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        return resp;
    }
}
