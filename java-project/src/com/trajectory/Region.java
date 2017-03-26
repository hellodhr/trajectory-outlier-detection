package com.trajectory;

import java.util.ArrayList;
import java.util.List;

public class Region {

	private String regionName;
	
	private Point centerRegion;
	
	private Double radius;
	
	public Region() {
		super();
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Point getCenterRegion() {
		return centerRegion;
	}

	public void setCenterRegion(Point centerRegion) {
		this.centerRegion = centerRegion;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public List<Point> getInnerPoints(Trajectory trajectory) {
		List<Point> points = new ArrayList<>();
		for(int i = 0; i < trajectory.getPoints().size(); i++) {
			double dist = this.getCenterRegion().calcDistance(trajectory.getPoints().get(i));
			if(dist < this.getRadius()) {
				points.add(trajectory.getPoints().get(i));
			}
		}
		return points;
	}
	
}
