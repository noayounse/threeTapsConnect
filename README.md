ThreeTapsP5
===========

3Taps + Processing




Some quick instructions

// import the library<br>
import threeTapsConnect.*; 

// initiate it in the setup() <br>
ThreeTaps.init(this); 

// set the API key. get one from here <br>
ThreeTaps.setAPIKey("INSERT API KEY HERE"); 

// make a new ThreeTapsQuery object <br>
ThreeTapsQuery query = new ThreeTapsQuery(); 

// the basic search params. see the docs and/or example for more details 
query.setRPP(2); // the count 
query.setHeading("\"mountain bike\""); 
query.setLat(37.77); // latitude 
query.setLon(-122.427); // longitude 
query.hasImage(true); 
// distance only works when lat and lon are set query.setSortMode(query.DISTANCE); 

// perform the query 
ThreeTaps.query(query); 

// extract the ThreeTapsResult and ThreeTapsLocation objects 
for (ThreeTapsResult result : query.results) {
  println(result);
//if the ThreeTapsResult has a valid location, that will be stored in the location object
  if (result.location != null) print(result.location); 
} 
