package fr.keymaze.connect.back.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.keymaze.connect.back.model.Activity;
import fr.keymaze.connect.back.model.WayPoint;

public class GhdReader {

	private final File inputFile;
	private final Activity activity;
	//private DateTime dateTime;
	//private static final Logg

	public GhdReader(File inputFile) {
		super();
		this.inputFile = inputFile;
		this.activity = new Activity();
	}

	public Activity readFile() throws KeyMazeException {
		FileInputStream fis = null;
		FileChannel channel = null;
		try {
			fis = new FileInputStream(inputFile);
			channel = fis.getChannel();
			final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(Long
					.valueOf(inputFile.length()).intValue());
			byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
			channel.read(byteBuffer);
			byteBuffer.rewind();
			readActivity(byteBuffer);
			byteBuffer.rewind();
		} catch (IOException e) {
			//Logger.error("Erreur IO", e);
			throw new KeyMazeException(e);
		} finally {
			try {
				if (channel != null && channel.isOpen()) {
					channel.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				//Logger.error("Erreur IO", e);
				throw new KeyMazeException(e);
			}

		}
		return activity;
	}

	private void readActivity(ByteBuffer byteBuffer) {
		activity.keymazeId = readString(byteBuffer, 12);
		activity.nbTracks = (int) byteBuffer.get();
		activity.keymazeFileName = readString(byteBuffer, 65);
		activity.trackName = readString(byteBuffer, 64);
		activity.startDate = readDate(byteBuffer);
		activity.duration = (long) byteBuffer.getInt() * 100;
		activity.distance = Integer.valueOf(byteBuffer.getInt()).doubleValue() / 1000d;
		byteBuffer.getInt();
		byteBuffer.getShort();
		byteBuffer.getShort();
		// System.out.println("Inconnue null: " + byteBuffer.getInt());
		// System.out.println("Buffer position : " + byteBuffer.position());
		// System.out.println("Inconnue: " + byteBuffer.getShort());
		// System.out.println("Buffer position : " + byteBuffer.position());
		// System.out.println("Inconnu : " + byteBuffer.getShort());
		// System.out.println("Buffer position : " + byteBuffer.position());
		activity.maxSpeed = Short.valueOf(byteBuffer.getShort()).doubleValue() / 100d;
		activity.maxHeartRate = byteBuffer.getShort();
		activity.avgHeartRate = byteBuffer.getShort();
		activity.dPlus = byteBuffer.getShort();
		activity.dMinus = byteBuffer.getShort();
		activity.minHeartRate = byteBuffer.getShort();
		activity.avgSpeed = byteBuffer.getInt() / 100d;
		activity.avgAlt = byteBuffer.getShort();
		activity.ascSpeed = byteBuffer.getInt() / 100d;
		byteBuffer.get();
		byteBuffer.getInt();
		byteBuffer.getInt();
		byteBuffer.getInt();
		// System.out.println("Inconnu : " + (int) byteBuffer.get());
		// System.out.println("Buffer position : " + byteBuffer.position());
		// System.out.println("Inconnu : " + byteBuffer.getInt());
		// System.out.println("Buffer position : " + byteBuffer.position());
		// System.out.println("Inconnu : " + byteBuffer.getInt());
		// System.out.println("Buffer position : " + byteBuffer.position());
		// System.out.println("Inconnu : " + byteBuffer.getInt());
		// System.out.println("Buffer position : " + byteBuffer.position());
		activity.calories = byteBuffer.getShort();
		activity.maxSpeed = byteBuffer.getShort() / 100d;
		byteBuffer.getInt();
		byteBuffer.getShort();
		// System.out.println("Inconnu : " + byteBuffer.getInt());
		// System.out.println("Buffer position : " + byteBuffer.position());
		// System.out.println("Inconnu : " + byteBuffer.getShort());
		// System.out.println("Buffer position : " + byteBuffer.position());
		short nbPoints = byteBuffer.getShort();
		final List<WayPoint> wayPointList = new ArrayList<WayPoint>();
		// On parse les points
		// System.out
		// .println("================================ POINTS ======================");
		for (int i = 0; i < nbPoints; i++) {
			wayPointList.add(readWayPoint(byteBuffer, i));
			// System.out.println("Pt"+i+" Lat : "+latitude+" Lon : "+longitude+" Alt : "+altitude+" time : "+temps+" cardio : "+cardio+" vitesse : "+speed);
		}
		activity.wayPoints = wayPointList;
		if (wayPointList != null && wayPointList.size() > 0) {
			activity.latitude = wayPointList.get(0).latitude;
			activity.longitude = wayPointList.get(0).longitude;
		}
		// System.out.println("Index " + byteBuffer.position() + "/"
		// + byteBuffer.capacity());

	}

	private WayPoint readWayPoint(ByteBuffer byteBuffer, int order) {
		final WayPoint wayPoint = new WayPoint();
		wayPoint.activity = activity;
		wayPoint.ordre = order;
		wayPoint.latitude = Integer.valueOf(byteBuffer.getInt()).doubleValue() / 1000000d;
		wayPoint.longitude = Integer.valueOf(byteBuffer.getInt()).doubleValue() / 1000000d;
		wayPoint.altitude = byteBuffer.getShort();
//		dateTime = dateTime.plusSeconds(byteBuffer.getShort());
//		wayPoint.time = dateTime.getMillis();
		wayPoint.heartRate = byteBuffer.getShort();
		wayPoint.speed = byteBuffer.getShort();
		return wayPoint;
	}

	private Date readDate(ByteBuffer byteBuffer) {
		int startYear = 2000 + (int) byteBuffer.get();
		int startMonth = (int) byteBuffer.get();
		int startDay = (int) byteBuffer.get();
		int startHour = (int) byteBuffer.get();
		int startMinute = (int) byteBuffer.get();
		int startSec = (int) byteBuffer.get();
//		dateTime = new DateTime();
//		dateTime = dateTime.withYear(startYear);
//		dateTime = dateTime.withMonthOfYear(startMonth);
//		dateTime = dateTime.withDayOfMonth(startDay);
//		dateTime = dateTime.withHourOfDay(startHour);
//		dateTime = dateTime.withMinuteOfHour(startMinute);
//		dateTime = dateTime.withSecondOfMinute(startSec);
//		return dateTime.toDate();
		return null;
	}

	private String readString(ByteBuffer byteBuffer, int length) {
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			bytes[i] = byteBuffer.get();
		}
		return new String(bytes);
	}
}
