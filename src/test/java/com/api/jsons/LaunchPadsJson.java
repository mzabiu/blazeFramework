package com.api.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LaunchPadsJson {

	@JsonProperty
	private String rockets;
	
	

	public String getRockets() {
		return rockets;
	}

	public void setRockets(String rockets) {
		this.rockets = rockets;
	}

	@JsonProperty
	private String name;

	@JsonProperty
	private String full_name;

	@JsonProperty
	private String locality;

	@JsonProperty
	private String region;

	@JsonProperty
	private String timezone;

	@JsonProperty
	private String latitude;

	@JsonProperty
	private String longitude;

	@JsonProperty
	private String launch_attempts;

	@JsonProperty
	private String launch_successes;

	@JsonProperty
	private String launches;

	@JsonProperty
	private String details;

	@JsonProperty
	private String status;

	@JsonProperty
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_name() {
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

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLaunch_attempts() {
		return launch_attempts;
	}

	public void setLaunch_attempts(String launch_attempts) {
		this.launch_attempts = launch_attempts;
	}

	public String getLaunch_successes() {
		return launch_successes;
	}

	public void setLaunch_successes(String launch_successes) {
		this.launch_successes = launch_successes;
	}

	public String getLaunches() {
		return launches;
	}

	public void setLaunches(String launches) {
		this.launches = launches;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
