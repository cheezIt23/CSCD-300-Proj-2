import java.util.*;


public class BestTrading {

    public static void main(String args[]){

        BTMethods bt = new BTMethods();

        try{
        int[] prices = bt.FillArray(args[0]);

        // Output array
        // Index 
        // 0 = buy day
        // 1 = sell day
        // 2 = profit max
        int[] res = bt.BestTrading(prices, 0, prices.length - 1); 

        System.out.print(Arrays.toString(res));
        
       }catch(ArrayIndexOutOfBoundsException e){
            System.out.print("Error: missing arguments expected 1 received " + args.length + "\njava BestTrading <file> ");
       }catch(Exception e){
            System.out.print(e.getMessage());
       }
    }
}