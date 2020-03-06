package io.java.praveen.dao;

import java.util.Comparator;


public class Data implements Comparator<Data> {

	private String state;
	private String country;
	private String corordinates;
	private long number;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCorordinates() {
		return corordinates;
	}

	public void setCorordinates(String corordinates) {
		this.corordinates = corordinates;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Data [state=" + state + ", country=" + country + ", corordinates=" + corordinates + ", number=" + number
				+ "]";
	}

	@Override
	public int compare(Data o1, Data o2) {
		Data d = (Data) o1;
		Data e = (Data) o2;
		return d.getNumber()>e.getNumber()? 1:-1;
	}

	
	
	

}
