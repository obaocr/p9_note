P9  Notes

# MongoDB Init
cf. https://www.freecodecamp.org/news/learn-mongodb-a4ce205e7739/
cf. https://docs.mongodb.com/manual/reference/method/db.createCollection/
1. Create a DB : use p9note
2. Create a collection : PatientNote (db.createCollection("note"))
2. Create a collection : database_sequences (db.createCollection("database_sequences"))


db.patientNote.drop()
db.note.countDocuments({})

db.note.insert( { "patientId": "1", "title": "Practitioner's notes/recommendations", "note": "Patient states that they are 'feeling terrific" } )

db.note.find({"_id" : ObjectId("5ff5c9ea40e04cbc3213338d")})

db.note.find({"patientId" : "1"})