<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<html lang="es" id="In">

	<head>
		<meta charset="UTF-8">
		<title>Inicio de Sesion</title>
		<link rel="stylesheet" href="../../css/Style.css">
		<link rel="stylesheet" href="../../css/bootstrap.min.css">
		<link rel="stylesheet" href="../../css/normalize.css">
		<script type="text/javascript">
			window.onload = function() {




				<%
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                if (!session.isNew()) {
                    session.invalidate();
                    session = request.getSession();
                }
                
                String error = " ";
                String men = " ";
                String name = " ";
                String where = " ";


            %>
			};

		</script>

	</head>

	<body>
		<%  
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            error = (String) session.getAttribute("error1");
            if (error == null) {
                error = "nonerror";
            }
            men = (String) session.getAttribute("message");
        %>
			<section class="main">
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-md-offset-2">
							<h1 class="center textcinco"><a href="../index.html" >BatizView</a></h1>
							<h2 class="center below42">Inicia Sesion!</h2>
							<p class="<%=error%>">
								<%=men%>
									<p>
						</div>
						<div class="col-md-4">
							<form action="../../iSesion" method="post">
								<fieldset class="fs">
									<div>
										<div class="field-wrapper">
											<label for="nombre">Email</label>
											<input type="text" name="email" id="email" autocomplete="off" class="" required>
											<div class="field-help below21">Tu Email Pls!</div>
										</div>
									</div>
									<div>
										<div class="field-wrapper">
											<label for="nombre">Contraseña</label>
											<input type="Password" name="contra" id="contra" autocomplete="off" class="" required>
											<div class="field-help below21">Tu Contraseña aqui!</div>
										</div>
									</div>
									<button type="submit" id="login" value="Inicia" class="button">Inicia</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</section>
	</body>

	</html>
