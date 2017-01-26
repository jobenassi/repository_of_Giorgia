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
				<form method="get" action="./newCustomer">
    				<button type="submit" class="bth-home" >CREA NUOVO CLIENTE</button>
				</form> 
				</div>
			</div>
			<div>
				<form method="get" action="./manageCustomer">
					<button type="submit" class="bth-home">MODIFICA/ELIMINA CLIENTE</button>
					</form>
			</div>
			<div>
				<div>
			 	<form method="get" action="./index">
					<button type="submit" class="bth-home">TROVA CONTI PER CLIENTE</button>
				</form>
				</div>
			</div>
			<div>
				<div>
				<form method="get" action="./manageAccount">
					<button type="submit" class="bth-home" >AGGIUNGI/RIMUOVI CONTO</button>
				</form>
				</div>
			</div>
			<div>

			</div>
</div>


</body>
</html>