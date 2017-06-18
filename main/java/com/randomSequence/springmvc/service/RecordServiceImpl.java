package com.randomSequence.springmvc.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.randomSequence.springmvc.model.Record;

@Service("recordService")
public class RecordServiceImpl implements RecordService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<String> records;
	
	static{
		records= readProperty();
	}

	public List<String> findAllRecords() {
		return records;
	}
	
	
	public void saveRecord(String recordNew) {
		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("resource.properties");

			// set the properties value
			prop.setProperty("row",recordNew);
			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	  }

//	public void updateRecord(Records record) {
//		int index = Records.indexOf(record);
//		records.set(index, record);
//	}


	private static List<String> readProperty(){
		List<String> records = new ArrayList<String>();
			Properties prop = new Properties();
			InputStream input = null;
			try {
				input = new FileInputStream("resource.properties");
						prop.load(input);
						BufferedReader r = new BufferedReader(new InputStreamReader(input));
						    while (r.readLine() != null) {
						    	String[] temp=r.readLine().split(",");
						    	for(String str:temp)
						        records.add(str);
						    }
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		return records;
	}

}
