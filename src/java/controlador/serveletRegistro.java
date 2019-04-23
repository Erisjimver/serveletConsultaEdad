package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.registro;

/**
 *
 * @author Israel
 */
public class serveletRegistro extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        //llamando clases
        verFecha f=new verFecha();
        cEdad v=new cEdad();
        SettersAndGetters sg=new SettersAndGetters();
        registro r=new registro();
        
        //datos enviados por texto
        String ce = request.getParameter("cedula");
        String no = request.getParameter("nombre");
        String ap = request.getParameter("apellido");
        String DN = request.getParameter("dia");
        String MN = request.getParameter("mes");
        String AN = request.getParameter("anio");
        
        //calcular edad
        String edad = v.CalcularEdad(DN, MN, AN);
        String fa= f.fechaActual();
        
        //enviar datos para su registro       
        try{
        sg.setCedula(ce);
        sg.setNombre(no);
        sg.setApellido(ap);
        sg.setFechaactual(fa);
        sg.setEdad(edad);
        r.registrarPersona(sg);
        PrintWriter out=response.getWriter();
        out.println("registro exitoso.");
        }
        catch(SQLException e){System.out.println("Error al registrar"+e);
        PrintWriter out=response.getWriter();
        out.println("Error, error en el registro.");
        }
        
       // response.sendRedirect("index.jsp");
            try (PrintWriter out = response.getWriter()) {
      //muestra en un servelet el resultado
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registrado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h5>A la fecha de: " + fa + "</h5>");
            out.println("<h5>Tiene una edad de: " + edad + "</h5>");
            out.println("</body>");
            out.println("</html>");
        }        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(serveletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(serveletRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
