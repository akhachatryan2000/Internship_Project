package firstweekexercises;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Problem: print 'Hello' on screen and then print your name on a separate line.");
        System.out.println("Hello");
        System.out.println("Asya");
        System.out.println("2. Problem: print the sum of two numbers.");
        System.out.println(74 + 36);
        System.out.println("3. Problem: divide two numbers and print on the screen.");
        System.out.println(50 / 3);
        System.out.println("4. Problem: print the result of the following operations.");
        System.out.println(-5 + 8 * 6);
        System.out.println((55 + 9) % 9);
        System.out.println(20 + -3 * 5 / 8);
        System.out.println(5 + 15 / 3 * 2 - 8 % 3);
        System.out.println("5. Problem: that takes two numbers as input and displays the product of two numbers");
        product(25, 5);
        calculate(125, 24);
        System.out.println("7. Problem: that takes a number as input and prints its multiplication table upto 10.");
        multiply(8);
        System.out.println("8. Problem: shuffle a given array of integers.");
        arrayShuffle();
        System.out.println("9. Problem: compute the specified expressions and print the output.");
        System.out.println(((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));
        System.out.println("10. Problem: compute a specified formula.");
        System.out.println(4.0 * (1 - (1.0 / 3) + (1.0 / 5) - (1.0 / 7) + (1.0 / 9) - (1.0 / 11)));
        System.out.println("11. Problem: print the area and perimeter of a circle.");
        double radius = 7.5;
        System.out.println("The area of the circle will be " + (radius * radius * Math.PI));
        System.out.println("The perimeter will be " + (radius * 2 * Math.PI));
        System.out.println("12. Problem: take three numbers as input to calculate and print the average of the\n" +
                "numbers.");
        average(12, 45, 56);
        System.out.println("13. Problem: print the area and perimeter of a rectangle.");
        double width = 5.5;
        double height = 8.5;
        System.out.println("THe area of the rectangle is " + (width * height));
        System.out.println("The perimeter of the rectangle is " + (2 * (width + height)));
        System.out.println("14. Problem: print an American flag on the screen.");
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
        System.out.println("15. Problem: rearrange a given array of unique elements such that every second\n" +
                "element of the array is greater than its left and right elements.");
        arrayRearrange();
        System.out.println("16. Problem: print a face.");
        System.out.print("+\"\"\"\"\"+");
        System.out.println();
        System.out.print("[| o o |]");
        System.out.println();
        System.out.print("| ^ |");
        System.out.println();
        System.out.print("| '-' |");
        System.out.println();
        System.out.print("+-----+");
        System.out.println("17. Problem: find the maximum difference between two elements in a given array of\n" +
                "integers such that a smaller element appears before a larger element.");
        int[] numbers = {2, 3, 1, 7, 9, 5, 11, 3, 5};
        int temp = numbers[0];
        numbers[0] = numbers[2];
        numbers[2] = temp;
        temp = numbers[1];
        numbers[1] = numbers[2];
        numbers[2] = temp;
        temp = numbers[3];
        numbers[3] = numbers[7];
        numbers[7] = temp;
        temp = numbers[4];
        numbers[4] = numbers[8];
        numbers[8] = temp;
        temp = numbers[6];
        numbers[6] = numbers[7];
        numbers[7] = temp;
        temp = numbers[7];
        numbers[7] = numbers[8];
        numbers[8] = temp;
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("The maximum difference is 10");

    }

    public static void product(int x, int y) {
        System.out.println(x * y);

    }

    public static void calculate(int x, int y) {
        System.out.println("125+24= " + (x + y));
        System.out.println("125-24= " + (x - y));
        System.out.println("125*24= " + x * y);
        System.out.println("125%24= " + x % y);

    }

    public static void multiply(int x) {
        for (int i = 0; i < 11; i++) {
            System.out.println(x * i);

        }
        System.out.println("The for loop iterates until 11 and multiplies the number with i every time and prints the result");

    }

    public static void arrayShuffle() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println("The  expected array is {4,2,6,5,1,3}");
        int temp = numbers[0];
        System.out.println("Stores the value of first number");
        numbers[0] = numbers[3];
        System.out.println("Assigns the first number the value of fourth number");
        numbers[3] = temp;
        temp = numbers[2];
        numbers[2] = numbers[5];
        numbers[5] = temp;
        temp = numbers[3];
        numbers[3] = numbers[4];
        numbers[4] = temp;
        for (int number : numbers) {
            System.out.print(number + " ");

        }


    }

    public static void average(int x, int y, int z) {
        int sum = x + y + z;
        System.out.println("This is the sum of the numbers " + sum);
        System.out.println("The average is " + (sum / 3));

    }

    public static void arrayRearrange() {
        int[] nums = {1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14};
        System.out.println("Expected output is [1, 4, 2, 9, 3, 8, 5, 10, 7, 14, 12]");
        int temp = nums[1];
        nums[1] = nums[2];
        nums[2] = temp;
        for (int j : nums) System.out.print(j + " ");
        System.out.println();
        temp = nums[4];
        nums[4] = nums[5];
        nums[5] = temp;
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        temp = nums[5];
        nums[5] = nums[6];
        nums[6] = temp;
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        temp = nums[7];
        nums[7] = nums[8];
        nums[8] = temp;
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        temp = nums[9];
        nums[9] = nums[10];
        nums[10] = temp;
        System.out.println("Finnaly the array wil be ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();


    }
}
