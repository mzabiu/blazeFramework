package com.api.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LaunchPadsJson {

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRockets() {
		return rockets;
	}

	public void setRockets(String rockets) {
		this.rockets = rockets;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty
	private String ID;

	@JsonProperty
	private String name;

	@JsonProperty
	private String full_name;

	@JsonProperty
	private String locality;

	@JsonProperty
	private String region;

	@JsonProperty
	private String rockets;

	@JsonProperty
	private String status;

}
