package main.java.io_pack;

import java.io.File;
import java.io.FileNotFoundException;

import de.micromata.opengis.kml.v_2_2_0.*;
import main.java.data_classes.Samples;

public class WriteToKml {
	/**
	 * This class writes a kml file.
	 * @param Samples, String
	 * recieves Sampled object and a String,
	 * and writing the data from the Samples object to a kml file (using the JAK jars from the below link)
	 * taken from:
	 * https://labs.micromata.de/projects/jak/quickstart.html
	 * 
	 */
	private static Samples samples;
	private static Kml kml; 
	
	public static void write(Samples samp, String s){
		if(samp.length()==0)
			return;
		samples = samp;
		kml = new Kml();
		Document document = kml.createAndSetDocument();
		for (int i = 0; i < samples.length(); i++) {
				Placemark place = document.createAndAddPlacemark().withName(samples.getName(i)).withOpen(Boolean.TRUE);
				place.withDescription("<![CDATA[BSSID: <b>"+samples.getMac(i)+"</b><br/>Capabilities: <b>SECURITY</b><br/>Frequency: <b>"+samples.getFreq(i)+"</b><br/>Timestamp: <b>1509528977000</b><br/>Date: <b>"+samples.getDate(i)+"</b>]]>")
			   .createAndSetPoint().addToCoordinates(samples.getPosition(i).PostoKml());
				place.createAndSetTimeStamp().withWhen(samples.getTimestamp(i));
		}
		kml.setFeature(document);
		try {
			kml.marshal(new File(s));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
