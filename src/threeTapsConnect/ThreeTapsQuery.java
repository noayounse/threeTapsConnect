package threeTapsConnect;

import java.util.ArrayList;

/**
 * see http://docs.3taps.com/search_api.html for more details
 * 
 * 
 */

public class ThreeTapsQuery {

	// about the query
	public boolean validQuery = false;
	public float timeTaken = 0f;
	public int nextPage = -1; // will be 0 when at end
	public boolean isLastPage = false;
	public int numMatches = 0;
	public ArrayList<ThreeTapsResult> results = new ArrayList<ThreeTapsResult>();

	// query variables:
	//
	//
	public final int BLANK = -1;

	// source
	public String source = "CRAIG";

	// category
	public String category = "";

	// booleans
	public int hasImage = -1;
	public int hasPrice = -1;
	public int includeDeleted = -1;
	public int onlyDeleted = -1;

	// rpp
	public int rpp = -1;
	// page
	public int page = -1;

	// text
	public String body = ""; // words in body
	public String text = ""; // words in head or body
	public String heading = ""; // words in the heading

	/**
	 * Set the timestamp something like this: 2013-03-27 12:34:56
	 */
	public String minTimestamp = "";

	public String maxTimestamp = "";

	// geo
	public float lat = -1000;
	public float lon = -1000;
	public float radius = -1000;
	/**
	 * can be ft, m, mi, km
	 */
	public String radiusUnits = "mi";

	// status
	public final int REGISTERED = 12;
	public final int FOR_SALE = 13;
	public final int FOR_HIRE = 14;
	public final int FOR_RENT = 15;
	public final int WANTED = 16;
	public final int LOST = 17;
	public final int STOLEN = 18;
	public final int FOUND = 19;
	public int status = BLANK;

	// state
	public final int AVAILABLE = 21;
	public final int UNAVAILABLE = 22;
	public final int EXPIRED = 23;
	public int state = BLANK;

	// sort modes
	public final int TIMESTAMP = 0;
	public final int MINUS_TIMESTAMP = 1;
	public final int PRICE = 2;
	public final int MINUS_PRICE = 3;
	public final int DISTANCE = 4;
	public int sortMode = BLANK;

	//
	public void ThreeTapQuery() {
	} // end constructor

	/**
	 * 
	 * @return a copy of this query minus the results
	 */
	public ThreeTapsQuery get() {
		ThreeTapsQuery newQuery = new ThreeTapsQuery();
		newQuery.nextPage = this.nextPage;
		newQuery.isLastPage = this.isLastPage;
		newQuery.category = this.category;
		newQuery.source = this.source;
		newQuery.hasImage = this.hasImage;
		newQuery.hasPrice = this.hasPrice;
		newQuery.includeDeleted = this.includeDeleted;
		newQuery.onlyDeleted = this.onlyDeleted;
		newQuery.rpp = this.rpp;
		newQuery.page = this.page;
		newQuery.body = this.body;
		newQuery.text = this.text;
		newQuery.heading = this.heading;
		newQuery.minTimestamp = this.minTimestamp;
		newQuery.maxTimestamp = this.maxTimestamp;
		newQuery.lat = this.lat;
		newQuery.lon = this.lon;
		newQuery.radius = this.radius;
		newQuery.radiusUnits = this.radiusUnits;
		newQuery.status = this.status;
		newQuery.state = this.state;
		newQuery.sortMode = this.sortMode;
		return newQuery;
	} // end get

	/**
	 * This is the overall Source used for the query. See
	 * ThreeTaps.printSources() to get a list of all available sources default
	 * is CRAIG for craigslist
	 * 
	 * @param source_
	 */
	public void setSource(String source_) {
		source = source_;
	} // end setSource

	/**
	 * See ThreeTaps.printCategories(String source) for a list of categories for this source
	 * @param category_
	 */
	public void setCategory(String category_) {
		category = category_;
	} // end setCategory

	/**
	 * The number of results to return per page. Should be between 1 and 100
	 * 
	 * @param rpp_
	 */
	public void setRPP(int rpp_) {
		rpp = rpp_;
		if (rpp < 1 || rpp > 100) {
			System.err.println("rpp must be between 1 and 100");
			if (rpp < 1)
				rpp = 1;
			else if (rpp > 100)
				rpp = 100;
		}
	} // end setRPP

	/**
	 * The page of results to return. Default will be page 0
	 * 
	 * @param page_
	 */
	public void setPage(int page_) {
		page = page_;
	} // end setPage

	/**
	 * For searching for text within the body only
	 * 
	 * @param body_
	 */
	public void setBody(String body_) {
		body = body_;
	} // end setBody

	/**
	 * For searching for text within the heading only
	 * 
	 * @param heading_
	 */
	public void setHeading(String heading_) {
		heading = heading_;
	} // end setHeading

	/**
	 * For searching for text within the heading and/or the body
	 * 
	 * @param text_
	 */
	public void setText(String text_) {
		text = text_;
	} // end setText

	/**
	 * 
	 * Set the timestamp something like this: 2013-03-27 12:34:56 or you can use
	 * a unix time version like this: 1392694333
	 * 
	 * @param minTimestamp_
	 */
	public void setMinTimestamp(String minTimestamp_) {
		minTimestamp = minTimestamp_;
	} // end setMinTimeStamp

	public void setMaxTimestamp(String maxTimestamp_) {
		maxTimestamp = maxTimestamp_;
	} // end setMaxTimestamp

	//
	public void setLat(float lat_) {
		lat = lat_;
	} // end setLat

