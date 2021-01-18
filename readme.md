P9  Notes for a patient

# MongoDB Init
cf. https://www.freecodecamp.org/news/learn-mongodb-a4ce205e7739/
cf. https://docs.mongodb.com/manual/reference/method/db.createCollection/
1. Create a DB : use p9note
2. Create a collection : PatientNote (db.createCollection("note"))
2. Create a collection : database_sequences (db.createCollection("database_sequences"))

Commandes mongo
1. "show databases" ti show the list of databases
2. "use p9note" to switch ti p9note database
3. "show collections"
4. "db.note.drop()" to drop collection "note"
5. "db.database_sequences.drop()" to drop collection "database_sequences"
6. "db.note.countDocuments({})" to count the number of documents
7. others / db.note.insert( { "patientId": "1", "title": "Practitioner's notes/recommendations", "note": "Patient states that they are 'feeling terrific" } )
/ db.note.find({"patientId" : "1"})

# P9_note Backend
This application is a medical web services application, il allows CRUD Notes for a patient : 
1. Create a Note
2. Update a Note
3. Delete a Note
4. Get a Note
5. Get all Notes


## Technical:
1. Framework: Spring Boot v2.2.5
2. Java 8
3. Mongo DB 4.2.X
4. Maven 3.6


## Setup 
1. Setup a database MongoDB with "p9note" and "p9note_test" databases for developements and tests
3. Install Java: https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
4. Spring : https://spring.io


## Docker
The Docker file has been set, this application is enabled for Docker

Docker commands are (type from root folder P9_note): 
1. Build the image : "docker build --tag notes ."
2. Run the image : "docker run -p 8049:8049 notes"
3. Stop the image  : "docker stop notes ."
4. Remove the image :  "docker rmi -f notes"


## Unit Test
1. Unit tests are written for Utils, Domain, Repository and Controller
2. Integration tests are written for controller


# Maven
1. mvn clean install
2. mvn clean verify  : generate tests and tests reports
3. mvn site  : generate all reportings
4. mvn spring-boot:run (run app)
5. mvn spring-boot:stop (stop app) 


## Run & tests
1. Run P9NoteApplication
2. Open in a browser http://localhost:8049 for test environment


### Other consideration
JAVADOC has been initialized and needs to be completed.