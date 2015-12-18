package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import controller.*;
import security.*;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class rProfesor extends HttpServlet {

    //Clases de ayuda
    Querys qs = new Querys();
    validaciones vos = new validaciones();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Obtenemos Sesiones
        HttpSession ses = request.getSession();

        //Variables
        ArrayList datosU = new ArrayList();
        ArrayList datosUQ = new ArrayList();
        ArrayList datosRe = new ArrayList();
        ArrayList bool = new ArrayList();
        ArrayList ue = new ArrayList();

        boolean val;
        int numError = -1;
        String name = "";
        String[] id = {"id_per"};

        String url = "web/Profesor/registroP.jsp";

        //4 Querys SQL
        String[] querys = {"SELECT id_cue FROM cuenta WHERE id_cue = ?;", "SELECT ema_cue FROM cuenta WHERE ema_cue = ?;", "INSERT INTO persona(nom_per, app_per, apm_per ,Area_id_area) VALUES(?,?,?,?);", "SELECT id_per FROM persona WHERE nom_per = ? and app_per = ? and apm_per = ? and Area_id_area = ?;"};

        //Obtenemos datos de formulario para primera Query
        datosU.add(request.getParameter("nombre"));
        datosU.add(request.getParameter("apellidop"));
        datosU.add(request.getParameter("apellidom"));
        datosU.add(request.getParameter("carrera"));

        //Datos para segunda Query
        datosUQ.add(request.getParameter("identificador"));
        datosUQ.add(request.getParameter("contra"));
        datosUQ.add(request.getParameter("email"));

        tryit:
        try {

            //Validaciones si esta vacio
            val = vacio(datosU) && vacio(datosUQ);
            if (val == true) {
                request.getSession().setAttribute("error", "error");
                request.getSession().setAttribute("message", "Al parecer uno o mas datos estan vacios");
                url = "web/Profesor/registroP.jsp";
                break tryit;
            }

            //Validaciones respectivas
            bool.add(vos.isString(datosU.get(0).toString()));
            bool.add(vos.isString(datosU.get(1).toString()));
            bool.add(vos.isString(datosU.get(2).toString()));
            bool.add(vos.isOption(datosU.get(3).toString()));
            bool.add(vos.isNumericN(datosUQ.get(0).toString(), "6"));
            bool.add(vos.isPassword(datosUQ.get(1).toString(), datosU.get(0).toString()));
            bool.add(vos.isEmail(datosUQ.get(2).toString()));

            val = (boolean) bool.get(0) && (boolean) bool.get(1) && (boolean) bool.get(2) && (boolean) bool.get(3) && (boolean) bool.get(4) && (boolean) bool.get(5) && (boolean) bool.get(6);

            if (val == false) {

                request.getSession().setAttribute("error", "error");
                request.getSession().setAttribute("message", "Al parecer uno o mas datos son erroneos");
                url = "web/Profesor/registroP.jsp";
                break tryit;

            }

            //Detectar el campo que esta mal
            numError = error(bool);
            if (numError > -1) {

                switch (numError) {
                    case 0:
                        name = "nombre";
                        request.getSession().setAttribute("error", "error");
                        request.getSession().setAttribute("Type", name);
                        request.getSession().setAttribute("message", "Algunos datos son invalidos");
                        url = "web/Profesor/registroP.jsp";
                        break tryit;
                    case 1:
                        name = "apellidop";
                        request.getSession().setAttribute("error", "error");
                        request.getSession().setAttribute("Type", name);
                        request.getSession().setAttribute("message", "Algunos datos son invalidos");
                        url = "web/Profesor/registroP.jsp";
                        break tryit;
                    case 2:
                        name = "apellidom";
                        request.getSession().setAttribute("error", "error");
                        request.getSession().setAttribute("Type", name);
                        request.getSession().setAttribute("message", "Algunos datos son invalidos");
                        url = "web/Profesor/registroP.jsp";
                        break tryit;

                    case 3:
                        name = "carrera";
                        request.getSession().setAttribute("error", "error");
                        request.getSession().setAttribute("Type", name);
                        request.getSession().setAttribute("message", "Algunos datos son invalidos");
                        url = "web/Profesor/registroP.jsp";
                        break tryit;

                    case 4:
                        name = "identificador";
                        request.getSession().setAttribute("error", "error");
                        request.getSession().setAttribute("Type", name);
                        request.getSession().setAttribute("message", "Algunos datos son invalidos");
                        url = "web/Profesor/registroP.jsp";
                        break tryit;

                    case 5:
                        name = "contra";
                        request.getSession().setAttribute("error", "error");
                        request.getSession().setAttribute("Type", name);
                        request.getSession().setAttribute("message", "Algunos datos son invalidos");
                        url = "web/Profesor/registroP.jsp";
                        break tryit;

                    case 6:
                        name = "email";
                        request.getSession().setAttribute("error", "error");
                        request.getSession().setAttribute("Type", name);
                        request.getSession().setAttribute("message", "Algunos datos son invalidos");
                        url = "web/Profesor/registroP.jsp";
                        break tryit;
                    default:
                        request.getSession().setAttribute("error", "error");
                        request.getSession().setAttribute("Type", name);
                        request.getSession().setAttribute("message", "Algunos datos son invalidos");
                        url = "web/Profesor/registroP.jsp";
                        break tryit;
                }
            }

            //Validacion de Email y Cuenta
            bool.clear();
            String[] z = {"id_cue"};
            ue.add(request.getParameter("identificador"));
            bool.add(validacion(querys[0], ue, z));

            String[] w = {"ema_cue"};
            ue.clear();
            ue.add(request.getParameter("email"));
            bool.add(validacion(querys[1], ue, w));

            if ((boolean) bool.get(0) == false && (boolean) bool.get(1) == false) {
                request.getSession().setAttribute("error", "error");
                request.getSession().setAttribute("message", "Tu Boleta e Email estan asociados a otra cuenta");
                url = "web/Profesor/registroP.jsp";
                break tryit;
            } else if ((boolean) bool.get(0) == false) {
                request.getSession().setAttribute("error", "error");
                request.getSession().setAttribute("message", "Tu Boleta esta asociada a otra cuenta");
                url = "web/Profesor/registroP.jsp";
                break tryit;
            } else if ((boolean) bool.get(1) == false) {
                request.getSession().setAttribute("error", "error");
                request.getSession().setAttribute("message", "Tu Email esta asociado a otra cuenta");
                url = "web/Profesor/registroP.jsp";
                break tryit;
            }

            //Insert en persona
            qs.setSql(querys[2]);
            qs.setStatement(datosU);
            qs.executePST();

            //Extraer Id
            qs.setSql(querys[3]);
            qs.setStatement(datosU);
            datosRe = (ArrayList) qs.getResult(id).clone();

            if (datosRe.isEmpty()) {
                request.getSession().setAttribute("error", "error");
                request.getSession().setAttribute("message", "OPSS Algo salio mal");
                url = "web/Profesor/registroP.jsp";
                break tryit;
            }

            qs.setSql("INSERT INTO cuenta(id_cue, tip_cue, edo_cue, pas_cue, ema_cue, Persona_id_per) values(?,1,2,?,?," + datosRe.get(0) + ");");
            qs.setStatement(datosUQ);
            qs.executePST();

            url = "web/public/InicioSesion.jsp";

        } catch (Exception e) {

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

    public int error(ArrayList array) {
        int x = -1;

        for (Object e : array) {
            if ((boolean) e != true) {
                x = array.indexOf(e);

                break;
            }

        }

        return x;
    }

    public boolean validacion(String query, ArrayList vo, String[] valores) throws SQLException {

        boolean re = true;

        ArrayList y = new ArrayList();
        y.clear();

        qs.setSql(query);
        qs.setStatement(vo);
        return qs.getResult(valores).isEmpty();

    }

}
