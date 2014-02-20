ThreeTapsP5
===========

3Taps + Processing




Some quick instructions

// import the library<br>
import threeTapsConnect.*; 

// initiate it in the setup() <br>
ThreeTaps.init(this); 

// set the API key. get one from <a href="https://developer.3taps.com/signup">3taps.com</a> <br>
ThreeTaps.setAPIKey("INSERT API KEY HERE"); 

// make a new ThreeTapsQuery object <br>
ThreeTapsQuery query = new ThreeTapsQuery(); 

// the basic search params. see the docs and/or example for more details <br>
query.setRPP(2); // the count <br>
query.setHeading("\"mountain bike\""); <br>
query.setLat(37.77); // latitude <br>
query.setLon(-122.427); // longitude <br>
query.hasImage(true); <br>
// distance only works when lat and lon are set <br>
query.setSortMode(query.DISTANCE); 

// perform the query <br>
ThreeTaps.query(query); 

// extract the ThreeTapsResult and ThreeTapsLocation objects <br>
for (ThreeTapsResult result : query.results) {<br>
  println(result);<br>
//if the ThreeTapsResult has a valid location, that will be stored in the location object<br>
  if (result.location != null) print(result.location); <br>
} 
