package threeTapsConnect;

import processing.data.JSONObject;

public class ThreeTapsLocation {
	public String city = "";
	public int geolocationStatus = -1;
	public String metro = "";
	public String country = "";
	public String zipcode = "";
	public float lon = 0f;
	public float lat = 0f;
	public String county = "";
	public String state = "";
	public String formattedAddress = "";
	public float accuracy = -1f;

	/**
	 * 
	 * @param obj
	 *            The JSONObject describing the Result
	 * @return true if it interpreted the obj correctly
	 */
	public boolean init(JSONObject obj) {
		boolean valid = true;
		try {
			if (obj.hasKey("city"))
				city = obj.getString("city");
			if (obj.hasKey("geolocation_status"))
				geolocationStatus = obj.getInt("geolocation_status");
			if (obj.hasKey("metro"))
				metro = obj.getString("metro");
			if (obj.hasKey("country"))
				country = obj.getString("country");
			if (obj.hasKey("zipcode"))
				zipcode = obj.getString("zipcode");
			if (obj.hasKey("long"))
				lon = obj.getFloat("long");
			if (obj.hasKey("lat"))
				lat = obj.getFloat("lat");
			if (obj.hasKey("county"))
				county = obj.getString("county");
			if (obj.hasKey("state"))
				state = obj.getString("state");
			if (obj.hasKey("formatted_address"))
				formattedAddress = obj.getString("formatted_address");
			if (obj.hasKey("accuracy"))
				accuracy = obj.getInt("accuracy");
		} catch (Exception e) {
			valid = false;
		}
		return valid;
	} // end init

	/**
	 * 
	 * @return the String describing the Location
	 */
	public String toString() {
		String builder = "location: \n";
		builder += " city: " + city + "\n";
		builder += " geolocationStatus: " + geolocationStatus + "\n";
		builder += " metro: " + metro + "\n";
		builder += " zipcode: " + zipcode + "\n";
		builder += " lon: " + lon + "\n";
		builder += " lat: " + lat + "\n";
		builder += " county: " + county + "\n";
		builder += " state: " + state + "\n";
		builder += " formattedAddress: " + formattedAddress + "\n";
		builder += " accuracy: " + accuracy;
		return builder;
	} // end toString

} // end class ThreeTapsLocation
