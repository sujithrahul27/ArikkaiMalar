package com.sura.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="jobs")
public class Job {
	@Id
	private String jobTitle;
	private String jobDescription;
	private int experience;
	private String[] skills;
	private String Company;
	private String Location;
	private String OfficeAdress;
	private String interviewDate;
	
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getOfficeAdress() {
		return OfficeAdress;
	}
	public void setOfficeAdress(String officeAdress) {
		OfficeAdress = officeAdress;
	}
	public String getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String[] getSkills() {
		return skills;
	}
	@Override
	public String toString() {
		return "Job [jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", experience=" + experience
				+ ", skills=" + Arrays.toString(skills) + ", Company=" + Company + ", Location=" + Location
				+ ", OfficeAdress=" + OfficeAdress + ", interviewDate=" + interviewDate + "]";
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	
	
}
