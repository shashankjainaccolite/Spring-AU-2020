package com.model;

import java.util.Map;

public class CompanyList {
	
	private Map<String, Company> companyMap;

	public Map<String, Company> getCompanyMap() {
		return companyMap;
	}

	public void setCompanyMap(Map<String, Company> companyMap) {
		this.companyMap = companyMap;
	}
	
	public void displayCompanies() {
		System.out.println(companyMap);
	}

}
