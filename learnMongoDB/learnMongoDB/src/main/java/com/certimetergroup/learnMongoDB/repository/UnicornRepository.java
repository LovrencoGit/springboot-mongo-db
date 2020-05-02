package com.certimetergroup.learnMongoDB.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.certimetergroup.learnMongoDB.model.Unicorn;

//https://www.mkyong.com/spring-boot/spring-boot-spring-data-mongodb-example/
//https://www.baeldung.com/queries-in-spring-data-mongodb
//https://www.devglan.com/spring-boot/spring-boot-mongodb-crud
	
public interface UnicornRepository  extends MongoRepository<Unicorn, Long>, UnicornCustomRepository {

	@Query("{_id:'?0'}")
	Unicorn findByIdUnicorn(String idUnicorn);

	Unicorn findByName(String name);

	Unicorn findByGenderAndWorm(String gender, Boolean worm);

    @Query("{gender:'?0'}")
    ArrayList<Unicorn> findUnicornByGender(String gender);
	
}
