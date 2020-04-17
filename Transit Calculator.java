/* This is my solution to the Challenge project "Best Fare Calculator" at Codecademy.
* Note: the Codecademy's solution as of 4/10/20  is incorrect, because it does not calculate the number of cards needed for
* the 30-day option. Similarly to the the 7-day option, if you have 31 days, you would need 2 * 30-day cards. In fact, 
* the real solution is more complicated: If,for example,  you had 37 days and a whole bunch of rides, you should get a 30-day and then a
* 7-day card. It could get even more complicated if you had different amounts of rides per day, of course. 
*****************************************************************************************************************************/

import java.util.Arrays;
import java.lang.reflect.Array; 
 
public class TransitCalculator{
  
  int days=0;
  int rides=0;

  double [] farePrices=new double []{2.75,33.00,  127.00};
  String[] fareOptions= new String[] {"Pay-per ride","7-day","30-day"};

  public TransitCalculator (int myDays, int myRides){
    
    int days = myDays;
    int rides =myRides;
    
  }
    public double payPerRide(int days, int rides){
    
    double pricePerRide;
   
    pricePerRide =(double)Array.get(farePrices,0);
    System.out.println("Price per ride for each ride is "+pricePerRide);//This line for test purposes
	return pricePerRide;    
}

public double unlimited7Price(int days, int rides){
    
    int numCards=(days/7);
    double cardPrice;
    double pricePerRide; 

    if(days%7!=0)//If you don't have an exact multiple of 7 days, you have to get another card, even if just one day!
    numCards++;
    System.out.println("Number of 7-day cards needed is " +numCards);//For testing
    cardPrice=(double)Array.get(farePrices,1); 
    pricePerRide =(numCards*cardPrice)/rides;
    System.out.println("Price per ride for 7 day is $"+pricePerRide);//;For testing
	return pricePerRide;
  }
  
 public double unlimited30Price(int days, int rides){
    
    int numCards=(days/30);
    double cardPrice=0;
    double pricePerRide=0;

    if (days%30!=0)//If you don't have an exact multiple of 30 days, you have to get another card, even if just one day!
      numCards++;
    System.out.println("Number of 30-day cards needed is "+ numCards);//For testing
    cardPrice= (double)Array.get(farePrices,2);    
    pricePerRide=(numCards*cardPrice)/rides;
    System.out.println("Price per ride for 30 day is $"+pricePerRide);//For testing
	return pricePerRide;
  }
  
 
  public double [] getRidePrices(int days, int rides){

	double[]pricePerRide=new double [3];

 	Array.set(pricePerRide,0,payPerRide(days,rides)); Array.set(pricePerRide,1,unlimited7Price(days,rides)); 
 	Array.set(pricePerRide,2,unlimited30Price(days,rides)); 
 	return pricePerRide;
  }
  
 public String getBestFare(int days, int rides){

  double farePrice;
  double bestPrice;
  String fareOption="";
  String recommendation="";
  String rec1 = "You should get the ";
  String rec2 = " option at $";
  String rec3 = " per ride.";

  double [] allPrices=getRidePrices(days, rides); //loop through all prices, keep setting best price to lowest one
  bestPrice=(double) Array.get(allPrices,0);
  for (int i=0;i<=2; i++){
    farePrice=(double)Array.get(allPrices,i);
         
  if (farePrice <= bestPrice){
        bestPrice=farePrice;
        fareOption=(String)Array.get(fareOptions,i);
      }
   }//end for
   recommendation=rec1+fareOption+ rec2+Math.round(bestPrice*100.0)/100.0 + rec3;
   return recommendation;
  }
public static void main(String[] args){
// set your days and rides below
  int days =90; 
  int rides = 120;
  String recommendation="";

  TransitCalculator myTransitCalculator=new TransitCalculator(days,rides);
  recommendation= myTransitCalculator.getBestFare(days,rides);
  System.out.println (recommendation);
}

}
  



