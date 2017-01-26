/*
 * A page can't be manipulated safely until the document is "ready." 
 * jQuery detects this state of readiness for you. Code included inside $( document ).ready() 
 * will only run once the page Document Object Model (DOM) is ready for JavaScript code to execute. 
 * */
$(document).ready(function() {

	$("#bth-inserisci").click(function() {
		
		function toDate(selector){
			
			var from = $(selector).val().split("-");
			return new Date(from[2], from[1]-1, from[0]).getTime();
			
		}
	
		var formattedDate = toDate("#new-bdate");
		var jsonDate = formattedDate;
//		var date = new Date("($('#new-bdate').val()").toJSON();
		
		var newCustomer = {};
		
		newCustomer["id"] = $("#new-id").val();
		newCustomer["name"] = $("#new-name").val();
		newCustomer["surname"] = $("#new-surname").val();
		
		//var birthDate = $('#new-bdate').val();
		//newCustomer["birthDate"] = new Date(birthDate).toJSON();
		
		newCustomer["birthDate"] = jsonDate;
		
		console.log("newCustomer", newCustomer);

		$.ajax({
			type: 'post',
		    contentType: "application/json",
		    url: "./saveCustomer",
		    data: JSON.stringify(newCustomer),
		    success: function (data) {
		        console.log(data);
		        alert("Nuovo utente " + newCustomer.name + " " + newCustomer.surname + " corretamente inserito a DB.");
		    },
		    error: function (xhr, status) {
		        console.log(status);
		        console.log(xhr.responseText); 
		        alert("Errore: utente non inserito correttamente.");
		    }
		    	  		      
		 });
	});
	
});