package train.management.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TrainManagementSystem {
    
public static void main(String[] args)throws FileNotFoundException {
        Scanner input=new Scanner(System.in);
        int trainCounter=0;
        int PassengerCounter=0;
        int ticketCounter=0;
        int tickets;
        String[][] Train=new String[100][6];
        String[][] Passenger=new String[100][5];
        int[][] Ticket=new int[100][5];
        trainCounter=readTrainFile(Train);
        PassengerCounter=readPassengerFile(Passenger);
        ticketCounter=readTicketFile(Ticket);
         int choise=0;
         while(true){
         System.out.print("\tMenu \n 1.Train \n 2.Passenger \n 3.Ticket \n 4.Exit \n");
         System.out.println("");
         boolean success = false;
         while (!success) {
            try {
                System.out.print("Enter an integer: ");
                choise = input.nextInt();
                System.out.println("");
                success = true;
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("You have entered invalid data");
            }
        }
          switch(choise) {
         case 1:
            trainCounter=submenu1(trainCounter,Train);
            break;
         case 2:
            PassengerCounter=submenu2(PassengerCounter,Passenger);
            break;
         case 3:
            ticketCounter=submenu3(Ticket,Train,Passenger,trainCounter,PassengerCounter,ticketCounter);
            break;
         case 4:{
                 System.out.println("Thanks for running program");
                 break;
         }
         default:{
                 System.out.println("Invalid input");
                 System.out.println("");
            }
         }
        if( choise==4)
            break;
        }
    }
 public static int submenu1(int trainCounter,String Train[][]) throws FileNotFoundException{
    Scanner input=new Scanner(System.in);
    int value=0;
    while(value!=6){
        System.out.print("Menu of Trains \n 1.Add Train \n 2.View Train \n 3.Edit train \n 4.Delete Train \n 5.Search train \n 6.MainMenu \n");
        //value=input.nextInt();
        System.out.println("");
        boolean success = false;
        while (!success) {
            try {
                System.out.print("Enter an integer: ");
                value = input.nextInt();
                System.out.println("");
//System.out.println("You entered " + value);
                success = true;
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("You have entered invalid data");
            }
        }
        if(value==1) {
           trainCounter=addTrain(Train,trainCounter);
           sortTrain(Train,trainCounter);
           writeTrainFile(trainCounter,Train);
        }
        if(value==2){
            System.out.println("ID\t\tName of train\t\tNumber of seats\t\tPirce of ticket\t\tSource of train\t\tDstination of train");
            viewTrain(Train,trainCounter,0);
            System.out.println("");
        }
        if(value==3){
           editTrain(Train,trainCounter);
           writeTrainFile(trainCounter,Train);
    }
        if(value==4){
           trainCounter=deleteTrain(Train,trainCounter);
           writeTrainFile(trainCounter,Train);
}
        if(value==5)
            searchTrain(Train,trainCounter);
        if(value==6)
            System.out.println("");
        if(value<1 | value>6 ){
               System.out.println("Invalid Input");
               System.out.println("");
        }
 }
        return trainCounter;
 }
 
 
 public static int addTrain(String[][] Train,int trainCounter) throws FileNotFoundException{
     Scanner input=new Scanner(System.in);
     int Counter=trainCounter;
     for(int i=Counter;i<Train.length;i++){
        for(int j=0;j<Train[i].length;j++){
            if(j==0){
                System.out.print("Enter unique ID of the train "+(i+1)+" : ");
                Train[i][j]=input.next();
                while(true){
                    if(numcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter unique ID of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            if(Counter!=0){
                    while(idCheck(Train,Counter,Train[i][j])== true){
                    System.out.println("ID already exists");
                    System.out.print("Plz re-enter the value : ");
                    Train[i][j]=input.next();
                    System.out.println("");
                   
                   
                    }
                }
            }
            if(j==1){
            System.out.print("Enter name of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(charcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabet only");
                        System.out.print("Enter name of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
            if(j==2){
            System.out.print("Enter number of seats of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(numcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter seats of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
            if(j==3){
            System.out.print("Enter price of ticket of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(numcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter price of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
            if(j==4){
            System.out.print("Enter source of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(charcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabet only");
                        System.out.print("Enter source of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
            if(j==5){
            System.out.print("Enter destination of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(charcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabet only");
                        System.out.print("Enter destination of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
        }

        System.out.println("\nIf you want to add more record Enter '1' ");
        int status=0;
        boolean success = false;
        while (!success) {
            try {
                System.out.print("Enter an integer: ");
                status = input.nextInt();
                success = true;
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("You have entered invalid data");
            }
        }
        System.out.println("");
            if(status!=1){
                ++Counter;
                return Counter;
            }
            else
                Counter++;
   }
     System.out.println("Space finished");
     return Counter;
 }
 
 public static void viewTrain(String[][] Train,int counter,int i) throws FileNotFoundException{  
      if(i<counter){
              for(int j=0;j<Train[i].length;j++){
              System.out.print(Train[i][j] + "\t\t\t");
              }
              System.out.println("");
              viewTrain(Train,counter,i+1);
      }
  }
 
 public static void editTrain(String[][] Train,int counter) throws FileNotFoundException{
    Scanner input=new Scanner(System.in);
    System.out.print("Enter unique ID to edit record : ");
    String ID=input.next();
    int value=0;
    for(int i=0;i<=counter-1;i++){
        if(Train[i][0].equals(ID)==true){
            System.out.println("1.Edit Name");
            System.out.println("2.Edit Seats");
            System.out.println("3.Edit Price");
            System.out.println("4.Edit Source");
            System.out.println("5.Edit Destination");
            System.out.println("6.Edit whole record");
            System.out.print("Enter choise here : ");
            value=input.nextInt();
            while(true){
                    if(numcheck(Train[i][2])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Re-Enter the value : "+(i+1)+" : ");
                        value=input.nextInt();
                    }
                }
            System.out.println("");
           
            if(value==1){
            System.out.print("Enter name of train "+(i+1)+" : ");
            Train[i][1]=input.next();
            while(true){
                    if(charcheck(Train[i][1])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabets only");
                        System.out.print("Enter name of the train "+(i+1)+" : ");
                        Train[i][1]=input.next();
                    }
                }
            }
           
            if(value==2){
            System.out.print("Enter Seats of train "+(i+1)+" : ");
            Train[i][2]=input.next();
            while(true){
                    if(numcheck(Train[i][2])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter seats of the train "+(i+1)+" : ");
                        Train[i][2]=input.next();
                    }
                }
            }
           
            if(value==3){
            System.out.print("Enter price of train "+(i+1)+" : ");
            Train[i][3]=input.next();
            while(true){
                    if(numcheck(Train[i][3])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter price of the train "+(i+1)+" : ");
                        Train[i][3]=input.next();
                    }
                }
            }
           
            if(value==4){
            System.out.print("Enter source of train "+(i+1)+" : ");
            Train[i][4]=input.next();
            while(true){
                    if(charcheck(Train[i][4])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabets only");
                        System.out.print("Enter source of the train "+(i+1)+" : ");
                        Train[i][4]=input.next();
                    }
                }
            }
           
            if(value==5){
            System.out.print("Enter destination of train "+(i+1)+" : ");
            Train[i][5]=input.next();
            while(true){
                    if(charcheck(Train[i][1])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabets only");
                        System.out.print("Enter destination of the train "+(i+1)+" : ");
                        Train[i][5]=input.next();
                    }
                }
            }
           
        if(value==6){    
        for(int j=1;j<Train[i].length;j++){
            if(j==1){
            System.out.print("Enter name of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(charcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabets only");
                        System.out.print("Enter name of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
            if(j==2){
            System.out.print("Enter number of seats of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(numcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter seats of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
            if(j==3){
            System.out.print("Enter price of ticket of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(numcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter price of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
            if(j==4){
            System.out.print("Enter source of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(charcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter source only");
                        System.out.print("Enter source of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
            if(j==5){
            System.out.print("Enter destination of train "+(i+1)+" : ");
            Train[i][j]=input.next();
            while(true){
                    if(charcheck(Train[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabets only");
                        System.out.print("Enter destination of the train "+(i+1)+" : ");
                        Train[i][j]=input.next();
                    }
                }
            }
          }
        }
        }
    }
     if(value<1 | value>6)System.out.println("Invalid input");
     System.out.println("");
   
 }
 public static void searchTrain(String[][] Train,int counter){
       Scanner input=new Scanner(System.in);
        System.out.print("Input unique ID to search : ");
        int ID=input.nextInt();
            int low = 0;
            int high = counter-1;
            while(high>=low){
                int mid=(low+high)/2;
                if (ID==Integer.parseInt(Train[mid][0])){
                    System.out.println("Name of train : "+Train[mid][1]);
                    System.out.println("Number of seats of train : "+Train[mid][2]);
                    System.out.println("Pirce of ticket of train : "+Train[mid][3]);
                    System.out.println("Source of train : "+Train[mid][4]);
                    System.out.println("Destination of train : "+Train[mid][5]);
                    break;
                    }
                else if(ID > Integer.parseInt(Train[mid][0]) )
                    low = mid + 1;
                else
                    high = mid - 1;
                    }            
        if(low>high)System.out.println("ID not found");
        System.out.println("");
 }
       
  public static boolean idCheck(String[][] list,int counter,String ID){    
      boolean status=false;
           for(int i=0;i<counter;i++){
               if (list[i][0].equals(ID)) {
                   status=true;
                   break;
               }      
           }
           return status;
           
 }        
       
  public static int deleteTrain(String Train[][],int counter){
    Scanner input=new Scanner(System.in);
    System.out.print("Enter unique ID to delete record : ");
    String ID=input.next();
    String temp;
    boolean check=false;
    if(Train[0][0].equals(ID)==true){
            check=true;
        for(int j=0;j<Train[0].length;j++){
                if(j==0){
                    temp=Train[0][j];
                    Train[0][j]=Train[1][j];
                    Train[1][j]=temp;
                }
                if(j==1){
                    temp=Train[0][j];
                    Train[0][j]=Train[1][j];
                    Train[1][j]=temp;
                }
                if(j==2){
                    temp=Train[0][j];
                    Train[0][j]=Train[1][j];
                    Train[1][j]=temp;
 
                }
                if(j==3){
                    temp=Train[0][j];
                    Train[0][j]=Train[1][j];
                    Train[1][j]=temp;
 
                }
                if(j==4){
                    temp=Train[0][j];
                    Train[0][j]=Train[1][j];
                    Train[1][j]=temp;
                }
                if(j==5){
                temp=Train[0][j];
                    Train[0][j]=Train[1][j];
                    Train[1][j]=temp;
                }
            }
        }
    for(int i=0;i<counter-1;i++){
        if(Train[i][0].equals(ID)==true){
            check=true;
        for(int j=0;j<Train[i].length;j++){
                if(j==0){
                    temp=Train[i][j];
                    Train[i][j]=Train[i+1][j];
                    Train[i+1][j]=temp;
                }
                if(j==1){
                    temp=Train[i][j];
                    Train[i][j]=Train[i+1][j];
                    Train[i+1][j]=temp;
                }
                if(j==2){
                    temp=Train[i][j];
                    Train[i][j]=Train[i+1][j];
                    Train[i+1][j]=temp;
                }
                if(j==3){
                    temp=Train[i][j];
                    Train[i][j]=Train[i+1][j];
                    Train[i+1][j]=temp;
                }
                if(j==4){
                    temp=Train[i][j];
                    Train[i][j]=Train[i+1][j];
                    Train[i+1][j]=temp;
                }
                if(j==5){
                    temp=Train[i][j];
                    Train[i][j]=Train[i+1][j];
                    Train[i+1][j]=temp;
                }
            }
        }
    }
    if(Train[counter-1][0].equals(ID)==true){
            check=true;
    }
   
    if(check==true){
            counter=counter-1;
            System.out.println("Record Delected Succesfully");
            System.out.println("");
        }
    else{
        System.out.println("ID not found");
        System.out.println("");
   
    }
    return counter;
  }

public static void sortTrain(String Train[][], int counter){
int i , j , minValue , minIndex = 0;
String temp;
for(i=0;i<counter;i++){
    minValue= Integer.parseInt(Train[i][0]);
    minIndex = i ;
    for(j=i;j<counter;j++){
        if(Integer.parseInt(Train[j][0])<minValue){
            minValue=Integer.parseInt(Train[j][0]);
            minIndex=j;
        }
    }
    if(minValue < Integer.parseInt(Train[i][0])){
        temp=Train[i][0];
        Train[i][0]=Train[minIndex][0];
        Train[minIndex][0]=temp;
       
        temp=Train[i][1];
        Train[i][1]=Train[minIndex][1];
        Train[minIndex][1]=temp;
       
        temp=Train[i][2];
        Train[i][2]=Train[minIndex][2];
        Train[minIndex][2]=temp;
       
        temp=Train[i][3];
        Train[i][3]=Train[minIndex][3];
        Train[minIndex][3]=temp;
       
        temp=Train[i][4];
        Train[i][4]=Train[minIndex][4];
        Train[minIndex][4]=temp;
       
        temp=Train[i][5];
        Train[i][5]=Train[minIndex][5];
        Train[minIndex][5]=temp;
        }
    }



}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   
    public static int submenu2(int PassengerCounter,String Passenger[][]) throws FileNotFoundException{
    Scanner input=new Scanner(System.in);
    int value=0;
    while(value!=6){
        System.out.print("Menu of Passengers \n 1.Add Passenger \n 2.View Passenger \n 3.Edit Passenger \n 4.Delete Passenger \n 5.Search Passenger \n 6.MainMenu \n");
        //value=input.nextInt();
        System.out.println("");
        boolean success = false;
        while (!success) {
            try {
                System.out.print("Enter an integer: ");
                value = input.nextInt();
                //System.out.println("You entered " + value);
                success = true;
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("You have entered invalid data");
            }
        }
        if(value==1) {
           PassengerCounter=addPassenger(Passenger,PassengerCounter);
           sortPassenger(Passenger,PassengerCounter);
           writePassengerFile(PassengerCounter,Passenger);
            System.out.println("");
            }
        if(value==2){
            System.out.println("Unique ID \t Name of Passenger\tAge of Passenger \tCNIC of Passenger \tMobile No. of Passenger");
            viewPassenger(Passenger,PassengerCounter,0);
            System.out.println("");
        }
        if(value==3){
            editPassenger(Passenger,PassengerCounter);
           writePassengerFile(PassengerCounter,Passenger);
            System.out.println("");
        }
        if(value==4){
           PassengerCounter=deletePassenger(Passenger,PassengerCounter);
           writePassengerFile(PassengerCounter,Passenger);
            System.out.println("");
        }
        if(value==5){
            searchPassenger(Passenger,PassengerCounter);
            System.out.println("");
        }
        if(value==6)
            System.out.println("");
        if(value<1 | value>6 ){
               System.out.println("Invalid Input");
               System.out.println("");
        }
 }
        return PassengerCounter;
 }
 
 
 public static int addPassenger(String[][] Passenger,int PassengerCounter){
     Scanner input=new Scanner(System.in);
     int Counter=PassengerCounter;
     for(int i=Counter;i<Passenger.length;i++){
        for(int j=0;j<Passenger[i].length;j++){
            if(j==0){
            System.out.print("Enter unique ID of the Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(numcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter unique ID of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
                }
            if(Counter!=0){
                   while(idCheck(Passenger,Counter,Passenger[i][j]) == true){
                    System.out.println("ID already exists");
                    System.out.print("Plz re-enter the value : ");
                    Passenger[i][j]=input.next();
                    System.out.println("");
                    while(true){
                    if(numcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter unique ID of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
                    }
                   }
            }
            }
            if(j==1){
            System.out.print("Enter name of Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(charcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabet only");
                        System.out.print("Enter name of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
            }
            }
            if(j==2){
            System.out.print("Enter age of Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(numcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter age of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
            }
            }
            if(j==3){
            System.out.print("Enter CNIC of Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(numcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter CNIC of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
            }
            }
            if(j==4){
            System.out.print("Enter mobile no. of Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(numcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter mobile No. of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
            }
           }
        }
        System.out.println("\nIf you want to add more record Enter '1' ");
        int status=0;
        //status=input.nextInt();
        System.out.println("");
        boolean success = false;
        while (!success) {
            try {
                System.out.print("Enter an integer: ");
                status = input.nextInt();
                //System.out.println("You entered " + value);
                success = true;
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("You have entered invalid data");
            }
        }
            if(status!=1){
                ++Counter;
                return Counter;
            }
            else {
                Counter++;
            }
            }
     System.out.println("Space finished");
     return Counter;
 }
 
  public static void viewPassenger(String[][] Passenger,int counter,int i){  
     
      if(i<=counter-1){
             for(int j=0;j<Passenger[i].length;j++){
              System.out.print(Passenger[i][j] + "\t\t\t");
              }
              System.out.println("");
              viewPassenger(Passenger,counter,i+1);
      }
      }
 
 
 public static void editPassenger(String[][] Passenger,int counter){
    Scanner input=new Scanner(System.in);
    System.out.print("Enter unique ID to edit record : ");
    String ID=input.next();
    int value=0;
    for(int i=0;i<=counter-1;i++){
        if(Passenger[i][0].equals(ID)==true){
            System.out.println("1.Edit Name");
            System.out.println("2.Edit age");
            System.out.println("3.Edit CNIC");
            System.out.println("4.Edit Mobile no.");
            System.out.println("5.Edit whole record");
            System.out.print("Enter choise here : ");
            value=input.nextInt();
            while(true){
                    if(numcheck(Passenger[i][2])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Re-Enter the value  "+(i+1)+" : ");
                        value=input.nextInt();
                    }
                }
            }
            System.out.println("");
           
            if(value==1){
            System.out.print("Enter name of passenger "+(i+1)+" : ");
            Passenger[i][1]=input.next();
            while(true){
                    if(charcheck(Passenger[i][1])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabets only");
                        System.out.print("Enter name of the passenger "+(i+1)+" : ");
                        Passenger[i][1]=input.next();
                    }
                }
            }
           
            if(value==2){
            System.out.print("Enter age of Passenger "+(i+1)+" : ");
            Passenger[i][2]=input.next();
            while(true){
                    if(numcheck(Passenger[i][2])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter age of the Passenger "+(i+1)+" : ");
                        Passenger[i][2]=input.next();
                    }
                }
            }
           
            if(value==3){
            System.out.print("Enter CNIC of Passenger "+(i+1)+" : ");
            Passenger[i][3]=input.next();
            while(true){
                    if(numcheck(Passenger[i][3])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter CNIC of the Passenger "+(i+1)+" : ");
                        Passenger[i][3]=input.next();
                    }
                }
            }
           
            if(value==4){
            System.out.print("Enter mobile of Passenger "+(i+1)+" : ");
            Passenger[i][4]=input.next();
            while(true){
                    if(numcheck(Passenger[i][4])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter mobile of the Passenger "+(i+1)+" : ");
                        Passenger[i][4]=input.next();
                    }
                }
            }
           
        if(value==5){    
        for(int j=1;j<Passenger[i].length;j++){
            if(j==1){
            System.out.print("Enter name of Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(charcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter alphabets only");
                        System.out.print("Enter name of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
                }
            }
            if(j==2){
            System.out.print("Enter Age of Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(numcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter age of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
                }
            }
            if(j==3){
            System.out.print("Enter CNIC of Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(numcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter CNIC of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                    }
                }
            }
            if(j==4){
            System.out.print("Enter Mobile No. of Passenger "+(i+1)+" : ");
            Passenger[i][j]=input.next();
            while(true){
                    if(numcheck(Passenger[i][j])==true){
                        break;
                    }
                    else{
                        System.out.println("Enter number only");
                        System.out.print("Enter Mobile No. of the Passenger "+(i+1)+" : ");
                        Passenger[i][j]=input.next();
                        }
                    }
                }
            }
            }
        }
    if(value<1 | value>5)System.out.println("Invalid input");
   
 }
 public static void searchPassenger(String[][] Passenger,int counter){
        Scanner input=new Scanner(System.in);
        System.out.print("Input unique ID to search : ");
        int ID=input.nextInt();
            int low = 0;
            int high = counter-1;
            while(high>=low){
                int mid=(low+high)/2;
                if (ID==Integer.parseInt(Passenger[mid][0])){
                    System.out.println("Name of Passenger : "+Passenger[mid][1]);
                    System.out.println("Age of Passenger : "+Passenger[mid][2]);
                    System.out.println("CNIC of Passenger : "+Passenger[mid][3]);
                    System.out.println("Mobile No. of Passenger : "+Passenger[mid][4]);
                    break;
                    }
                else if(ID > Integer.parseInt(Passenger[mid][0]))
                    low = mid + 1;
                else
                    high = mid - 1;
                    }            
        if(low>high)System.out.println("ID not found");
 
 }
       
  public static int deletePassenger(String Passenger[][],int counter){
     Scanner input=new Scanner(System.in);
    System.out.print("Enter unique ID to delete record : ");
    String ID=input.next();
    String temp;
    boolean check=false;
    if(Passenger[0][0].equals(ID)==true){
            check=true;
        for(int j=0;j<Passenger[0].length;j++){
                if(j==0){
                    temp=Passenger[0][j];
                    Passenger[0][j]=Passenger[1][j];
                    Passenger[1][j]=temp;
                }
                if(j==1){
                    temp=Passenger[0][j];
                    Passenger[0][j]=Passenger[1][j];
                    Passenger[1][j]=temp;
                }
                if(j==2){
                    temp=Passenger[0][j];
                    Passenger[0][j]=Passenger[1][j];
                    Passenger[1][j]=temp;
 
                }
                if(j==3){
                    temp=Passenger[0][j];
                    Passenger[0][j]=Passenger[1][j];
                    Passenger[1][j]=temp;
 
                }
                if(j==4){
                    temp=Passenger[0][j];
                    Passenger[0][j]=Passenger[1][j];
                    Passenger[1][j]=temp;
                }
                if(j==5){
                temp=Passenger[0][j];
                    Passenger[0][j]=Passenger[1][j];
                    Passenger[1][j]=temp;
                }
            }
        }
    for(int i=0;i<counter-1;i++){
        if(Passenger[i][0].equals(ID)==true){
            check=true;
        for(int j=0;j<Passenger[i].length;j++){
                if(j==0){
                    temp=Passenger[i][j];
                    Passenger[i][j]=Passenger[i+1][j];
                    Passenger[i+1][j]=temp;
                }
                if(j==1){
                    temp=Passenger[i][j];
                    Passenger[i][j]=Passenger[i+1][j];
                    Passenger[i+1][j]=temp;
                }
                if(j==2){
                    temp=Passenger[i][j];
                    Passenger[i][j]=Passenger[i+1][j];
                    Passenger[i+1][j]=temp;
                }
                if(j==3){
                    temp=Passenger[i][j];
                    Passenger[i][j]=Passenger[i+1][j];
                    Passenger[i+1][j]=temp;
                }
                if(j==4){
                    temp=Passenger[i][j];
                    Passenger[i][j]=Passenger[i+1][j];
                    Passenger[i+1][j]=temp;
                }
                if(j==5){
                    temp=Passenger[i][j];
                    Passenger[i][j]=Passenger[i+1][j];
                    Passenger[i+1][j]=temp;
                }
            }
        }
    }
    if(Passenger[counter-1][0].equals(ID)==true){
            check=true;
    }
   
    if(check==true){
            counter=counter-1;
            System.out.println("Record Delected Succesfully");
            System.out.println("");
        }
    else{
        System.out.println("ID not found");
        System.out.println("");
   
    }
    return counter;
  }


public static void sortPassenger(String Passenger[][], int counter){
int i , j , minValue , minIndex = 0;
String temp;
for(i=0;i<counter;i++){
    minValue= Integer.parseInt(Passenger[i][0]);
    minIndex = i ;
    for(j=i;j<counter;j++){
        if(Integer.parseInt(Passenger[j][0])<minValue){
            minValue=Integer.parseInt(Passenger[j][0]);
            minIndex=j;
        }
    }
    if(minValue < Integer.parseInt(Passenger[i][0])){
        temp=Passenger[i][0];
        Passenger[i][0]=Passenger[minIndex][0];
        Passenger[minIndex][0]=temp;
       
        temp=Passenger[i][1];
        Passenger[i][1]=Passenger[minIndex][1];
        Passenger[minIndex][1]=temp;
       
        temp=Passenger[i][2];
        Passenger[i][2]=Passenger[minIndex][2];
        Passenger[minIndex][2]=temp;
       
        temp=Passenger[i][3];
        Passenger[i][3]=Passenger[minIndex][3];
        Passenger[minIndex][3]=temp;
       
        temp=Passenger[i][4];
        Passenger[i][4]=Passenger[minIndex][4];
        Passenger[minIndex][4]=temp;

        }
    }

}
 //--------------------------------------------------------------------------------------------------------------------------------------------------  
   
public static int submenu3(int Ticket[][],String Train[][],String Passenger[][],int trainCounter,int PassengerCounter,int ticketCounter) throws FileNotFoundException{
Scanner input=new Scanner(System.in);
    int value=0;
    while(value!=3){
        System.out.print("Menu of Ticker \n 1.Add Ticket \n 2.View Ticket \n 3.MainMenu \n");
        //value=input.nextInt();
        System.out.println("");
        boolean success = false;
        while (!success) {
            try {
                System.out.print("Enter an integer: ");
                value= input.nextInt();
                //System.out.println("You entered " + value);
                success = true;
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("You have entered invalid data");
            }
        }
        if(value==1){
           ticketCounter = addTicket(Ticket,Train,Passenger,trainCounter,PassengerCounter,ticketCounter);
           writeTicketFile(ticketCounter,Ticket);
           writeTrainFile(trainCounter,Train);
        }
        if(value==2)
            viewTicket(Ticket,ticketCounter);
        if(value==3){
            System.out.println("");
        }
        if(value<1 | value>4 ){
               System.out.println("Invalid Input");
               System.out.println("");
        }
       
 }
        return ticketCounter;
}
   
public static int addTicket(int Ticket[][],String Train[][],String Passenger[][],int trainCounter,int PassengerCounter,int ticketCounter){
    Scanner input=new Scanner(System.in);
    System.out.print("Enter train ID : ");
    String trainID=input.next();
    System.out.print("Enter passenger ID : ");
    String passengerID=input.next();
    int Tickets;
    int Price;
    int totalPrice;
       
        int i=0;
        while(i<trainCounter){
            if(Train[i][0].equals(trainID)==true){
                break;
            }
            else{
                if(i!=trainCounter)
                    i++;
           
            }
            if(i==trainCounter){
                System.out.println("Train ID not found !");
                System.out.println("PLZ Re-Enter the Train ID : ");
                trainID=input.next();
                System.out.println("");
                i=0;
            }
        }
       
        int j=0;
        while(j<PassengerCounter){
            if(Passenger[j][0].equals(passengerID)==true){
                break;
            }
            else{
                if(j != PassengerCounter)
                    j++;
           
            }
            if(j==PassengerCounter){
                System.out.println("Passenger ID not found !");
                System.out.println("PLZ Re-Enter the Passenger ID : ");
                passengerID=input.next();
                System.out.println("");
                j=0;
            }
        }

    Tickets = Integer.parseInt(Train[i][2]);
    System.out.println("Tickets available : "+Tickets);
    Price=Integer.parseInt(Train[i][3]);
    System.out.println("");
    int requirement=0;
    boolean success = false;
        while (!success) {
            try {
                System.out.print("Enter Tickets required: ");
                requirement = input.nextInt();
                //System.out.println("You entered " + value);
                success = true;
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("You have entered invalid data");
                System.out.println("Enter integers only");
            }
        }
    while(true){
        if(requirement<=Tickets){
            Tickets=Tickets-requirement;
            Train[i][2]=Integer.toString(Tickets);
            totalPrice=requirement*Price;
            break;
            }
        else{
            System.out.println("We can't fullfil your requirment bcz required tickets are more than available tickets");
            System.out.println("Number of tickets available : "+Tickets);
            System.out.print("Plz re-enter tickets required : ");
            requirement=input.nextInt();
        }
    }
            Ticket[ticketCounter][0]=Integer.parseInt(Train[i][0]);
            Ticket[ticketCounter][1]=Integer.parseInt(Passenger[j][0]);
            Ticket[ticketCounter][2]=requirement;
            Ticket[ticketCounter][3]=Price;
            Ticket[ticketCounter][4]=totalPrice;
            ticketCounter++;
            System.out.println("Order Succesfully Placed");
            System.out.println("");
            return ticketCounter;
}

public static void viewTicket(int Ticket[][],int counter){  
      System.out.println("Train ID\t\tPassenger ID\t\tRequirement\t\tPrice\t\tTotal Price of the tickets");
      for(int i=0;i<=counter-1;i++){
             for(int j=0;j<Ticket[i].length;j++){
              System.out.print(Ticket[i][j] + " \t\t\t");
              }
              System.out.println("");
      }
}
     

public static boolean numcheck(String num){
    boolean check=false;
    for(int i=0;i<num.length();i++){
        if(num.charAt(i)>='0' & num.charAt(i)<='9'){
            check=true;
        }
        else{
            check=false;
            break;
        }
    }
    return check;
}
public static boolean charcheck(String s){
    boolean check=false;
    for(int i=0;i<s.length();i++){
        if((s.charAt(i)>='A' & s.charAt(i)<='Z') | (s.charAt(i)>='a' & s.charAt(i)<='z')){
            check=true;
        }
        else{
            check=false;
            break;
        }
    }
    return check;
}

public static int readTrainFile(String[][] Train ) throws FileNotFoundException{
        Scanner s=new Scanner(new File("C:\\Users\\uzair\\OneDrive\\Desktop\\Train Project\\Train.txt"));
        int i=0;
        while(s.hasNext()){
            for(int j=0;j<6;j++){
                Train[i][j]=s.next();
            }
        i++;
        }
        return i;
}

public static int readPassengerFile(String[][] Passenger ) throws FileNotFoundException{
        Scanner s=new Scanner(new File("C:\\Users\\uzair\\OneDrive\\Desktop\\Train Project\\Passenger.txt"));
        int i=0;
        while(s.hasNext()){
            for(int j=0;j<5;j++){
                Passenger[i][j]=s.next();
            }
        i++;
        }
        return i;
}
public static int readTicketFile(int [][] Ticket ) throws FileNotFoundException{
        Scanner s=new Scanner(new File("C:\\Users\\uzair\\OneDrive\\Desktop\\Train Project\\Ticket.txt"));
        int i=0;
        while(s.hasNext()){
            for(int j=0;j<5;j++){
                Ticket[i][j]=Integer.parseInt(s.next());
            }
        i++;
        }
        return i;
}
public static void writeTrainFile(int trainCounter,String[][]Train) throws FileNotFoundException{
            File f=new File("C:\\Users\\uzair\\OneDrive\\Desktop\\Train Project\\Train.txt");
            PrintWriter pw=new PrintWriter(f);
            for(int z=0;z<trainCounter;z++){
                for(int j=0;j<Train[z].length;j++){
                    pw.print(Train[z][j]+" ");
                }
                pw.println();
    }
      pw.close();
}
public static void writePassengerFile(int PassengerCounter,String[][]Passenger) throws FileNotFoundException{
            File f=new File("C:\\Users\\uzair\\OneDrive\\Desktop\\Train Project\\Passenger.txt");
            PrintWriter pw=new PrintWriter(f);
            for(int z=0;z<PassengerCounter;z++){
                for(int j=0;j<Passenger[z].length;j++){
                    pw.print(Passenger[z][j]+" ");
                }
                pw.println();
    }
      pw.close();
}
public static void writeTicketFile(int ticketCounter,int [][]Ticket) throws FileNotFoundException{
            File f=new File("C:\\Users\\uzair\\OneDrive\\Desktop\\Train Project\\Ticket.txt");
            PrintWriter pw=new PrintWriter(f);
            for(int z=0;z<ticketCounter;z++){
                for(int j=0;j<Ticket[z].length;j++){
                    pw.print(Ticket[z][j]+" ");
                }
                pw.println();
    }
      pw.close();
}

}
