package com.trajectory;

import java.util.ArrayList;
import java.util.List;

public class Trajectory {

	private String name;
	
	private List<Point> points;
	
	public Trajectory() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Point> getPoints() {
		if(points == null) points = new ArrayList<>();
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
}
