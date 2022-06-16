package com.revature.collections;

import java.util.Objects;

public class Animal {

	private String species;
	private int age;
	
	public Animal(String species, int age) {
		super();
		this.species = species;
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Animal [" + species + ", age = " + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Animal other = (Animal) obj;
		if (this.age != other.getAge()) {
			return false;
		}
		if(this.species == null) {
			if (other.getSpecies() != null) {
				return false;
			}
		} else if (!species.equals(other.species)) {
			return false;
		}
		return true;	
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(species,age);
	}
}
