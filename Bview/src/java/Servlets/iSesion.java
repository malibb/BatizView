package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.*;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import security.*;

@WebServlet(name = "iSesion", urlPatterns = {"/iSesion"})

public class iSesion extends HttpServlet {

    //Clases de ayuda
    Querys qs = new Querys();
    validaciones vos = new validaciones();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Variables
        ArrayList datos = new ArrayList();
        ArrayList datosAux = new ArrayList();
        ArrayList bol = new ArrayList();
        ArrayList datosRe;

        boolean val = false;

        String url = "web/public/InicioSesion.jsp";

        //Datos y sentencia para iniciar sesion
        String[] datosU = {"id_per", "nom_per", "app_per", "apm_per", "Area_id_area", "id_cue", "tip_cue", "edo_cue", "pas_cue", "ema_cue", "Persona_id_per"};
        String queryU = "SELECT id_per, nom_per, app_per, apm_per, Area_id_area, id_cue, tip_cue, edo_cue, pas_cue, ema_cue, Persona_id_per FROM persona join cuenta WHERE id_per = Persona_id_per and ema_cue = ?";

        //Codificamos la entrada y la salida a UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Obtenemos Sesiones
        HttpSession ses = request.getSession();

        //Obtenemos Datos del Formulario
        datos.add(request.getParameter("email")); //9 posicion
        datos.add(request.getParameter("contra")); //8 posicion

        datosAux.add(request.getParameter("email"));

        tryit:
        try {
            //Comprobamos si estan vacios
            val = vacio(datos);

            if (val == true) {
                request.getSession().setAttribute("error1", "error");
                request.getSession().setAttribute("message", "Uno o mas datos estan vacios");
                url = "web/public/InicioSesion.jsp";
                break tryit;
            }

            //Validaciones
            bol.add(vos.isEmail(datos.get(0).toString()));
            bol.add(vos.isPassword(datos.get(1).toString()));

            val = (boolean) bol.get(0) && (boolean) bol.get(1);

            if (val == false) {
                request.getSession().setAttribute("error1", "error");
                request.getSession().setAttribute("message", "Uno o mas datos no son validos");
                url = "web/public/InicioSesion.jsp";
                break tryit;
            }
            //metodo set de mi variable sql
            qs.setSql(queryU);
            //preparo la sentencia con los datos de email
            qs.setStatement(datosAux);
            //obtengo resultados con los datos de la variable datosU
            datosRe = qs.getResult(datosU);

            if ((int) datosRe.get(6) != 1) {

                switch ((int) datosRe.get(6)) {
                    default:
                        url = "web/public/InicioSesion.jsp";
                        break tryit;
                    case 2:
                        url = "web/public/Desactivada.jsp";
                        break tryit;
                    case 3:
                        url = "web/Profesor/aRegistro.jsp";
                        break tryit;
                    case 4:
                        url = "web/Profesor/Desactivar.jsp";
                        break tryit;
                    case 5:
                        url = "web/public/Desactivada.jsp";
                        break tryit;
                    case 6:
                        url = "web/Alumno/Desactivada.jsp";
                        break tryit;

                }
            }

            //Igualo el email y la contraseña con los de la Base de Datos
            System.out.println(datosRe);
            if ((datos.get(0).toString()).equals(datosRe.get(9).toString()) && (datos.get(1).toString()).equals(datosRe.get(8).toString())) {

                switch (datosRe.get(5).toString()) {
                    case "0":
                        ses.setAttribute("Sesion", true);
                        ses.setAttribute("Datos", datosU);
                        url = "web/JefeDeArea/jefeAreaDefault.jsp";
                        break tryit;
                    case "1":
                        ses.setAttribute("Sesion", true);
                        ses.setAttribute("Datos", datosU);
                        url = "web/Profesor/profesorDefault.jsp";
                        break tryit;
                    case "2":
                        ses.setAttribute("Sesion", true);
                        ses.setAttribute("Datos", datosU);
                        url = "web/Alumno/alumnoDefault.jsp";
                        break tryit;
                    default:
                        request.getSession().setAttribute("error1", "error");
                        request.getSession().setAttribute("message", "Tu Email o Contraseña son incorrectos");
                        url = "web/public/InicioSesion.jsp";
                        break tryit;
                }
            } else {
                request.getSession().setAttribute("error1", "error");
                request.getSession().setAttribute("message", "Tu Email o Contraseña son incorrectos");
                url = "web/public/InicioSesion.jsp";
                break tryit;
            }
        } catch (NullPointerException | SQLException | IllegalStateException | IndexOutOfBoundsException e) {
            request.getSession().setAttribute("error1", "error");
            request.getSession().setAttribute("message", "OPss algo salio mal");
            url = "web/public/InicioSesion.jsp";
            break tryit;

        } finally {
            response.sendRedirect(url);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean vacio(ArrayList x) {

        boolean re = true;

        for (Object e : x) {

            re = vos.isEmpty(e.toString());

            if (re == true) {

                break;

            }
        }

        return re;
    }

}
