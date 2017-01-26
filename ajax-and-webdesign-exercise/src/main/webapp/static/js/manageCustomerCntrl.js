/*
 * A page can't be manipulated safely until the document is "ready." 
 * jQuery detects this state of readiness for you. Code included inside $( document ).ready() 
 * will only run once the page Document Object Model (DOM) is ready for JavaScript code to execute. 
 * */
$(document).ready(function() {
	
	var dialog, 
		dialogConfirm,
		form,
		thisCustomer,
		id = $("#cng-id"),
		name = $("#cng-name"),
		surname = $("#cng-surname"),
		cngCustomer = {},
		//    birthDate$("#cng-birthDate"),
		//	  cngCustomer = $( [] ).add( id ).add( name ).add( surname ),
		tips = $(".validateTips");
	
	function emptyTable(){
		
//		$("#table > tbody").innerHTML = "<tr>"+
//						"<td></td><td></td><td></td><td></td>" +
//						"<td class='acc-bth'></td><td class='acc-bth'></td><td class='acc-bth'></td>" +
//						"</tr>";";
		$('#table tbody').innerHTML="";
		console.log("tabella svuotata");
	}
	

	function deleteCustomer(id) {
		
		$.ajax({
			type: 'post',
			contentType: "application/json",
			url: "./deleteCustomer",
			data: JSON.stringify(id),
			success: function(data) {
				console.log(data);
				emptyTable(table);

				
			},
			error: function(xhr, status) {
				console.log(status);
				console.log(xhr.responseText);
			}
		});
	}

	function updateCustomer() {
		
		console.log("entra in updateCustomer");
		cngCustomer["id"] = $("#cng-id").val();
		cngCustomer["name"] = $("#cng-name").val();
		cngCustomer["surname"] = $("#cng-surname").val();
		console.log("cng - CUSTOMER", cngCustomer);
		$.ajax({
			type: 'post',
			contentType: "application/json",
			url: "./saveCustomer",
			data: JSON.stringify(cngCustomer),
			success: function(data) {
				console.log(data);
				alert("utente correttamente inserito a DB");
			},
			error: function(xhr, status) {
				console.log(status);
				console.log(xhr.responseText);
				alert("Errore durante la Modifica. Utente non modificato");
			}
		});
	}
	
	dialog = $("#dialog-form").dialog({
		
		autoOpen: false,
		width: 500,
		modal: true,
		open: function(e, ui) {
			$("#cng-id").val(thisCustomer.id);
			$("#cng-name").val(thisCustomer.name);
			$("#cng-surname").val(thisCustomer.surname);
			$("#cng-birthDate").val(thisCustomer.birthDate);
		},
		buttons: [{
				text: "Modifica",
				click: function() {
					alert("Stai per modificare il cliente");
					updateCustomer();
					dialog.dialog("close");
				}
			},
			{
				text: "chiudi",
				click: function() {
					dialog.dialog("close");
				}
			}
		],
		close: function() {
			form[0].reset();
		}
	});
	
	dialogConfirm = $("#dialog-confirm").dialog({
		
		resizable: false,
		autoOpen: false,
		width: 400,
		modal: true,
		open: function(e, ui) {
			$("#del-name").val(thisCustomer.name);
			$("#del-surname").val(thisCustomer.surname);
		},

		buttons: [
				{
				text: "Conferma",
				click: function() {
					deleteCustomer(thisCustomer.id);
					dialogConfirm.dialog("close");
					
				}
			},
			{
				text: "Annulla",
				click: function() {
					dialogConfirm.dialog("close");
					
				}
			}
		]
	});
	

		$("#id, #name, #surname").keypress(function(e) {
			if (e.keyCode == 13) {
				$('#bth-searchCustomer').trigger("click");
			}
		}); 

	
	$("#bth-searchCustomer").click(function() {
		
		$('#table tbody').empty();
		console.log("entra in searchCustomer");
		var searchCustomer = {}
		
		if (($("#id").val()) == "") {
			searchCustomer["id"] = null;
		} else {
			searchCustomer["id"] = $("#id").val();
		}
		searchCustomer["name"] = $("#name").val();
		searchCustomer["surname"] = $("#surname").val();
		console.log("CUSTOMER", searchCustomer);
		
		
				
		$.ajax({
			
			type: "POST",
			contentType: "application/json",
			url: "./findCustomer",
			data: JSON.stringify(searchCustomer),
			dataType: 'json',
			timeout: 100000,
			error: function(xhr, status) {
				console.log(status);
				console.log(xhr.responseText);
				alert("Errore durante la ricerca");
			},
			success: function(data) {
				
				if(!$.trim(data)){
					alert("Nessun utente trovato.");
					}
				else{
				
				var table ="";
				for (var i = 0; i < data.length; i++) {
					table +=
						"<tr id='" + i + "'>" +
						"<td id='id" + i + "'>" + data[i].id + "</td>" +
						"<td id='name" + i + "'>" + data[i].name + "</td>" +
						"<td id='surname" + i + "'>" + data[i].surname + "</td>" +
						"<td id='birthDate" + i + "'>" + data[i].birthDate + "</td>" +
						"<td class='acc-bth'></td>" +
						"<td class='cng-bth'></td>" +
						"<td class='del-bth'></td>" +
						"</tr>";
				}
								
				$( "#table tbody" ).append(table);
				}
				
				form = dialog.find("form").on("submit", function(event) {
					event.preventDefault();
					console.log("esegue il dialog find");
					updateCustomer();
				});
				
				$(".cng-bth").on("click", function() {
					var j = $(this).closest('tr').attr('id');
					console.log("j", j);
					thisCustomer = data[j];
					console.log("thisCUSTOMER", thisCustomer);
					dialog.dialog("open");
				});
				
				$(".del-bth").click(function() {
					var j = $(this).closest('tr').attr('id');
					console.log("j", j);
					thisCustomer = data[j];
					console.log("thisCUSTOMER", thisCustomer);

					dialogConfirm.dialog("open");
					
				
					console.log("Deleting Customer:", thisCustomer);



				});
				
				$(".acc-bth").click(function() {
					var j = $(this).closest('tr').attr('id');
					console.log("j", j);
					var thisCustomer = data[j];
					console.log("View accounts of:", customer);
//					window.location.replace("http://localhost:8080/simple-jee-webapp/account");
					
					$.ajax({
						type: 'post',
						contentType: "application/json",
						url: "./manageAccount",
						data: JSON.stringify(thisCustomer.id),
						success: function(data) {
							console.log(data);
							alert("utente correttamente inserito a DB");
						},
						error: function(xhr, status) {
							console.log(status);
							console.log(xhr.responseText);
							alert("Errore durante la Modifica. Utente non modificato");
						}
					});
				});
			}
		});
	});
});