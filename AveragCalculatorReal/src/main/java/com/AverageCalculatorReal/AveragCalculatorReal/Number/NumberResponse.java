package com.AverageCalculatorReal.AveragCalculatorReal.Number;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Entity
//@Table
public class NumberResponse {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    private Character ch;
    private List<Integer> windowPrevState;
    private List<Integer> windowCurState;
    private double average;

   

    public NumberResponse() {
    	
    }
	public NumberResponse(Integer number, Character ch, List<Integer> windowPrevState, List<Integer> windowCurState,
			double average) {
		super();
		this.number = number;
		this.ch = ch;
		this.windowPrevState = windowPrevState;
		this.windowCurState = windowCurState;
		this.average = average;
	}

	public Character getCh() {
		return ch;
	}

	public void setCh(Character ch) {
		this.ch = ch;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public List<Integer> getWindowPrevState() {
		return windowPrevState;
	}

	public void setWindowPrevState(List<Integer> windowPrevState) {
		this.windowPrevState = windowPrevState;
	}

	public List<Integer> getWindowCurState() {
		return windowCurState;
	}

	public void setWindowCurState(List<Integer> windowCurState) {
		this.windowCurState = windowCurState;
	}

    // Getters and Setters
}
