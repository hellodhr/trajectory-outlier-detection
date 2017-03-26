package com.trajectory;

import java.util.List;

public class App {

	public static void main(String[] args) {
		Database database = new Database("/home/joao/Área de Trabalho/Mestrado/TRA-SOD/trajectories");
		database.initialize();
		
		Region R1 = new Region();
		Point pR1 = new Point();
		System.out.println("drawCircle(-26.478050,-49.049860,0.001)");
		pR1.setLat(-26.478050);
		pR1.setLng(-49.049860);
		R1.setCenterRegion(pR1);
		R1.setRadius(0.001);
		Region R2 = new Region();
		Point pR2 = new Point();
		System.out.println("drawCircle(-26.481044, -49.085520,0.001)");
		//pR2.setLat(-26.479120);
		//pR2.setLng(-49.089040);
		pR2.setLat(-26.481044);
		pR2.setLng(-49.085520);
		R2.setCenterRegion(pR2);
		R2.setRadius(0.001);
		
		List<Trajectory> trajectories = database.findTrajectoriesInRegions(R1, R2);
		
		for(Trajectory traj : trajectories) {
			System.out.println("drawPoints([");
			for(int i = 0; i < traj.getPoints().size(); i++) {
				System.out.print("{ lat: " + traj.getPoints().get(i).getLat() + ", lng: " + traj.getPoints().get(i).getLng());
				if(i != traj.getPoints().size() - 1) {
					System.out.println(" },");
				} else {
					System.out.println(" }");
				}
			}
			System.out.println("]);");
		}
		
	}

}
