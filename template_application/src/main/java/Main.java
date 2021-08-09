package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("    Exercise 1    ");
        System.out.println("Hello");
        System.out.println("My name is Asya");
        System.out.println("*************************************");

        System.out.println("   Exercise 2     ");
        int x=74;
        int y=36;
        System.out.println("The sum of this two numbers is " + x+y);
        System.out.println("*************************************");

        System.out.println("Exercise 3");
        int k=160;
        int l=10;
        int m;
        m = k/l;
        System.out.println("Dividing this numbers the result is " + m);
        System.out.println("*************************************");

        System.out.println("Excercise 4");
        System.out.println("The results of the expressions will be");
        System.out.println(-5 + 8 * 6);
        System.out.println((55+9) % 9);
        System.out.println(20 + -3*5 / 8);
        System.out.println(5 + 15 / 3 * 2 - 8 % 3);
        System.out.println("*************************************");

        System.out.println("Exercise 5");
        productOfNumbers();
        System.out.println("*************************************");

        System.out.println("Exercise 6");
        showResults();
        System.out.println("*************************************");

        System.out.println("Exercise 7");
        multiplicateUpToTen();
        System.out.println("*************************************");

        System.out.println("Exercise 8");
        arrayShuffle();
        System.out.println("*************************************");

        System.out.println("Exercise 9");
        double d;
        d= ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));
        System.out.println(d);
        System.out.println("*************************************");

        System.out.println("Exercise 10");
        double d1=4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11));
        System.out.println(d1);

        System.out.println("Exercise 11");
        circlePerimeterAndArea();
        System.out.println("*************************************");

        System.out.println("Exercise 12");
        averageOfTheNumbers();
        System.out.println("*************************************");

        System.out.println("13. Problem: print the area and perimeter of a rectangle.");
        rectangleAreaAndPerimeter();
        System.out.println("*************************************");

        System.out.println("14. Problem: print an American flag on the screen.");
        americanFlag();
        System.out.println("15. Problem: rearrange a given array of unique elements such that every second\n" +
                "element of the array is greater than its left and right elements.");





    }

    static void productOfNumbers() {
        System.out.println(25 * 5);

    }

    static void showResults() {
        System.out.println("125+24" + "=" + 125+24);
        System.out.println("125-24 is " + (125-24) );
        System.out.println("125/24 is"  + 125/24);
        System.out.println("125 * 24 =" + 125*24);
        System.out.println("The remainder of 125/24 = " +125%24);
    }

    static void multiplicateUpToTen(){
        int y=8;
        for (int i = 0; i <11 ; i++) {
            System.out.println("This line is iterating i after every multiplication");
            System.out.println(y*i);
        }

    }
    static void arrayShuffle() {
        int [] nums={1,2,3,4,5,6};
        System.out.println("An array is declared and initialized");
        int temp=nums[0];
        nums[0]=nums[3];
        nums[3]=temp;
        for (int value : nums) {
            System.out.print(value + " "); //4 2 6 5 1 3


        }
        System.out.println("switched the places of first and forth values");
        temp=nums [2];
        nums[2]=nums[5];
        nums[5]=temp;
        for (int j : nums) {
            System.out.print(j + " "); //4 2 6 5 1 3


        }
        System.out.println("switched the places of third and sixth values");
        temp =nums[3];
        nums[3]=nums[4];
        nums[4]=temp;
        for (int num : nums) {
            System.out.print(num + " "); //4 2 6 5 1 3
        }
        System.out.println("switched the places of forth and fifth values");

    }

    static void circlePerimeterAndArea(){
        double radius=7.5;
        System.out.println("The perimeter is " + radius*Math.PI*2);
        System.out.println("The area is " + radius*radius*Math.PI);
    }
    static  void averageOfTheNumbers()  {
        int x=25;
        int y=45;
        int z=12;
        int sum=x+y+z;
        System.out.println("This is the sum of the numbers " + sum);
        System.out.println("And this is the average " + sum/3);

    }
    static void rectangleAreaAndPerimeter() {
        double width= 5.5;
        double height=8.5;
        System.out.println("The area is " + width*height);
        System.out.println("The perimeter is " + 2*(width*height));
    }

    static void americanFlag() {
        System.out.println("* * * * * * ========================================");
        System.out.println(" * * * * *  ========================================");
        System.out.println("* * * * * * ========================================");
        System.out.println(" * * * * *  ========================================");
        System.out.println("* * * * * * ========================================");
        System.out.println(" * * * * *  ========================================");
        System.out.println("* * * * * * ========================================");
        System.out.println(" * * * * *  ========================================");
        System.out.println("* * * * * * ========================================");
        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println("====================================================");

    }



}



