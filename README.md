# Proiect PS

# Descrierea problemei 
Proiectul pe care l-am ales sa il implementez consta intr-o aplicatie desktop care faciliteaza viata unui schior care merge sa se relaxeze un weekend la munte.
Acesta aplicatie ofera urmatoarele informatii:
 - Toate echipamentele disponibile care se pot inchiria de la centrul de inchirieri
 - Toti monitorii de ski sau snowboard care lucreaza la acest centru de inchirieri 
 - Toti schiorii care s-au inscris in aplicatie 
 - - Numele acestora, email-ul lor, daca acestia au sau nu au echipament, daca acestia si-au angajat un instructor de ski
 - Un client poate sa vizualizeze ce echipamente are inchiriate 
 - Un client poate sa inchirieze un echipament/ sa angajeze un instructor de ski 
 - clientii si adminii se logheaza in functie de email-ul lor si parola asociata 
 - adminul este notificat de fiecare data cand un echipament este inchiriat
 - se poate genera un raport cu lista de inchirieri a fiecarui client, acesta se poate reprezenta in txt sau html.
 
Operatiile posibile asupra bazei de date sunt urmatoarele:
- inserarea unui client/unui echipament/unui admin/unui instructor de ski
- stergerea unui client/unui echipament/unui admin/unui instructor de ski
 - cautarea unui client/unui echipament/unui admin/unui instructor de ski 
 -unele operatii de update 
 -returnarea tuturor clientilor/tuturor echipamentelor/ tuturor instructorilor

 # API-uri folosite 
 API(application programming interface) reprezinta un set de reguli si specificatii pentru a putea programele sa comunice intre ele.
 
 In cadrul proiectului, vom folosi urmatoarele API-uri:
  - Postman
  - Mockito
  - Hibernate
  - Spring
  
 # Implementare 
 Aplicatia a fost scrisa folosind limbajul de programare Java prin intermediul IDE-ului IntelliJ. Pentru baza de date folosim MySql unde am creat o noua schema cu denumirea "ProiectPS". Legatura proiectului cu baza de date am realizat-o prin intermediul framework-ului "hibernate" pentru a se usura toata munca. In baza de date pana in momentul actual avem un numar de 4 tabele, dar legaturile intre ele inca nu s-au facut.
In intermediul aplicatiei avem in pachetul entity 4 clase principale care sunt scheletul aplicatiei. Datorita adnotarilor, dupa aceste clase s-au format tabelele. Pentru fiecare tabel avem cate o clasa repository unde avem implementate operatiile care se efectueaza asupra bazei de date. 
Aceste operatii le efectuam prin intermediul pachetului Service care face legatura repository-ului cu restul aplicatiei.
In aplicatie avem si un pachet pentru teste unde se testeaza diverse metode prin intermediul API-ului Mockito. 

 # Diagrama Use Case
![UseCase Diagram](UseCase.png)

 # Diagrama de pachete
![Package Diagram](pachete.png)

 # Diagrama de clase pentru Patternul Factory 
 ![Factory Diagram](Factory.png)
