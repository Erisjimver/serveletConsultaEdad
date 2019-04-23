package controlador;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class cEdad {
    
    String edad="";

    
    public String CalcularEdad(String d,String m, String a){
       
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(""+d+"/"+m+"/"+a+"", fmt);       
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        
        //System.out.printf("Tu edad es: %s años, %s meses y %s días",periodo.getYears(), periodo.getMonths(), periodo.getDays());   
        edad=""+periodo.getYears()+" años, "+periodo.getMonths()+" meses, "+periodo.getDays()+" dias";
        return edad;
   }
       
    
}
