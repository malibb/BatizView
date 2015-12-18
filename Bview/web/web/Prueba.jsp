<%-- 
    Document   : Prueba
    Created on : 05-dic-2015, 20:00:49
    Author     : Samael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page language="java" import="java.sql.*;" %>
<%@ page language="java" import="javax.servlet.*;"%>
<%@ page language="java" import="javax.servlet.http.*;"%>
<%@ page language="java" import="java.io.*;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
    <head>
        <title>Horarios Shidos</title>

        
    </head>
    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/batizviewdb"
     user="root"  password="n0m3l0"/>
        
        <sql:query dataSource="${snapshot}" var="result">
            SELECT DISTINCT dia_cdp, clas_hop, ini_hop, fin_hop, aul_hop, nom_per FROM CDiaP, DiaP, HoraP, CHorarioP, Cuenta, Persona where CDia_id_cdi=id_cdp and HoraP_id_hop=id_hop and CHorarioP_id_chp=id_chp and Cuenta_id_cue=id_cue and Persona_id_per=id_per ORDER BY dia_cdp, ini_hop;
        </sql:query>

        <table border="1" width="100%">
            <tr>
                <th>Dia</th>
                <th>Clase</th>
                <th>Hora</th>
                <th>Aula</th>
                <th>Profesor</th>
            </tr>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.dia_cdp}"/></td>
                    <td><c:out value="${row.clas_hop}"/></td>
                    <td><c:out value="${row.ini_hop}"/> - <c:out value="${row.fin_hop}"/></td>
                    <td><c:out value="${row.aul_hop}"/></td>
                    <td><c:out value="${row.nom_per}"/></td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
