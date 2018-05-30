package cn.bgenius.pconnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.record.impl.ODocument;

import cn.bgenius.pconnect.model.User;

@Controller
@RequestMapping(path="/todo")
public class TodoController {
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// OPEN THE DATABASE
		
		OrientDB orientDB = new OrientDB("remote:localhost", null);
		ODatabaseDocument db = orientDB.open("testgraph","admin", "admin");

		// CREATE A NEW DOCUMENT AND FILL IT
		ODocument doc = new ODocument("Person");
		doc.field( "name", "Luke" );
		doc.field( "surname", "Skywalker" );
		doc.field( "city", new ODocument("City")
		   .field("name","Rome")
		   .field("country", "Italy") );

		// SAVE THE DOCUMENT
		db.save(doc);

		db.close();
		orientDB.close();
		return null;
	}
}
