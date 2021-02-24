package com.ocr.p9_note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO Gestion user pour la BDD Mongo... + Docker  https://stackoverflow.com/questions/4881208/how-to-secure-mongodb-with-username-and-password
// TODO secu https://docs.mongodb.com/manual/administration/security-checklist/
// TODO https://docs.mongodb.com/manual/tutorial/enable-authentication/
// TODO JSAPT pour mdp mongo ...

@SpringBootApplication
public class P9NoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(P9NoteApplication.class, args);
	}

}
