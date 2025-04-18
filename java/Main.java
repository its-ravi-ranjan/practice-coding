import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    // void means no return
    public static void printJava (){
        System.out.println("Hello java");
    }
    public static  void printSum(int a,int b){
        System.out.println(a+b);
    }
    public static void main(String[] args) {
        // int size 4 byte, double size 8 byte, char 2 byte,
        //intialise string when string value known
        String name = "Raja Singh";
        //intialise string when value not known
        String name2= new String("");
        System.out.println("name2"+name2);
        int age = 25;
        System.out.println(name);
        System.out.println(age);
        System.out.print(name);
        System.out.println("age"+age);
        System.out.println(2/2);
        System.out.printf("%s %d",name,age);
        // intialise array when no value known
        int[] ages = new int[3];
        long mobile = 223777333333L;
        ages[0]=45;
        ages[1]=30;
        ages[2]=40;
        System.out.println(ages[0]);
        Arrays.sort(ages);
        System.out.println(ages[0]);
        // intialise array when value known
        int[] marks = {23,34,56,34};
        // intialise array when two d and value kn0wn
        int[][] finalMarks = {{23,45},{34,45}};

        // casting
      // implicite casting > jab bda datatype m chota data type add krte h to java aise changes allow krta h isme hme kuch ni krna pdta
       // implicite casting ex - when we add int value in double value like area = 24.50 sqft then we will add 5 sqft then output will be 29.5
        double area = 24.5;
        int extraArea = 5;
        double finalArea = area+extraArea;
        System.out.println(finalArea);
        // explicit casting > jab chote data type m bde data type ko add kiya jata h to error deta h like this java: incompatible types: possible lossy conversion from double to int
        // for explicit casting use () and pass data type in parenthesis  which you want to change
        int area2 = 30;
        double extreaarea2 = 2.34;
        int finalarea2 = area2+ (int)extreaarea2;
        System.out.println(finalarea2);

        // constants
        // if we want to make any variable value constant use final keyword before variable name
        // constant value should be in upper case like AGE1
        final int age1 = 34;

       // operators
        // 4 types of operator in java
        // arithmetic , logical, assignment, comparison, bitwise
        // arithmetic +,-, * , /, %, ++, --
       int numb = 1;
        System.out.println(numb++);// 1 yha print old value hua but actually value badh gya
        System.out.println(numb);//2
        System.out.println(++numb);//3

        // math class
        System.out.println(Math.max(5,6));
        System.out.println(Math.min(2,3));
        System.out.println(Math.random());//random value between 0 to 1

        // how to take input
        // Scanner class
//        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age");
//        int myage = sc.nextInt(); // nextInt , nextFloat, nextChar
//        System.out.println("my age is"+myage);
        // to take string
//        String myname = sc.nextLine();
//        System.out.println(myname);

        // comparision operator
        // ==, != , >, < , <= , >=

        // if else
        boolean isSunUp = true;
        if(isSunUp==true){
            System.out.println("day");
        }else{
            System.out.println("night");
        }

        // logical operator
        // && , || , !

        // assignment operator
        // =, +=, -= ,*=,

        // switch case
        int day = 1;
        switch (day){
            case 1:
                System.out.println("sunday");
                break;
            case 2:
                System.out.println("monday");
                break;
            default:
                System.out.println("weekened");
        }

        // loops
        // for loop, while loop, do while loops
        // for loop
         for(int i=0;i<5;i++){
             System.out.println(i);
         }
         // while loop >> in this first we check condition then we run inner code
        int i=0;
         while(i<=5){
             System.out.println(i);
             i++;
         }

         // do while >>  in this first we run inner code then we check  condition
        int j=0;
         do{
             System.out.println(j);
             j++;
         }while(j<=5);

         // break and continue

        // try catch exception handling
//        int[] areas = {2,3,4};
//        System.out.println(areas[4]); // here we will get error or exception Index 4 out of bounds for length 3
//        System.out.println("area printed"); // because of above error this line will not print

        // to solve this use try catch in line which can create error
        int[] areas = {2,3,4};
        try{
            System.out.println(areas[4]);
        }catch(Exception exception){
            System.out.println("exception coming");
        }
        System.out.println("area peinted");

        // methods/ function
        // let say i need to print hello java many times then we can create a method within this class but outside main fn
        printJava();
        printJava();
        printJava();

        // crate fn to sum two number
        printSum(4,5);// output should be 9

        //  small project to find random number  by taking input from user
        Scanner sc = new Scanner(System.in);
        int randomNum = (int)(Math.random()*100);
        int numE;
        do{
            System.out.println("Enter a number");
            numE = sc.nextInt();
            if(randomNum==numE){
                System.out.println("Random number is "+randomNum);
                break;
            }
            else if(numE>randomNum)
                System.out.println("Entered number is greater than random number");
            else
                System.out.println("Entered number is less than random number");
        }while(numE>=0);


      // string builder> using this we can add char in existing string also for reverse we can use this , its easy
        StringBuilder myname = new StringBuilder("Ravi");
        myname.setCharAt(1,'R');

        System.out.println(myname);
    }
}