package com.t9.octavo.services;

import com.t9.octavo.models.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {
	 @Autowired
	    private MongoOperations mongoOperations;


	    public Long getSequenceNumbercD(String sequenceName) {
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        
	        Update update = new Update().inc("seqcD", 1);
	        DbSequence counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeqcD() : 1;
	    }
	    
	    public Long getSequenceNumberdE(String sequenceName) {
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        Update update = new Update().inc("seqdE", 1);
	        DbSequence counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeqdE() : 1;
	    }
	    
	    public Long getSequenceNumbergR(String sequenceName) {
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        Update update = new Update().inc("seqgR", 1);
	        DbSequence counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeqgR() : 1;
	    }
	    
	    public Long getSequenceNumbernC(String sequenceName) {
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        Update update = new Update().inc("seqnC", 1);
	        DbSequence counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeqnC() : 1;
	    }
	    
	    public Long getSequenceNumbertN(String sequenceName) {
	        Query query = new Query(Criteria.where("id").is(sequenceName));
	        Update update = new Update().inc("seqtN", 1);
	        DbSequence counter = mongoOperations
	                .findAndModify(query,
	                        update, options().returnNew(true).upsert(true),
	                        DbSequence.class);

	        return !Objects.isNull(counter) ? counter.getSeqtN() : 1;
	    }
}

