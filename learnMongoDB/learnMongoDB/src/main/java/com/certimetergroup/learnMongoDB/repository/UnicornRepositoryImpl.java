package com.certimetergroup.learnMongoDB.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.certimetergroup.learnMongoDB.model.Unicorn;
import com.mongodb.client.result.UpdateResult;

public class UnicornRepositoryImpl implements UnicornCustomRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	
	@Override
	public int updateLovesByIdUnicorn(Unicorn unicorn) {
		String unicornName = unicorn.getName();
		ArrayList<String> unicornLoves = unicorn.getLoves();
		
		Query query = new Query(Criteria.where("name").is(unicornName));
		
		Update update = new Update();
        update.set("loves", unicornLoves);
        
        UpdateResult result = mongoTemplate.updateMulti(query, update, Unicorn.class);
		
        if( result == null )	throw new RuntimeException("UPDATE unicorn - 'result' null");
        
		return (int) result.getModifiedCount();
	}


	@Override
	public int updateUnicornByIdUnicorn(Unicorn unicorn) {
		String unicornId = unicorn.getIdUnicorn();
		
		Query query = new Query(Criteria.where("_id").is(unicornId));
		
		Update update = new Update();
        update.set("name", 		unicorn.getName());
        update.set("gender", 	unicorn.getGender());
        update.set("weight", 	unicorn.getWeight());
        update.set("home", 		unicorn.getHome());
        update.set("worm", 		unicorn.getWorm());
        update.set("loves", 	unicorn.getLoves());
        update.set("vampires", 	unicorn.getVampires());
		
        Unicorn unicornResult = mongoTemplate.findAndModify(query, update, Unicorn.class);
		
		return unicornResult==null ? 0 : 1;
	}
	
}
