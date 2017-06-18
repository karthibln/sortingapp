package com.randomSequence.springmvc.model;

public class Record {

	private long id;
	
	public Record(){
		id=0;
	}
	
	public Record(long id){
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Record))
			return false;
		Record other = (Record) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Record [id=" + id +  "]";
	}
	

	
}
