package com.batch.kafka;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class AmountItemProcessor implements ItemProcessor<Amount, Amount>{

	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	@Override
	public Amount process(Amount arg0) throws Exception {
		// TODO Auto-generated method stub
		//Once the amount is read from both the file, it is published in the kafka queue
		
		// call sendMessage method with msg from file and topic name as input parameter
		return null;
	}
	
	public void sendMessage(String msg, String topicName) {
		kafkaTemplate.send(topicName, msg);
	}

}
