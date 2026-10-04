import java.util.*;


public class BestTrading {

    public static void main(String args[]){

        BTMethods bt = new BTMethods();

        try{

        int[] prices = bt.FillArray("data.txt");
        System.out.println(Arrays.toString(prices) + " Low: " + 0 + " High: " + (prices.length - 1));

        // Output array
        // Index 
        // 0 = buy day
        // 1 = sell day
        // 2 = profit max
        int[] res = bt.BestTrading(prices, 0, prices.length - 1); 

        System.out.print(Arrays.toString(res));
        
       }catch(Exception e){
        System.out.print(e.getMessage());
       }
    }
}