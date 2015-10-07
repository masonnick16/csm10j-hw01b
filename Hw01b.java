/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
/**
 *
 * @author Nick
 */
public class Hw01b{ 
    public static void GetStocksStats(double[] x){
        double sum=0;
        double min=x[0];
        double max=x[0];
        double avg=0;
        for(int i=0;i<x.length;i++){
            sum+=x[i];    
        }
        avg=sum/x.length;
        for(int i=0;i<x.length;i++)
        {
            if(min>x[i]){
                min=x[i];
            }
        }
        for(int i=0;i<x.length;i++)
        {
            if(max<x[i]){
                max=x[i];
            }
        }
        System.out.printf("min: %.2f max: %.2f avg: %.2f", min, max, avg);

    }
    public static double GetStockHigh(double[] x){
        double max=x[0];
        for(int i=0;i<x.length;i++)
        {
            if(max<x[i]){
                max=x[i];
            }
        }
      return max;
    }
    public static double GetStockLow(double[] x){
        double min=x[0];
        for(int i=0;i<x.length;i++)
        {
            if(min>x[i]){
                min=x[i];
            }
        }
      return min;
    }
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner stockFile = new Scanner(new FileReader("stocks.txt"));
        boolean quit=true;
        String choice;
        Scanner in=new Scanner(System.in);
        while(quit){
           System.out.println("Enter '1' to get max, min, and avg of a stock");
           System.out.println("Enter '2' to get stock ticker with highest price");
           System.out.println("Enter '3' to get stock ticker with lowest price");
           System.out.println("Enter 'c' change the stockfile name");
           System.out.println("Enter 'q' to quit");
           System.out.print("Your choice: ");
           choice= in.next();
           
        
        switch(choice.toLowerCase()){
            case "1":
                System.out.print("Enter a stock ticker: ");
                String stockTicker=in.next();
                System.out.println();
                int count=0;
                while(stockFile.hasNext()){
                    if(stockFile.next().equals(stockTicker)){
                      count++;  
                    }
                }
                double[] stockPrices= new double[count];
                for(int i=0;i<count;i++){
                    if(stockFile.next().equals(stockTicker)){
                      stockPrices[i]=stockFile.nextDouble();  
                    }
                }
                System.out.print(stockTicker);
                GetStocksStats(stockPrices);
               
                break;
            case "2":
                System.out.println();
                int count2=0;
                while(stockFile.hasNextDouble()){
                    {
                      count2++;  
                    }
                }
                double[] stockPrices2= new double[count2];
                String[] stockNames= new String[count2];
                for(int i=0;i<count2;i++){
                    
                      stockPrices2[i]=stockFile.nextDouble();  
                    
                }
                for(int i=0;i<count2;i++){
                    stockNames[i]=stockFile.next();
                    stockFile.next();
                }
                
                double highestValue=GetStockHigh(stockPrices2);
                int x=0;
                while(stockPrices2[x]!=highestValue){
                    x++;
                }
                System.out.printf("% has highest price of %%n", stockNames[x], highestValue);
                break;
            case "3":
                System.out.println();
                int count3=0;
                while(stockFile.hasNextDouble()){
                    {
                      count3++;  
                    }
                }
                double[] stockPrices3= new double[count3];
                String[] stockNames2= new String[count3];
                for(int i=0;i<count3;i++){
                    
                      stockPrices3[i]=stockFile.nextDouble();  
                    
                }
                for(int i=0;i<count3;i++){
                    stockNames2[i]=stockFile.next();
                    stockFile.next();
                }
                
                double lowestValue=GetStockLow(stockPrices3);
                int y=0;
                while(stockPrices3[y]!=lowestValue){
                    y++;
                }
                System.out.printf("% has lowest price of %%n", stockNames2[y], lowestValue);
                break;
            case "c":
                System.out.print("Enter a stock filename: ");
                String newName=in.next();
                File oldName = new File("stocks.txt");
                File newFile = new File(newName);
                oldName.renameTo(newFile);

                break;
            case "q":
                System.out.println("Goodbye");
                quit=false;
                break;
            
        }
    }
        
  }
}
