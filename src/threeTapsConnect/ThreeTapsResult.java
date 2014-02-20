package threeTapsConnect;

import processing.data.JSONObject;

public class ThreeTapsResult {

	public String category = "";
	public long timeStamp = 0;
	public long id = 0;
	public String source = "";
	public String externalId = "";
	public String heading = "";
	public String externalURL = "";

	public ThreeTapsLocation location = null;

/**
 * 
 * @param obj The JSONObject describing the Result
 * @return true if it interpreted the obj correctly
 */
	public boolean init(JSONObject obj) {
		boolean valid = true;
		try {
			if (obj.hasKey("category"))
				category = obj.getString("category");
			if (obj.hasKey("timestamp"))
				timeStamp = obj.getLong("timestamp");
			if (obj.hasKey("id"))
				id = obj.getLong("id");
			if (obj.hasKey("source"))
				source = obj.getString("source");
			if (obj.hasKey("external_id"))
				externalId = obj.getString("external_id");
			if (obj.hasKey("heading"))
				heading = obj.getString("heading");
			if (obj.hasKey("external_url"))
				externalURL = obj.getString("external_url");
			if (obj.hasKey("location")) {
				location = new ThreeTapsLocation();
				if (!location.init(obj.getJSONObject("location"))) {
					location = null;
				}
			}
		} catch (Exception e) {
			valid = false;
		}
		return valid;
	} // end init

	/**
	 * 
	 * @return the String describing the Result
	 */
	public String toString() {
		String builder = "result: \n";
		builder += " category: " + category + "\n";
		builder += " timeStamp: " + timeStamp + "\n";
		builder += " id: " + id + "\n";
		builder += " source: " + source + "\n";
		builder += " externalId: " + externalId + "\n";
		builder += " heading: " + heading + "\n";
		builder += " externalURL: " + externalURL;
		return builder;
	} // end toString

} // end class ThreeTapsResult
