package com.randomSequence.springmvc.service;

import java.util.List;

import com.randomSequence.springmvc.model.Record;



public interface RecordService {
	
	void saveRecord(String records);
	
	/* updateRecord(Record record);*/
	
	List<String> findAllRecords(); 
	
}
