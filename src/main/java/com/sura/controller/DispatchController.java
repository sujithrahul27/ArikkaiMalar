package com.sura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sura.model.Job;
import com.sura.model.Search;
import com.sura.service.JobsDbService;

@RestController
public class DispatchController {
	@Autowired 
	JobsDbService ds;
	@Autowired
	Search s;
	
	@GetMapping("/getjobs")
	public List<Job> getJobs(){
		return ds.retriveJobs();
	}
	
	@GetMapping("/searchskill/{skill}")
	public List<Job> searchJobs(@PathVariable("skill") String skill){
		
		return s.searchByText(skill);
		
	}
	
	@PostMapping("/postjobs")
		public List<Job> putJobs(@RequestBody List<Job> jobs){
			return ds.saveJobs(jobs);
		}
	
	//adding single job
	@PostMapping("/postjob") 
	public Job postJob(@RequestBody Job job) {
	    return ds.saveJob(job);
	}
	}

	


