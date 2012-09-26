package fr.keymaze.connect.back.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String fileName;
	private Date startDate;
	private Long duration;
	private Double distance;
	private Double avgSpeed;
	private Double maxSpeed;
	private Short avgAlt;
	private Double ascSpeed;
	private Short dPlus;
	private Short dMinus;
	private Short calories;
	private Short avgHeartRate;
	private Short minHeartRate;
	private Short maxHeartRate;
	private Integer nbTracks;
	private String trackName;
	private String comment;
	private String title;
	private Boolean isPrivate;
	private Double latitude;
	private Double longitude;
	
	
	private List<WayPoint> wayPoints;
	
	private User author;
	
	private ActivityType type;

	public String geId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public Double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Short getAvgAlt() {
		return avgAlt;
	}

	public void setAvgAlt(Short avgAlt) {
		this.avgAlt = avgAlt;
	}

	public Double getAscSpeed() {
		return ascSpeed;
	}

	public void setAscSpeed(Double ascSpeed) {
		this.ascSpeed = ascSpeed;
	}

	public Short getdPlus() {
		return dPlus;
	}

	public void setdPlus(Short dPlus) {
		this.dPlus = dPlus;
	}

	public Short getdMinus() {
		return dMinus;
	}

	public void setdMinus(Short dMinus) {
		this.dMinus = dMinus;
	}

	public Short getCalories() {
		return calories;
	}

	public void setCalories(Short calories) {
		this.calories = calories;
	}

	public Short getAvgHeartRate() {
		return avgHeartRate;
	}

	public void setAvgHeartRate(Short avgHeartRate) {
		this.avgHeartRate = avgHeartRate;
	}

	public Short getMinHeartRate() {
		return minHeartRate;
	}

	public void setMinHeartRate(Short minHeartRate) {
		this.minHeartRate = minHeartRate;
	}

	public Short getMaxHeartRate() {
		return maxHeartRate;
	}

	public void setMaxHeartRate(Short maxHeartRate) {
		this.maxHeartRate = maxHeartRate;
	}

	public Integer getNbTracks() {
		return nbTracks;
	}

	public void setNbTracks(Integer nbTracks) {
		this.nbTracks = nbTracks;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public List<WayPoint> getWayPoints() {
		return wayPoints;
	}

	public void setWayPoints(List<WayPoint> wayPoints) {
		this.wayPoints = wayPoints;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}
	
	
	
		
		
}
