package controlador;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class verFecha {
    
    String fecha;
 Calendar C = Calendar.getInstance();
 //Ver el día actual
 public int VerDia(){
     return (C.get(Calendar.DATE));
 }
 //Ver el mes actual
  public int VerMes(){
     return (C.get(Calendar.MONTH)+1);
 }
//Ver el año actual
     public int VerAnio(){
     return (C.get(Calendar.YEAR));
 }
   
    //Obtener fecha      
    public String fechaActual()
    { 
        java.util.Date Fecha=new java.util.Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
        fecha=formatoFecha.format(Fecha);
        return fecha;   
    } 
}
