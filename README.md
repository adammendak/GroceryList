# GroceryList
Grocery list - przykład nowoczesnej aplikacji webowej

# Moduły 

Front End - miejsce gdzie znajduje się moduł frontendowy <br>
Core - Główne serwisy i kontrolery aplikacji webowej backendowej <br>
Model - Model danych aplikacji <br>

#Komentarz

Kod źródłowy, dostępny do pobrania z repozytorium - https://github.com/adammendak/GroceryList <br>
także do pobrania link z google dyska, aplikacja ma 400 mega - https://drive.google.com/open?id=1GatjXBvpeIQ9rLBm2G8La9vQI1jRe5mL  <br>

Środowisku produkcyjne: <br>
Korzystamy z darmowego providera chmurowego Heroku, poniżej link do aplikacji spring bootowej backendowej:<br> 
https://rocky-chamber-54408.herokuapp.com/  <br>
frontend: <br>
https://glacial-brushlands-79835.herokuapp.com/  <br>

obie aplikacje się ze sobą komunikują przy użyiu HTTP i  w konwencji RESTowych usług. Proszę odczekać do 30 sekund przy pierwszym pingowaniu urlów gdyż jest to darmowy tier aplikacji i po 30 minutach nieużywania aplikacje hibernują i trzeba poczekać na reboot serwera. <br>
W skrócie technologie użyte przy backendzie to Spring Boot, Hibernate, Spring Data, Maven, Java 8, Lombok, mockito, Bazy H2 przy użyciu profilu "dev" i baza PostgreSQL przy użyciu profilu "prod". <br> Aplikacja frontendowa w technologii Angular8, RxJs, Typescript, i hostuję ją na serwerze node.js w chmurze, aplikacja backendowa jest to wbudowany serwer Tomcat który jest dostarczany w Spring Boocie. <br>
Instrukcja uruchomienia nie jest taka prosta, trzeba uruchomić plik CoreApplication w module core z profilem dev, by lokalnie serwer został postawiony, jeżeli chodzi o sferę frontową trzeba wejść do katalogu frontend/groceryList i wpisać komendę npm install by zainstalować zależności javascriptowe potem zainstalować angular clienta i wpisać komendę ng serve by lokalny developerski serwer został odpalony. <br> Aplikacja została pomyślana tak by mogła działać w chmurze niezależnie od lokalnych ustawień, deployment jest robiony przy użyciu heroku clienta i wywołaniu metody git push heroku master po zalogowaniu się na moje konto w heroku.
Testujemy aplikację przy użyciu biblioteki mockito by przetestować bardziej zaawansowane funkcjonalności niż biblioteka jUnit, można wywołać mvn test metodę by wywołać wszystkie testy

# Collaborators
Elżbieta Dutkiewicz, Adam Mendak
