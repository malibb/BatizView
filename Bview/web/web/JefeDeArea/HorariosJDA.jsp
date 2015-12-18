<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Horarios</title>

        <link rel="stylesheet" href="../../css/normalize.css">
        <link rel="stylesheet" href="../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../css/Style.css">

    </head>

    <body id="Horarios">
        <main>
            <header id="HR">
                <nav>
                    <div class="container">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">
                                <p id="logo" class="">BatizView</p>
                            </a>
                        </div>

                        <div class="navbar-right">
                            <ul class="nav navbar-nav navbar-left">
                                <li class="nav-item"><a href="">Solicitudes</a></li>
                                <li class="nav-item"><a href="">Horarios</a></li>
                                <li class="nav-item">
                                    <a href="">
                                        Nombre
                                    </a>
                                </li>
                                <li class="nav-item"><a href="">Empieza Ya</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div class="container blurb">
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <h1>Horarios</h1>
                        </div>
                        <div class="col-md-8 col-md-offset-2">
                            <ul>
                                <li>Profesores: </li>
                                <li> | </li>
                                <li>Salones: </li>
                                <li> | </li>
                                <li>Materias: </li>
                                <li> | </li>
                                <li>Area: </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </header>
            <article>
                <section id="BodyFull" class="container BodyFull cont">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <p class="center">Bienvenido al sistema de administracion de horarios, como Jefe de Area desde aqui podras modificar, agregar y eliminar los horarios de los profesores pertenecientes a tu area</p>
                        </div>
                    </div>
                </section>
                <section id="Search" class="container Search cont">
                    <div class="row">
                        <div class="col-md-12">
                            <form action="">
                                <fieldset>
                                    <div class="col-md-8">
                                        <div class="field-wrapper">

                                            <input type="Text" name="buscar" id="buscar" autocomplete="off" class="" placeholder="Buscar Profesor" required>
                                            <div class="field-help">Nombre o numero de trabajador del Profesor</div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <button type="submit" id="Sch" value="Buscar" class="button">Buscar</button>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </section>
                <section id="manage" class="container Plus cont">
                    <div class="row">
                        <div class="col-md-5 Vdivider">
                            <h3 class="center below42">Profesor</h3>
                            <table class="table table-hover">
                                <tr>
                                    <td>Numero de Empleado:</td>
                                    <td>..</td>
                                </tr>

                                <tr>
                                    <td>Nombre de Profesor:</td>
                                    <td>..</td>
                                </tr>

                                <tr>
                                    <td>Horas Base:</td>
                                    <td>..</td>
                                </tr>

                                <tr>
                                    <td>Horas Asignadas:</td>
                                    <td>..</td>
                                </tr>

                                <tr>
                                    <td>Materias Asignadas:</td>
                                    <td>..</td>
                                </tr>
                            </table>
                        </div>
                        <div class="col-md-7">
                            <h3 class="center below42">Agregar Hora</h3>
                            <div class="col-md-12">

                                <div class="field-wrapper">

                                    <select name="Dia" id="Dia">
                                        <option selected disabled>Dia</option>
                                        <option value="1">Lunes</option>
                                        <option value="2">Martes</option>
                                        <option value="3">Miercoles</option>
                                        <option value="4">Jueves</option>
                                        <option value="5">Viernes</option>
                                    </select>
                                    <div class="field-help below21">Dia que se impartira la clase</div>


                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="field-wrapper">

                                    <input type="number" name="HoraI" id="HoraI" autocomplete="off" class="" placeholder="Hora de inicio" required>
                                    <div class="field-help below21">A que hora inicia la clase?</div>

                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="field-wrapper">

                                    <input type="number" name="HoraF" id="HoraF" autocomplete="off" class="" placeholder="Hora de termino" required>
                                    <div class="field-help below21">A que hora termina la clase?</div>

                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="field-wrapper">

                                    <input type="text" name="Materia" id="Materia" autocomplete="off" class="" placeholder="Materia" required>
                                    <div class="field-help below21">Materia a impartir</div>

                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="field-wrapper">

                                    <select name="Salon" id="Salon">
                                        <option selected disabled>Salon</option>
                                        <option value="1">Desarrollo de Software</option>
                                        <option value="2">Nuevas Tecnologias</option>
                                        <option value="3">Base de Datos</option>
                                    </select>
                                    <div class="field-help below21">Salon donde se impartira la clase</div>


                                </div>
                            </div>

                        </div>
                </section>
                <section id="schedule" class="container schedule cont">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-hover">
                                <tr>
                                    <td>     </td>
                                    <td>7 - 8</td>
                                    <td>8 - 9</td>
                                    <td>9 - 10</td>
                                    <td>10 - 11</td>
                                    <td>11 - 12</td>
                                    <td>12 - 13</td>
                                    <td>13 - 14</td>
                                    <td>14 - 15</td>
                                    <td>15 - 16</td>
                                    <td>16 - 17</td>
                                    <td>17 - 18</td>
                                    <td>18 - 19</td>
                                    <td>19 - 20</td>
                                    <td>20 - 21</td>
                                </tr>
                                <tr>
                                    <td>Lunes</td>
                                </tr>
                                <tr>
                                    <td>Martes</td>
                                </tr>
                                <tr>
                                    <td>Miercoles</td>

                                </tr>
                                <tr>
                                    <td>Jueves</td>								
                                </tr>
                                <tr>
                                    <td>Viernes</td>								
                                </tr>
                            </table>
                        </div>
                    </div>
                </section>
            </article>
        </main>
    </body>

</html>
