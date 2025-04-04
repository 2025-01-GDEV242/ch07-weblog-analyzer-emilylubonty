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
                "\nAccesses: " + total + "\n"); 
        }
        return total; 
    }
    
    /**
     * Prints the busiest hour with number of accesses.
     * 
     * @param total Total number of accesses
     * @param displayHour Display hour in string/print statement
     */
    public int busiestHour()
    {
        int total = hourCounts[0];
        int displayHour = 0; 
        
        for (int hour = 1; hour < hourCounts.length; hour++){
            if (total < hourCounts[hour]){ 
                displayHour = hour; 
                total = hourCounts[hour];
            }
        }
        System.out.println("The busiest hour was " + displayHour + 
                            " with " + total + " accesses.");
    
        return total;
    }
    
    /**
     * Displays the busiest hours within a two hour frame. 
     * 
     * @param total Total number of accesses
     * @param displayHour Display first hour within string/print statement
     * @param secondHour Display the second hour within string/print statement
     */
    public int busiestTwoHour()
    {
        int total = hourCounts[0]; 
        int secondTotal = hourCounts[0];
        int displayHour = 0; 
        int secondHour = 0;
        
        for (int hour = 0 + 1; hour < hourCounts.length; hour++){
            if (total < hourCounts[hour]){ 
                displayHour = hour; 
                secondHour = displayHour + 1;
                total = hourCounts[hour] + secondTotal;
            }
        }
        System.out.println("The busiest two hours were between " + displayHour + " and " + secondHour 
                            + " with " + total + " total accesses.");
        
        return total; 
    }
    
    /**
     * Displays the quietest hour with total number of accesses.
     * 
     * @param total Total number of accesses
     * @param displayHour Display hour in string/print statement
     */
    public int quietestHour()
    { 
        int total = hourCounts[0];
        int displayHour = 0; 
        
        for (int hour = 1; hour < hourCounts.length; hour++){
            if (total > hourCounts[hour]){ 
                displayHour = hour; 
                total = hourCounts[hour];
            }      
        }
        System.out.println("The quietest hour was " + displayHour + 
                            " with " + total + " accesses.");
                            
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
