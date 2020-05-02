package com.certimetergroup.learnMongoDB.repository;

import com.certimetergroup.learnMongoDB.model.Unicorn;

public interface UnicornCustomRepository {

	int updateLovesByIdUnicorn(Unicorn unicorn);

	int updateUnicornByIdUnicorn(Unicorn unicorn);
	
}
