package com.sura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sura.model.Job;
import com.sura.model.JobsRepository;



@Service
public class DbService {
	@Autowired
	JobsRepository jr;
	
	//reading all job data
	List<Job> retriveJobs(){
		return jr.findAll();
	}
	
	//reading a specific job
	Optional<Job> retriveJob(String jobTitle) {
		return jr.findById(jobTitle);
	}
	
	//creating all jobs
	List<Job> saveJobs(List<Job> jobs){
		jr.saveAll(jobs);
		return jobs;
	}
	
	//creating one jobs 
	Job saveJob(Job job) {
		jr.save(job);
		return job;
	}
	
	//deleting one job
	Job removeJob(Job job) {
		if(jr.existsById(job.getJobTitle())) {
			Job j = job;
			jr.delete(job);
			return j;
			
		}
		return null;
	}
	
	//deleting all jobs 
	List<Job> removeJobs(List<Job> jobs){
		for(Job j : jobs) {
			jr.deleteById(j.getJobTitle());
		}
		return jobs;
	}
	
	
}
