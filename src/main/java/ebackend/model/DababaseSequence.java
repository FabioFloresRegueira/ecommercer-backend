package ebackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public class DababaseSequence {

	@Id
    private String id;

    private long seq;

	public DababaseSequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DababaseSequence(String id, long seq) {
		super();
		this.id = id;
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}
	
	

	@Override
	public String toString() {
		return "DababaseSequence [id=" + id + ", seq=" + seq + "]";
	}
    
    
    
    
	
}
