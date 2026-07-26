import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    
    // Helper class to store where and when a passenger checked in
    class CheckIn {
        String station;
        int time;
        
        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
    
    // Helper class to track the total time and number of trips for a specific route
    class RouteData {
        double totalTime = 0;
        int count = 0;
    }

    // Maps Passenger ID -> CheckIn info
    private Map<Integer, CheckIn> activeTrips;
    
    // Maps Route (e.g., "StationA-StationB") -> RouteData info
    private Map<String, RouteData> completedTrips;

    public UndergroundSystem() {
        activeTrips = new HashMap<>();
        completedTrips = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        // Record the check-in details for this passenger
        activeTrips.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // 1. Get the check-in data and remove them from active trips
        CheckIn startData = activeTrips.remove(id);
        
        // 2. Create a unique string for the route
        String route = startData.station + "-" + stationName;
        
        // 3. Calculate travel time
        int travelTime = t - startData.time;
        
        // 4. Update the route statistics (create new RouteData if it doesn't exist yet)
        RouteData stats = completedTrips.getOrDefault(route, new RouteData());
        stats.totalTime += travelTime;
        stats.count += 1;
        
        completedTrips.put(route, stats);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        // Retrieve the stats for the requested route and calculate the average
        String route = startStation + "-" + endStation;
        RouteData stats = completedTrips.get(route);
        
        return stats.totalTime / stats.count;
    }
}