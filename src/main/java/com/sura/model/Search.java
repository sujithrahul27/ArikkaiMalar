package com.sura.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.bson.Document;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;

@Repository
public class Search implements SearchRepository{
	@Autowired
	MongoClient mongoClient;
	@Autowired
	MongoConverter con;
	@Override
	public List<Job> searchByText(String text) {
		// TODO Auto-generated method stub
			MongoDatabase database = mongoClient.getDatabase("LinkedIn2003");
			MongoCollection<Document> collection = database.getCollection("jobs");
			AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
			    new Document("index", "default")
			            .append("text", 
			    new Document("query", text)
			                .append("path", "skills")))));
		List<Job> jobs = new ArrayList<>();
		result.forEach(n -> jobs.add(con.read(Job.class, n)));
		
		
		return jobs;
	}

	
}
