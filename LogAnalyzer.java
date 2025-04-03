/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author Emily Lubonty
 * @version  4-2-2025
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
                
        // Create the reader to obtain the data.
        reader = new LogfileReader(" ");
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }
    
    

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    /**
     * Prints the number of accesses during certain hours
     * 
     * @param total The total number of accesses 
     */
    public int numberOfAccesses()
    {
        int total = 0; 
        for (int hour = 0; hour < hourCounts.length; hour++){
            
            total = hourCounts[hour]; 
            
            System.out.println("Hour: " + hour +
                ".\nAccesses: " + total + ".\n"); 
        }
        return total; 
    }
    
    public int busiestHour()
    {
        int total = 0; 
        
        for (int hour  = 0; hour < hourCounts.length; hour++){  
            total = hourCounts[hour];
            
            System.out.println("Hour: " + hour + 
                ".\nAccesses: " + total + ".\n"); 
        }
        return total; 
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
