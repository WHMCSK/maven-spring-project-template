package cn.bgenius.pconnect.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Value;

import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.record.impl.ODocument;

import cn.bgenius.pconnect.web.dto.Todo;

@Controller
@RequestMapping(path="/todo")
public class TodoController {
	
	@Value("${ds.orientdb.url}")  
    private String ds_orientdb_url; 
	@Value("${ds.orientdb.db}")  
	private String ds_orientdb_db;
	@Value("${ds.orientdb.uid}")  
	private String ds_orientdb_uid;
	@Value("${ds.orientdb.pwd}")  
	private String ds_orientdb_pwd;

	/**
	 * @return
	 */
	@GetMapping(path = "/all")
	public @ResponseBody List<Todo> all() {
		// OPEN THE DATABASE
		OrientDB orientDB = new OrientDB(ds_orientdb_url, OrientDBConfig.defaultConfig());
		try(ODatabaseDocument db = orientDB.open(ds_orientdb_db,ds_orientdb_uid, ds_orientdb_pwd);){
			
			List<Todo> lp = new ArrayList<Todo>();
			for (ODocument doc : db.browseClass("Todoes")) {
				Todo newTodo = new Todo();
				newTodo.todo = doc.field("todo") == null? "" : doc.field("todo").toString();
				newTodo.rid = doc.field("@rid") == null ? "": doc.field("@rid").toString();
				newTodo.rid = doc.field("version") == null ? "": doc.field("version").toString();
				lp.add(newTodo);
			}
		
			orientDB.close();
			return lp;
		}
	}
	

	@PostMapping(path = "/add")
	public @ResponseBody Todo put(@RequestBody Todo todo) {
		// OPEN THE DATABASE
	
		OrientDB orientDB = new OrientDB(this.ds_orientdb_url, OrientDBConfig.defaultConfig());
		try (ODatabaseDocument db = orientDB.open(this.ds_orientdb_db,this.ds_orientdb_uid, this.ds_orientdb_pwd);){
			OVertex vtx = db.newVertex(db.createClassIfNotExist("Todoes", "V"));
			vtx.setProperty("todo", todo.todo);
			vtx.save();
		}
		
		orientDB.close();
		return null;
	}
	
	@PostMapping(path = "/update")
	public @ResponseBody Todo update(@RequestBody Todo todo) {
		ORID theRid = new ORecordId(todo.rid);
		
		OrientDB orientDB = new OrientDB(this.ds_orientdb_url, OrientDBConfig.defaultConfig());
		try(ODatabaseDocument db = orientDB.open(this.ds_orientdb_db,this.ds_orientdb_uid, this.ds_orientdb_pwd);){
			OVertex vtx = db.load(theRid);
			vtx.setProperty("todo", todo.todo);
			vtx.save();
		}
		orientDB.close();
		return null;
		
	}
	
	@PostMapping(path = "/delete")
	public @ResponseBody Todo delete(@RequestBody Todo todo) {
		ORID theRid = new ORecordId(todo.rid);
	
		OrientDB orientDB = new OrientDB(this.ds_orientdb_url, OrientDBConfig.defaultConfig());
		try(ODatabaseDocument db = orientDB.open(this.ds_orientdb_db,this.ds_orientdb_uid, this.ds_orientdb_pwd);){
			OVertex vtx = db.load(theRid);
			vtx.delete();
			vtx.save();
		}
		orientDB.close();
		return null;
	}
	
	@PostMapping(path = "/deletebyid")
	public @ResponseBody Todo delete(@RequestParam String rid) {
		ORID theRid = new ORecordId(rid);
	
		OrientDB orientDB = new OrientDB(this.ds_orientdb_url, OrientDBConfig.defaultConfig());
		try(ODatabaseDocument db = orientDB.open(this.ds_orientdb_db,this.ds_orientdb_uid, this.ds_orientdb_pwd);){
			OVertex vtx = db.load(theRid);
			vtx.delete();
			vtx.save();
		}
		orientDB.close();
		return null;
	}
}
