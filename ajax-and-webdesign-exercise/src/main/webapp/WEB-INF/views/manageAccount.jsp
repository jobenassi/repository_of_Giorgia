<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  
  <title>Aggiungi conto</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  
  <!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
  <style>
    
    input.text { margin-bottom:12px; width:95%; padding: .4em; }
    fieldset { padding:0; border:0; margin-top:25px; }
    h1 { font-size: 1.2em; margin: .6em 0; }
    div #users-contain, div #accounts-contain { width: 350px; margin: 20px 0; }
    div #users-contain table, div #accounts-contain  table { margin: 1em 0; border-collapse: collapse; width: 100%; }
    div #users-contain table td, div#users-contain table th, div #accounts-contain table td, div#accounts-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
    .ui-dialog .ui-state-error { padding: .3em; }
    .validateTips { border: 1px solid transparent; padding: 0.3em; }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  
  
  $( function() {
    var dialog, form,
 

      id = $( "#id" ),
      descrizione = $( "#descrizione" ),
      saldo = $( "#saldo" ),
	  
      allFields = $( [] ).add( id ).add( descrizione ).add( saldo ),
      tips = $( ".validateTips" );
 
    function updateTips( t ) {
      tips
        .text( t )
        .addClass( "ui-state-highlight" );
      setTimeout(function() {
        tips.removeClass( "ui-state-highlight", 1500 );
      }, 500 );
    }
 
      function addAccount() {
      
        
        $( "#accounts tbody" ).append( 
        "<tr>" +
          "<td>" + id.val() + "</td>" +
          "<td>" + descrizione.val() + "</td>" +
          "<td>" + saldo.val() + "</td>" +
		 "</tr>" );
        dialog.dialog( "close" );
      }      
     
    dialog = $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 400,
      width: 350,
      modal: true,
      buttons: {
        "Create an account": addAccount,
        Cancel: function() {
          dialog.dialog( "close" );
        }
      },
      close: function() {
        form[ 0 ].reset();
        allFields.removeClass( "ui-state-error" );
      }
    });
 
    form = dialog.find( "form" ).on( "submit", function( event ) {
      event.preventDefault();
      addAccount();
    });
 
    $( "#create-account" ).button().on( "click", function() {
      dialog.dialog( "open" );
    });
    
    $("#menu" ).menu();
    
  } );
  
  $("#menu" ).menu();
  </script>
  
</head>
<body>

<ul id="menu">
  <li>
    <div>Item 1</div>
  </li>
  <li>
    <div>Item 2</div>
  </li>
  <li>
    <div>Item 3</div>
    <ul>
      <li>
        <div>Item 3-1</div>
      </li>
      <li>
        <div>Item 3-2</div>
      </li>
      <li>
        <div>Item 3-3</div>
      </li>
    </ul>
  </li>
  <li>
    <div>Item 4</div>
  </li>
  <li>
    <div>Item 5</div>
  </li>
</ul>
 
<div id="dialog-form" title="Create new account">
  <p class="validateTips"> * * *Tutti i campi sono obbligatori * * *</p>
 
  <form>
    <fieldset>
      
	       <input type="text" id="id" placeholder="IBAN" class="text ui-widget-content ui-corner-all">
      
	       <input type="text"  id="descrizione"  placeholder="Descrizione" class="text ui-widget-content ui-corner-all">
      
			<input  id="saldo"  placeholder="Saldo Iniziale" class="text ui-widget-content ui-corner-all">
	  
			
 
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>
 
 
<div id="users-contain" class="ui-widget">
  <h1>Inserisci un nuovo account per il cliente:</h1>
  <table id="users" class="ui-widget ui-widget-content">
    <thead>
      <tr class="ui-widget-header ">
	    <th>Id</th>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Data di nascita</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>7</td>
		<td>Sonia</td>
        <td>Benassi</td>
        <td>1993-07-19</td>
      </tr>
    </tbody>
  </table>
<div id="accounts-contain" class="ui-widget">
<button id="create-account">Aggiungi Conto</button>
<div>
 <table id="accounts" class="ui-widget ui-widget-content">
    <thead>
      <tr class="ui-widget-header ">
	    <th>IBAN</th>
        <th>Descrizione</th>
        <th>Saldo</th>
     </tr>
    </thead>
    <tbody>

    </tbody>
  </table>
 </div>
</body>
</html>