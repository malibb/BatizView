package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import security.*;

public class aHorarios extends HttpServlet {
    
    validaciones ves = new validaciones();

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Variables
        ArrayList datos = new ArrayList();
        ArrayList val = new ArrayList();
        
        String url = "web/Alumno/registroA.jsp";
        
        datos.add(request.getParameter("Dia"));
        datos.add(request.getParameter("HoraI"));
        datos.add(request.getParameter("HoraF"));
        datos.add(request.getParameter("Materia"));
        datos.add(request.getParameter("Salon"));
        
        val.add(ves.isEmpty(datos.get(0).toString()));
        val.add(ves.isEmpty(datos.get(1).toString()));
        val.add(ves.isEmpty(datos.get(2).toString()));
        val.add(ves.isEmpty(datos.get(3).toString()));
        val.add(ves.isEmpty(datos.get(4).toString()));
        
        val.add(ves.isOption(datos.get(0).toString()));
        val.add(ves.isHour((int) datos.get(1)));
        val.add(ves.isHour((int) datos.get(2)));
        val.add(ves.isString(datos.get(3).toString()));
        val.add(ves.isOption(datos.get(4).toString()));
        
        Horarios: try{
            
            if(error(val)==false){
                url = "web/Alumno/registroA.jsp";
                break Horarios;
            }
            
            
        
        }
        catch(Exception e){
        
        }
        finally{
            
            response.sendRedirect(url);
            
        }
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
        public boolean error(ArrayList array) {
        boolean re = false;
            
        For: for (Object e : array) {
            if ((boolean) e != true) {
                re = false;
                break For;
            }

        }

       return re;
    }

}
