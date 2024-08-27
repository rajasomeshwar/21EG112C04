package com.AverageCalculatorReal.AveragCalculatorReal.Test;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class NumberResponse {

	List<Integer> number;
	public NumberResponse() {
		
	}
	public NumberResponse(List<Integer> number) {
		super();
		this.number = number;
	}

	public List<Integer> getNumber() {
		return number;
	}

	public void setNumber(List<Integer> number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "NumberResponse [number=" + number + "]";
	}

  
}
