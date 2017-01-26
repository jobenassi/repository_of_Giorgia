/*
 * A page can't be manipulated safely until the document is "ready." 
 * jQuery detects this state of readiness for you. Code included inside $( document ).ready() 
 * will only run once the page Document Object Model (DOM) is ready for JavaScript code to execute. 
 * */
$(document).ready(function() {
	
$("#bth-search").click(function() {
		
		console.log("entra al onload");

		var search = {}
		search["name"] = $("#name").val();
		search["surname"] = $("#surname").val();
		
		console.log("SEARCH", search);

		$('#table tbody').remove();

		// TODO: inserire la chiamata ajax POST che recupera, passando per il
		// controller di Spring MVC, le informazioni sul conto e le mostra nella
		// table


		$.ajax({
		      type: "POST",
		      contentType: "application/json",
		      url: "./customer",
		      data: JSON.stringify(search),
		      dataType: 'json',
		      timeout : 100000,
		      success: function(data){
		    	  
		    	  var table = "<tbody>";

		    	  for (var i = 0; i < data.length; i++){
		    		  table+= 
		    			  "<tr>"+
		    			  "<td>" + data[i].accountNumber + "</td>"+
		    			  "<td>"+ data[i].description  + "</td>"+
		    			  "<td>" + data[i].totalBalance + "</td>"+
		    			  "</tr>";
		    	  }
		    	  
		    	  
		    	  table+="</tbody>"
		    	  
		    	  $("thead").after(table);
		      }
		 });
	});

});