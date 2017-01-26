<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
 
  
  <link rel="stylesheet" href="<c:url value='/static/css/main.css' />">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="<c:url value='/static/js/customerCntrl.js' />"></script> 

</head>

<body>
<div id="header" class="crop">
				<form method="get" action="./">
    				<button type="submit" id="home" ></button>
				</form>
</div>

<div id="search-form">
			<div>
				 
				<div>
					<input type=text id="name" placeholder="Nome">
				</div>
			</div>
			<div>
				
				<div>
					<input type="text" id="surname" placeholder="Cognome">
				</div>
			</div>

			<div>
				<div>
					<button type="submit" id="bth-search">Cerca</button>
				</div>
			</div>
		</div>

	<table id="table" class="hidden">
		<thead>
			<tr>
				<th>Numero conto</th>
				<th>Descrizione</th>
				<th>Saldo</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>


</body>
</html>