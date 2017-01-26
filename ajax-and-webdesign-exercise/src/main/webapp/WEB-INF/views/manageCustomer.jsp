<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

			<!doctype html>
			<html lang="en">

			<head>

				<title>Modifica/Elimina Cliente</title>
				<link rel="stylesheet" href="<c:url value='/static/css/main.css' />">
				<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
				<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
				<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
				<script src="<c:url value='/static/js/manageCustomerCntrl.js' />"></script>

			</head>

			<body>

				<div id="dialog-confirm" title="Conferma Eliminazione Cliente">
					<p>Il cliente <span id="del-name"> </span><span id="del-surname"> sarà eliminato in modo permanente.</span></p>
					
				</div>
				
				<div id="dialog-form" title="Modifica Anagrafica Cliente">

					<form>
						<label>Codice Cliente</label>
						<input type="text" id="cng-id" class="input" disabled>
						<label>Nome</label>
						<input type="text" id="cng-name" class="input">
						<label>Cognome</label>
						<input type="text" id="cng-surname" class="input">
						<label>Data di nascita</label>
						<input type="text" id="cng-birthDate" class="input">

						<!-- Allow form submission with keyboard without duplicating the dialog button -->
						<input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
					</form>
				</div>

				<div id="header" class="crop">
					<form method="get" action="./">
						<button type="submit" id="home"></button>
					</form>
				</div>
				<div id="search-form">
				<form>

							<input type=text id="id" placeholder="id">

							<input type=text id="name" placeholder="Nome">

							<input type="text" id="surname" placeholder="Cognome">
				</form>
				<button type="submit" class="bth-home" id="bth-searchCustomer">Ricerca Cliente</button>
				</div>
				
				<table id="table" class="hidden">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Data di nascita</th>
							<th class="manage"></th>
							<th class="manage"></th>
							<th class="manage"></th>


						</tr>
					</thead>
					<tbody></tbody>
				</table>

			</body>

			</html>