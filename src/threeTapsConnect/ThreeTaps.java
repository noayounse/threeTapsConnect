package threeTapsConnect;

import processing.core.*;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class ThreeTaps {
	private static PApplet parent;
	  private static String base = "http://search.3taps.com";
	  private static String referenceBase = "http://reference.3taps.com";
	  private static String apiKey = "";

	  /**
	   * 
	   * @param parent_ PApplet of the Processing sketch
	   */
	  public static void init(PApplet parent_) {
	    parent = parent_;
	  } // end init

	  /**
	   * 
	   * @param apiKey_ String for your api key which can be obtained from https://3taps.com/developers-overview.php
	   */
	  public static void setAPIKey(String apiKey_) {
	    apiKey = apiKey_;
	  } // end setAPIKey

	  /**
	   * 
	   * @param query The ThreeTapsQuery to be searched
	   * @return true if the query was valid and executed properly
	   */
	  public static boolean query(ThreeTapsQuery query) {
	    boolean valid = true;
	    // add the api key
	    if (apiKey.length() <= 0) {
	      System.err.println("api key required");
	      return false;
	    }
	    String queryString = base + "?auth_token=" + apiKey;
	    queryString += (query.makeQueryString()).replace(" ", "%20");

	    try {
	      JSONObject result = parent.loadJSONObject(queryString);
	      if (result.hasKey("time_taken")) query.timeTaken = result.getFloat("time_taken");
	      if (result.hasKey("next_page")) query.nextPage = result.getInt("next_page");
	      if (query.nextPage == 0) query.isLastPage = true;
	      if (result.hasKey("num_matches")) query.numMatches = result.getInt("num_matches");
	      JSONArray resultAr = result.getJSONArray("postings");
	      if (resultAr.size() == 0) query.isLastPage = true;
	      for (int i = 0; i < resultAr.size(); i++) {
	        JSONObject obj = resultAr.getJSONObject(i);
	        ThreeTapsResult newPosting = new ThreeTapsResult();
	        if (newPosting.init(obj)) {
	          query.results.add(newPosting);
	        }
	      }
	      query.validQuery = true;
	    }
	    catch (Exception e) {
	      valid = false;
	    } 
	    return valid;
	  } // end query

	  /**
	   * Will print out the Sources available from 3Taps
	   */
	  public static void printSources() {
	    try {
	      String queryString = referenceBase + "/sources?auth_token=" + apiKey;
	      JSONObject result = parent.loadJSONObject(queryString);
	      JSONArray resultAr = result.getJSONArray("sources");
	      System.out.println("Available sources:");
	      for (int i = 0; i < resultAr.size(); i++) {
	        JSONObject j = resultAr.getJSONObject(i);
	        String code = j.getString("code");
	        String name = j.getString("name");
	        System.out.println("name: " + name + " --  code: " + code);
	      }
	    } 
	    catch (Exception e) {
	      System.out.println("error getting sources for 3Taps");
	    }
	  } // end printSources

	  /**
	   * Will print out the catetories for a given source
	   * @param source The String of the source type.  Can be found using printSources()
	   */
	  public static void printCategories(String source) {
	    if (source.length() == 0) {
	      System.out.println("error.  need to provide a valid source");
	      return;
	    }
	    try {
	      String queryString = referenceBase + "/categories?&source=" + source + "&auth_token=" + apiKey;
	      JSONObject result = parent.loadJSONObject(queryString);
	      JSONArray resultAr = result.getJSONArray("categories");
	      System.out.println("Available categories for " + source + ":");
	      for (int i = 0; i < resultAr.size(); i++) {
	        JSONObject j = resultAr.getJSONObject(i);
	        String code = j.getString("code");
	        String groupCode = j.getString("group_code");
	        String groupName = j.getString("group_name");
	        String name = j.getString("name");
	        System.out.println("name: " + name + " --  code: " + code + " -- group_code: " + groupCode + " -- group_name: " + groupName);
	      }
	    }
	    catch (Exception e) {
	      System.out.println("error getting categories for 3Taps source " + source);
	    }
	  } // end printCategories
} // end class ThreeTaps