	//
	public void setLon(float lon_) {
		lon = lon_;
	} // end setLon

	/**
	 * This will only work if a lat and lon are specified
	 * 
	 * @param radius_
	 *            The numerical value
	 * @param radiusUnits_
	 *            The units - can be ft, m, mi, or km
	 */
	public void setRadius(float radius_, String radiusUnits_) {
		radius = radius_;
		radiusUnits = radiusUnits_;
	} // end setRadius

	/**
	 * See constants for options
	 * 
	 * @param status_
	 */
	public void setStatus(int status_) {
		status = status_;
	} // end setStatus

	/**
	 * See constants for options
	 * 
	 * @param state_
	 */
	public void setState(int state_) {
		state = state_;
	} // end setState

	/**
	 * Set to true to restrict to postings with a pic. set to false to restrict
	 * to posting without a pic leave alone to get both
	 * 
	 * @param does
	 */
	public void hasImage(boolean does) {
		hasImage = (does ? 1 : 0);
	} // end hasImage

	/**
	 * Set to true to restrict to postings with a price. set to false to
	 * restrict to posting without a price leave alone to get both
	 * 
	 * @param does
	 */
	public void hasPrice(boolean does) {
		hasPrice = (does ? 1 : 0);
	} // end hasPrice

	/**
	 * Prettymuch the same concept as hasImage() and hasPrice()
	 * 
	 * @param does
	 */
	public void includeDeleted(boolean does) {
		includeDeleted = (does ? 1 : 0);
	} // end includeDeleted

	public void onlyDeleted(boolean does) {
		onlyDeleted = (does ? 1 : 0);
	} // end onlyDeleted

	/**
	 * See sort mode constants for options If using distance then the lat and
	 * lon must be specified
	 * 
	 * @param sortMode_
	 */
	public void setSortMode(int sortMode_) {
		sortMode = sortMode_;
	} // end setSortMode

	/**
	 * 
	 * @return the String for the Query
	 */
	public String makeQueryString() {
		String query = "";

		// category
		if (category.length() > 0) {
			query += "&category=" + category;
		}

		// deal with source
		if (source.length() > 0) {
			query += "&source=" + source;
		}

		// and rpp
		if (rpp >= 0) {
			query += "&rpp=" + rpp;
		}

		if (page >= 0) {
			query += "&page=" + page;
		}

		// deal with text
		if (text.length() > 0) {
			query += "&text=" + text;
		}
		// heading
		if (heading.length() > 0) {
			query += "&heading=" + heading;
		}
		// body
		if (body.length() > 0) {
			query += "&body=" + body;
		}

		// deal with timestamps
		if (minTimestamp.length() > 0 || maxTimestamp.length() > 0) {
			query += "&timestamp=";
			query += minTimestamp + ".." + maxTimestamp;
		}

		// deal with status
		if (status != BLANK) {
			query += "&status=";
			switch (state) {
			case REGISTERED:
				query += "registered";
				break;
			case FOR_SALE:
				query += "for_sale";
				break;
			case FOR_HIRE:
				query += "for_hire";
				break;
			case FOR_RENT:
				query += "for_rent";
				break;
			case WANTED:
				query += "wanted";
				break;
			case LOST:
				query += "lost";
				break;
			case STOLEN:
				query += "stolen";
				break;
			case FOUND:
				query += "found";
				break;
			default:
				query += "for_sale";
			}
		}

		// deal with state
		if (state != BLANK) {
			query += "&state=";
			switch (state) {
			case AVAILABLE:
				query += "available";
				break;
			case UNAVAILABLE:
				query += "unavailable";
				break;
			case EXPIRED:
				query += "expired";
				break;
			default:
				query += "available";
			}
		}

		// booleans
		if (hasImage != -1)
			query += "&has_image=" + hasImage;
		if (hasPrice != -1)
			query += "&has_price=" + hasPrice;
		if (includeDeleted != -1)
			query += "&include_deleted=" + includeDeleted;
		if (onlyDeleted != -1)
			query += "&only_deleted=" + onlyDeleted;

		// lat lon
		if (lat != -1000)
			query += "&lat=" + lat;
		if (lon != -1000)
			query += "&long=" + lon;

		// deal with radius
		if (radius != -1000) {
			if (lat != -1000 && lon != -1000) {
				query += "&radius=" + radius + radiusUnits;
			}
		}

		// deal with sorts
		if (sortMode != BLANK) {
			query += "&sort=";
			switch (sortMode) {

			case TIMESTAMP:
				query += "timestamp";
				break;
			case MINUS_TIMESTAMP:
				query += "-timestamp";
				break;
			case PRICE:
				query += "price";
				break;
			case MINUS_PRICE:
				query += "-price";
				break;
			case DISTANCE:
				if (lat != -1000 && lon != -1000) {
					query += "distance";
				} else
					query += "timestamp";
				break;
			default:
				query += "timestamp";
			} // end switch
		}

		return query;
	} // end makeQueryString

	/**
	 * 
	 * @return the String describing the Query
	 */
	public String toString() {
		String builder = "query: " + makeQueryString() + "\n";
		builder += " valid: " + validQuery + "\n";
		builder += " timeTaken: " + timeTaken + "\n";
		builder += " nextPage: " + nextPage + "\n";
		builder += " isLastPage: " + isLastPage + "\n";
		builder += " numMatches: " + numMatches + "\n";
		builder += " minTimestamp: " + minTimestamp + "\n";
		builder += " maxTimestamp: " + maxTimestamp + "\n";
		builder += " results.size(): " + results.size();
		return builder;
	} // end getInfo
} // end class ThreeTapsQuery
