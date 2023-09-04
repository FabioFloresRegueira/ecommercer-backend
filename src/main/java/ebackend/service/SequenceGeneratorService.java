package ebackend.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.Objects;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import ebackend.model.DababaseSequence;

@Service
public class SequenceGeneratorService {

	private MongoOperations mongoOperations;

    
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
	  
 
    public long generateSequence(String seqName) {

    	    	
    	DababaseSequence contador = mongoOperations.findAndModify( Query.query(where("_id").is(seqName)), 
    			new Update().inc("seq",1), 
    			options().returnNew(true).upsert(true), DababaseSequence.class ); 

        return !Objects.isNull(contador) ? contador.getSeq() : 1;

    }

		
}
