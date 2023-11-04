#Cryptocurrency Management Applicatie
Dit is een voorbeeld van een Spring Boot-applicatie voor het beheren van cryptocurrency-gegevens. Met deze applicatie kun je informatie over cryptocurrencies ophalen, toevoegen, bijwerken en verwijderen.

Volg deze stappen om de applicatie op je lokale ontwikkelomgeving te installeren:

Zorg ervoor dat je Java Development Kit (JDK) 11 of hoger hebt geïnstalleerd.

Clone de repository naar je lokale machine:

git clone https://github.com/jouw-gebruikersnaam/cryptocurrency-app.git
Navigeer naar de gekloonde map:

cd cryptocurrency-app
Bouw het project met Maven:

mvn clean install
Start de applicatie:

java -jar target/cryptocurrency-app.jar
De applicatie wordt nu uitgevoerd en is beschikbaar op http://localhost:8080.

Gebruik
Gebruik postman om de endpoints te testen. Ik heb het volgende bestand toegevoegd om deze te importeren: Crypto.postman_collection.json
De applicatie biedt een RESTful API voor het beheren van cryptocurrency-gegevens. Je kunt HTTP-verzoeken maken om cryptocurrencies op te halen, toe te voegen, bij te werken en te verwijderen.
Raadpleeg de API-documentatie voor details over beschikbare endpoints en verzoeken.

Functionaliteit
De applicatie biedt de volgende functionaliteit:

Het ophalen van een lijst met cryptocurrencies met paginering.

Het ophalen van een specifieke cryptocurrency op basis van ID.

Het toevoegen van een nieuwe cryptocurrency.

Het bijwerken van een bestaande cryptocurrency.

Het verwijderen van een cryptocurrency op basis van ID.

Technologieën
De applicatie maakt gebruik van de volgende technologieën en frameworks:

Java 21+
Spring Boot
Spring Data JPA
Spring Web
Maven
H2 Database (ingebouwde database voor ontwikkeling)
jUnit
Bijdragen aan deze applicatie zijn welkom. Als je verbeteringen wilt voorstellen of problemen wilt rapporteren, maak dan een GitHub Issue aan of stuur een Pull Request.
