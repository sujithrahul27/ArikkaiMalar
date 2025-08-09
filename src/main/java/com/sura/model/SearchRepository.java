package com.sura.model;

import java.util.List;

public interface SearchRepository {
	
	List<Job >searchByText(String text);

}
