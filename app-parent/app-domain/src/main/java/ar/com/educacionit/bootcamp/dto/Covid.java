package ar.com.educacionit.bootcamp.dto;

import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "date", "states", "positive", "negative", "pending", "hash" })
@Generated("jsonschema2pojo")
public class Covid {

	@JsonProperty("date")
	private String date;
	@JsonProperty("states")
	private Integer states;
	@JsonProperty("positive")
	private Integer positive;
	@JsonProperty("negative")
	private Integer negative;
	@JsonProperty("pending")
	private Integer pending;
	@JsonProperty("hash")
	private String hash;

	public Covid() {

	}

	public Covid(String date, Integer states, Integer positive, Integer negative, Integer pending, String hash) {
		super();
		this.date = date;
		this.states = states;
		this.positive = positive;
		this.negative = negative;
		this.pending = pending;
		this.hash = hash;
	}

	@JsonProperty("date")
	public String getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("states")
	public Integer getStates() {
		return states;
	}

	@JsonProperty("states")
	public void setStates(Integer states) {
		this.states = states;
	}

	@JsonProperty("positive")
	public Integer getPositive() {
		return positive;
	}

	@JsonProperty("positive")
	public void setPositive(Integer positive) {
		if (positive == null)
			this.positive = 0;
		else
			this.positive = positive;
	}

	@JsonProperty("negative")
	public Integer getNegative() {
		return negative;
	}

	@JsonProperty("negative")
	public void setNegative(Integer negative) {
		if (negative == null)
			this.negative = 0;
		else
			this.negative = negative;
	}

	@JsonProperty("pending")
	public Integer getPending() {
		return pending;
	}

	@JsonProperty("pending")
	public void setPending(Integer pending) {
		if (pending == null)
			this.pending = 0;
		else
			this.pending = pending;
	}

	@JsonProperty("hash")
	public String getHash() {
		return hash;
	}

	@JsonProperty("hash")
	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "Covid [date=" + date + ", states=" + states + ", positive=" + positive + ", negative=" + negative
				+ ", pending=" + pending + ", hash=" + hash + "]";
	}

}