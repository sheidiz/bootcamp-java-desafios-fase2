package ar.com.educacionit.bootcamp.dto;

import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "id", "name", "base_experience", "height", "order", "weight" })
@Generated("jsonschema2pojo")
public class Pokemon extends Entity {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("base_experience")
	private Integer baseExperience;
	@JsonProperty("height")
	private Integer height;
	@JsonProperty("weight")
	private Integer weight;
	
	public Pokemon() {
		
	}
	public Pokemon(Integer id, String name, Integer baseExperience, Integer height,
			Integer weight) {
		this.id = id;
		this.name = name;
		this.baseExperience = baseExperience;
		this.height = height;
		this.weight = weight;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("base_experience")
	public Integer getBaseExperience() {
		return baseExperience;
	}

	@JsonProperty("base_experience")
	public void setBaseExperience(Integer baseExperience) {
		this.baseExperience = baseExperience;
	}

	@JsonProperty("height")
	public Integer getHeight() {
		return height;
	}

	@JsonProperty("height")
	public void setHeight(Integer height) {
		this.height = height;
	}

	@JsonProperty("weight")
	public Integer getWeight() {
		return weight;
	}

	@JsonProperty("weight")
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", baseExperience=" + baseExperience + ", height=" + height
				+ ", weight=" + weight + "]";
	}
	

}