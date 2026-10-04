import java.util.*; 
import java.io.*;


public class BTMethods {
    public int[] BestTrading(int[] p, int low, int high) throws Exception{

        // Used a variable to more clearly represent what is at index 2 when comparing later
        int profitIndex = 2;

        if(low > high){
            throw new Exception("Error: low > high, " + low + " > " + high);
        }

        if (low == high){
            int[] res = {low, high, 0};
            return res;
        }

        int mid = (low +high)/2;
        int[] c1 = BestTrading(p,low, mid);// Left of mid point of the array
        int[] c2 = BestTrading(p, mid + 1, high);// Left of mid point of the array
        int[] c3 = BestTradingAcross(p, low, high);// Left of mid point of the array


        // Checks the largest profit number and returns it
        if(c1[profitIndex] >= c2[profitIndex] && c1[profitIndex] >= c3[profitIndex])return c1;
        else if (c2[profitIndex] >= c1[profitIndex] && c2[profitIndex] >= c3[profitIndex]) return c2;
        else return c3;

    }

    public int[] BestTradingAcross(int[] p, int low, int high) throws Exception{

        if (low > high){
            throw new Exception("Error: low > high, " + low + " > " + high);

        }

        int mid = (low + high) / 2;

        int x = low;//Lowest value index

        // Starts at low and makes its way to the mid
        for (int i = low; i <= mid; i++){
            if (p[i] < p[x]){
                x = i;
            }
        }

        int y = high;// Highest value index

        // Starts at high and makes its way to the mid + 1
        for (int j = high; j >= mid + 1; j--){
            if (p[j] > p[y])
                y = j;
        }

        // Result is the smalest index, largest index, and the profit from them
        int[] res = {x, y, p[y] - p[x]};

        return res;
    }

    public int[] FillArray(String fileName)throws FileNotFoundException{
        File file = new File(fileName);

        // Check if file exists
        if (!file.exists()){
            throw new FileNotFoundException("File <" + file + "> not found");
        }
        Scanner scanner = new Scanner(file);

        //--- Find the size of the array ---//
        int count = 0;
        while (scanner.hasNext()){
            // only increase count if it has a double
            // skip any none doubles
            // scanner views integers as a double
            if(scanner.hasNextInt()) {
                count += 1;
                scanner.next();
            }
            // If not double then move to the next line
            else scanner.next();// consume the none double value
        }

        // Reset the scanner
        scanner.close();
        scanner = new Scanner(file);

        // Make a new array the size of count found above
        int[] array = new int[count];

        // reset count to be used as the index to add to the new array below
        count = 0;

        // look through the file again to fill out the array
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                array[count] = scanner.nextInt();
                count += 1;
            }
            // If not double then move to the next line
            else scanner.next();// consume the none double value
        }

        scanner.close();
        return array;// return the new array
    
    }
}