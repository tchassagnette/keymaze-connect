package fr.keymaze.connect.back.model;

import java.util.Date;
import java.util.List;

public class Activity {

	public String keymazeId;
	public String keymazeFileName;
	public Date startDate;
	public Long duration;
	public Double distance;
	public Double avgSpeed;
	public Double maxSpeed;
	public Short avgAlt;
	public Double ascSpeed;
	public Short dPlus;
	public Short dMinus;
	public Short calories;
	public Short avgHeartRate;
	public Short minHeartRate;
	public Short maxHeartRate;
	public Integer nbTracks;
	public String trackName;
	public String comment;
	public String title;
	public Boolean isPrivate;
	public Double latitude;
	public Double longitude;
	
	
	public List<WayPoint> wayPoints;
	
	public User author;
	
	public ActivityType type;
		
		
}
