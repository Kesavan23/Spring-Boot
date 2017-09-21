package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TopicService;
import com.example.Topics;
@Controller
@RestController
public class PalindromeController {
	@Autowired
	private TopicService topicService;
	
//	@RequestMapping("/hello")
//	public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        model.addAttribute("name", name);
//        return "hello";
//    }

	@RequestMapping("/welcome")
	public String sayHi(){
		return "Hello";
		
	}
	
//	@RequestMapping("/names")
//	public List<Topics> getTopics(){
//		 return topicService.getAllTopics();
//		 
//	}
//	@RequestMapping("/topics/{id}")
//	public Topics getTopic(@PathVariable String id){
//		return topicService.getTopic(id);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/names")
//	public void addTopic(@RequestBody Topics topic){
//		topicService.addTopic(topic);
//		
//	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/names/{id}")
	public void updateTopic(@RequestBody Topics topic, @PathVariable String id){
		topicService.UpdateTopic(id, topic);
		
	}
	
	
	@RequestMapping("palin/{name}")
	public String getPalindrome(@PathVariable String name){
		
		String reverse = "";
		for(int i=name.length() -1;i>=0;i--){
			reverse = reverse + name.charAt(i);
		}
		
		if(name.equals(reverse)){
			return "it is a palindrome";
		}
		
		int[] numArr = createArray(name);
		int count =0;
		for(int t: numArr){
			if(t%2 !=0){
				count++;
			}
			if(count>1){
				return "Palindrome cannot be formed";
			}
		}
		
		return "Palindrome can be formed";
	}
	
	private int[] createArray(String name){
		int[] numArr = new int[256];
		char[] charArr = name.toCharArray();
		for(char ch: charArr){
			numArr[ch]++;
		}
		return numArr;
			
	}
//	@RequestMapping(method=RequestMethod.POST, value="/names")	
//	public void addTopic(@RequestBody Topics  topic){
//		
//		topicio.add();
//		
//	}

}
