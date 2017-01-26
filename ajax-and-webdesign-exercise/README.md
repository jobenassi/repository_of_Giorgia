 _    _      _                           ___ _____ _____   _____                  _          
| |  | |    | |                         |  ___|                (_)         
| |  | | ___| |__   __ _ _ __  _ __     | |____  _____ _ __ ___ _ ___  ___ 
| |/\| |/ _ | '_ \ / _` | '_ \| '_ \    |  __\ \/ / _ | '__/ __| / __|/ _ \
\  /\  |  __| |_) | (_| | |_) | |_) |   | |___>  |  __| | | (__| \__ |  __/
 \/  \/ \___|_.__/ \__,_| .__/| .__/    \____/_/\_\___|_|  \___|_|___/\___|
                        | |   | |                                                            
                        |_|   |_|                                                           
*************************************************************************************************************************************

DESCRIZIONE:

Semplice Web App che implementa il pattern MVC attraverso una request Spring MVC e 1 JSP.
Dalla pagina principale, è possibile inserire due input di testo per i campi nome e cognome e un bottone "Cerca".
Al click sul bottone "Cerca" deve essere effettuata una chiamata ajax (di tipo POST) al controller Spring che invoca il metodo findAccountsByCustomerNameAndSurnameOrderedByAccountNumber del BankService con i due parametri in input.
Il risultato viene visualizzato in una jsp con i dati in tabella (per ogni riga, visualizziamo account number,description, total balance).

Il layout grafico della pagina deve essere identico a quello rappresentato nel mock-up grafico (/mockup/beforeSearching e /mockup/afterSearching).

ESERCIZIO:

1. Importare il progetto ajax-and-webdesign-exercise su Eclipse come progetto MAVEN

2. Riutilizzare Apache Tomcat 8 (o eventualmente 7) usato nei precedenti esercizi

3. Deploy del progetto web su tomcat (Da IDE Eclipse: Click destro su Tomcat 8 --> Add and Remove )

4. Copiare il context.xml presente nella cartella di config per sovrascrivere il context.xml del proprio tomcat

8. Implementare la chiamata ajax nel controller JavaScript static/js/customerCntrl.js e mostrare il risultato nella table presente nella JSP index.jsp. Modificare il CSS in static/css/main.css per rendere la grafica identica a quella del mockup.

9. Al termine dell'esercizio cambiare l'implementazione di customerCntrl.js e CustomerController.java per eseguire una chiamata ajax GET invece che POST.