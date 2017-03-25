package com.trajectory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Database {

	private String path;
	
	private List<Trajectory> trajectories = new ArrayList<>();
	
	public Database(String path) {
		super();
		this.path = path;
	}
	
	public void initialize() {
		try {
			File f = new File(path);
			ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
			for(int i = 0; i < names.size(); i++) {
				Trajectory trajectory = new Trajectory();
				trajectory.setName(names.get(i));
				File file = new File(path + "/" + names.get(i));
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				boolean fileHeaderProcessed = false;
				while ((line = bufferedReader.readLine()) != null) {
					if(!fileHeaderProcessed && line.length() > 0) {
						fileHeaderProcessed = true;
					} else if(fileHeaderProcessed && line.length() > 0) {
						trajectory.getPoints().add(new Point(
							Double.valueOf(line.split(";")[0]), 
							Double.valueOf(line.split(";")[1]), 
							Double.valueOf(line.split(";")[2])));
					}
				}
				Collections.sort(trajectory.getPoints(), new Comparator<Point>() {
					@Override
					public int compare(Point o1, Point o2) {
						return (int) (o1.getTime() - o2.getTime());
					}
				});
				this.trajectories.add(trajectory);
				bufferedReader.close();
			}
		} catch (Exception e) {
			System.exit(1);
		}
	}
	
}
