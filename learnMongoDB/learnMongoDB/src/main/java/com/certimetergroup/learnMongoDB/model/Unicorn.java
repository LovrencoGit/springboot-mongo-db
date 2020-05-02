package com.certimetergroup.learnMongoDB.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "unicorns")
public class Unicorn {

	@Id
	private String idUnicorn;
	private String name;
	private String gender;
	private Integer weight;
	private String home;
	private Boolean worm;
	private ArrayList<String> loves;
	private Integer vampires;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdUnicorn() {
		return idUnicorn;
	}
	public void setIdUnicorn(String idUnicorn) {
		this.idUnicorn = idUnicorn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public Boolean getWorm() {
		return worm;
	}
	public void setWorm(Boolean worm) {
		this.worm = worm;
	}
	public ArrayList<String> getLoves() {
		return loves;
	}
	public void setLoves(ArrayList<String> loves) {
		this.loves = loves;
	}
	public Integer getVampires() {
		return vampires;
	}
	public void setVampires(Integer vampires) {
		this.vampires = vampires;
	}

	
	@Override
	public String toString() {
		return "Unicorn {idUnicorn=" + idUnicorn + ", name=" + name + ", gender=" + gender + ", weight=" + weight
				+ ", home=" + home + ", worm=" + worm + ", loves=" + loves + ", vampires=" + vampires + "}";
	}
	
}
