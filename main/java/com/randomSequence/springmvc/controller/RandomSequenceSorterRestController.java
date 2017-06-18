package com.randomSequence.springmvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.randomSequence.springmvc.model.Record;
import com.randomSequence.springmvc.service.RecordService;
 
@RestController
public class RandomSequenceSorterRestController {
 
    @Autowired
    RecordService recordService;  //Service which will do all data retrieval/manipulation work
 
    
    //-------------------Retrieve All Records--------------------------------------------------------
     
    @RequestMapping(value = "/records/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> listAllRecords() {
        List<String> records = recordService.findAllRecords();
        if(records.isEmpty()){
            return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<String>>(records, HttpStatus.OK);
    }
 
 
  //-------------------Create a Record--------------------------------------------------------
    
    @RequestMapping(value = "/records/", method = RequestMethod.POST)
    public ResponseEntity<Void> createRecord(@RequestBody String records,    UriComponentsBuilder ucBuilder) {
        recordService.saveRecord(records);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
}