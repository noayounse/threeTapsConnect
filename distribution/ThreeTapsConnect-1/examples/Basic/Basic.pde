// import the library
import threeTapsConnect.*;

void setup() {
  // initiate the library
  ThreeTaps.init(this);

  // get an api key from here:
  // https://3taps.com/developers-overview.php
  ThreeTaps.setAPIKey("INSERT API KEY HERE");

  // make a new query
  ThreeTapsQuery query = new ThreeTapsQuery();
  // the different available params
  // NOTE: they don't all have to be filled out
  query.setSource("CRAIG"); // use ThreeTaps.printSources() to list available sources
  query.setCategory("SBIK"); // use ThreeTaps.printCategories(String source) to list available categories
  query.setRPP(2); // the number of results.  from 1 to 100
  query.setPage(3); // jump to a specified page of results
  query.setBody("bike"); // text in the body of the post
  query.setHeading("mountain"); // text in the heading of the post
  query.setText("bike"); // text in either the body or the heading
  // either one or both min and max timestamps can be set
  query.setMinTimestamp("2013-01-10 12:00:00"); 
  query.setMaxTimestamp("2014-12-10 12:00:00");
  query.setLat(37.77); // latitude
  query.setLon(-122.427); // longitude
  query.setRadius(135, "km"); // will only work when lat and lon are set.  "mi", "km", "ft", "m"
  query.setStatus(query.FOR_SALE); 
  // other options include REGISTERED, FOR_HIRE, FOR_RENT, WANTED, LOST, STOLEN, and FOUND
  //query.setState(query.AVAILABLE);
  // other options include UNAVAILABLE, and EXPIRED
  // if these booleans arent set then both true/false will be included 
  query.hasImage(true);
  query.hasPrice(true);
  query.includeDeleted(true); 
  query.setSortMode(query.DISTANCE); // distance only works when lat and lon are set
  // other options include TIMESTAMP, MINUS_TIMESTAMP, PRICE, and MINUS_PRICE

  // to actually perform a search run the query through the ThreeTaps.query(ThreeTapsQuery query)  
  ThreeTaps.query(query);
  println("\n\n___\n");
  println(query);
  println("\n\n___\n");
  
  // the ThreeTapsQuery object holds all of the ThreeTapsResult objects in the ArrayList named results
  for (ThreeTapsResult result : query.results) {
    println(result);
    // if the ThreeTapsResult has a valid location, that will be stored in the location object
    if (result.location != null) {
      print(result.location);
    }
    println("\n\n___\n");
  }

  exit();
} // end setup

