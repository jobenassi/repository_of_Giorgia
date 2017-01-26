<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
 
  <title>Nuovo Cliente</title>
  <link rel="stylesheet" href="<c:url value='/static/css/main.css' />">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="<c:url value='/static/js/newCustomerCntrl.js' />"></script> 

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
					<input type=text class="new-input" id="new-id" placeholder="ID">
				</div>
			</div>
			<div>
				 
				<div>
					<input type=text class="new-input" id="new-name" placeholder="NOME">
				</div>
			</div>
			<div>
				
				<div>
					<input type="text" class="new-input" id="new-surname" placeholder="COGNOME">
				</div>
			</div>
			<div>
				
				<div>
					<input type="date" class="new-input" id="new-bdate" placeholder="DATA DI NASCITA (aaaa-mm-gg)">
				</div>
			</div>

			<div>
				<div>
					<button type="submit" class="bth-home" id="bth-inserisci">INSERISCI</button>
				</div>
			</div>
		</div>

</body>
</html>