<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>

        <meta charset="UTF-8">
        <title>Registro</title>

        <link rel="stylesheet" href="../../css/Style.css">
        <link rel="stylesheet" href="../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../css/normalize.css">

    </head>
    <body id="Ar" >
        <script type="text/javascript">
            window.onload = function () {

            <%
                String error = " ";
                String men = " ";
                String name = " ";
                String where = " ";


            %>
            };

        </script>


        <%            error = (String) session.getAttribute("error");
            if (error == null) {
                error = "nonerror";
            }
            men = (String) session.getAttribute("message");
            try {
                where = (String) session.getAttribute("Type");
            } catch (NullPointerException e) {
                where = " ";
            }
        %>
        <section class="full-heightS">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 spacing">
                        <h1 class="center textcinco"><a href="../index.html">BatizView</a></h1>
                        <h2 class="center">Empieza ahora</h2>
                        <div class="spacingmini">
                            <p class="sig">¿Eres Alumno? <a href="../Alumno/registroA.jsp">Ingresa Aqui</a></p>
                            <p class="sig">¿Ya tienes cuenta en BatizView? <a href="../public/InicioSesion.jsp">Ingresa aqui</a></p>
                        </div>
                        <p class="<%=error%>"><%=men%></p>

                        <form class="signupP" action="../../rProfesor" method="post">
                            <fieldset class="fs">
                                <div class=" ">
                                    <div class="field-wrapper">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" name="nombre" id="nombre" autocomplete="off" class="" required>
                                        <div class="field-help below21">¿Tienes nombre?</div>
                                    </div>
                                </div>
                                <div class=" ">
                                    <div class="field-wrapper">
                                        <label for="apellidop">Apellido Paterno</label>
                                        <input type="text" name="apellidop" id="apellidop" autocomplete="off" required>
                                        <div class="field-help below21">¿Qué nos dices de tu Apellido Paterno?</div>
                                    </div>
                                </div>
                                <div class=" ">
                                    <div class="field-wrapper">
                                        <label for="apellidom">Apellido Materno</label>
                                        <input type="text" name="apellidom" id="apellidom" autocomplete="off" required>
                                        <div class="field-help below21">¿Y de tu Apellido Materno?</div>
                                    </div>
                                </div>
                                <div class=" ">
                                    <div class="field-wrapper">
                                        <label for="identificador">Numero de Trabajador</label>
                                        <input type="number" name="identificador" id="identificador" autocomplete="off" required>
                                        <div class="field-help below21">Tu numero de trabajador dentro del Cecyt 9</div>
                                    </div>
                                </div>
                                <div class=" ">
                                    <div class="field-wrapper">
                                        <label for="carrera">Carrera</label>
                                        <select name="carrera" id="carrera">
                                            <option value="1">Tronco Comun</option>
                                            <option value="2">Programacion</option>
                                            <option value="3">Sistemas Digitales</option>
                                            <option value="4">Maquinas con Sistemas Automatizados</option>
                                        </select>
                                        <div class="field-help below21">Selecciona tu carrera</div>
                                    </div>
                                </div>
                                <div class=" ">
                                    <div class="field-wrapper">
                                        <label for="email">Email</label>
                                        <input type="email" name="email" id="email" autocomplete="off" required>
                                        <div class="field-help below21">Tu email</div>
                                    </div>
                                </div>
                                <div class="">
                                    <div class="field-wrapper">
                                        <label for="contra">Contraseña</label>
                                        <input type="password" id="contra" name="contra"  autocomplete="off" required>
                                        <div class=" spacingmini2">
                                            <div class="col-md-6 below21">
                                                <ul class="password-list">
                                                    <li>Una Minuscula</li>
                                                    <li>Una Mayuscula</li>
                                                    <li>Un Numero</li>
                                                </ul>
                                            </div>
                                            <div class="col-md-6 below21">
                                                <ul class="password-list">
                                                    <li>Un Caracter Especial</li>
                                                    <li>8 Caracteres minumo</li>
                                                    <li>No relacionado con tu nombre</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" id="create" value="Crear mi cuenta" class="button">Crear mi cuenta</button>
                            </fieldset>
                        </form>
                        <p class="sig">Haciendo click en este boton, aceptas nuestra <br> <a href="">Politica de Privacidad</a> y <a href="">Terminos de Uso</a>.</p>
                    </div>
                </div>
            </div>
        </section>   
        <script>

            document.getElementById("<%=where%>").className = "isError";
            document.getElementById("<%=where%>").setAttribute("autofocus", "autofocus");
        </script>
    </body>
</html>
