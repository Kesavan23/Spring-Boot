package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
//	@Autowired
//	public TopicRepository topicRepository;

	public TopicService() {
		// TODO Auto-generated constructor stub
	}
	
	private List<Topics> topics = new ArrayList<> (Arrays.asList(
			new Topics("1", "Kesavan"),
			new Topics("2", "Monika"),
			new Topics("3", "Lakshmitha")));
	
//	public List<Topics> getAllTopics(){
//		//return topics;
//		List<Topics> topics = new ArrayList<Topics>();
//		topicRepository.findAll().forEach(topics::add);
//		return topics;
//	}
//	
//	public Topics getTopic(String id){
//		
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
//		
//	}
//
//	public void addTopic(Topics topic) {
//		// TODO Auto-generated method stub
//		//topics.add(topic);
//		topicRepository.save(topic);
//	}

	public void UpdateTopic(String id, Topics topic) {
		// TODO Auto-generated method stub
		for(int i=0; i<topics.size();i++){
			Topics t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;}
		}
		
			}
		
	}

