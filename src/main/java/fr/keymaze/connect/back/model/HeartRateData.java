package fr.keymaze.connect.back.model;


public class HeartRateData {
	
	public Long time;
	public Short heartRate;
	public Short altitude;
	
//	public static List<HeartRateData> getHeartRateData(Long activityId){
//		return find("Select time, heartRate, altitude from WayPoint where activity_id = ? and MOD(ordre,10) = 0 order by ordre", activityId).fetch();
//	}

}
