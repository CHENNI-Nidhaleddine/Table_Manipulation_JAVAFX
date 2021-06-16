package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Movie {
    private String title;
    private int year;
    private double price;
    
    //Empty Constructor 
    public Movie() {
    	this.title="";
    	this.year=0;
    	this.price=0.0;
    }
    
    //Constructor With Arguments 
    public Movie(String title,int year,double price) {
    	this.title=title;
    	this.year=year;
    	this.price=price;
    }
    
    //Getters - Setters 
    public void setTitle(String title) {
    	 this.title=title;
    }
    
    public void setYear(int year) {
    	this.year=year;
    }
    
    public void setPrice(double price) {
    	this.price=price;
    }
    
    public String getTitle() {
    	return this.title;
    }
    
    public int getYear() {
    	return this.year;
    }
    
    public double getPrice() {
    	return this.price;
    }
    
    //Property methods for Table Factory
    public StringProperty titleProperty() {
    	return new SimpleStringProperty(this.title);
    }
    
    public StringProperty yearProperty() {
    	return new SimpleStringProperty(Integer.toString(this.year));
    }
    
    public StringProperty priceProperty() {
    	return new SimpleStringProperty(Double.toString(this.price));
    }
}
