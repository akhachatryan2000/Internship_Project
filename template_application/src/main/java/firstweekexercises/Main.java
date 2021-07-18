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
        System.out.println("18. Problem: find a subarray which has the largest sum in a given circular array of\n" +
                "integers.");
        toBinary(5);
        System.out.println("19. Problem: convert a decimal number to a binary number.");
        decimalToBinary(5);
        System.out.println();
        System.out.println("20. Problem: convert a decimal number to hexadecimal number.");
        decimalToHexadecimal(15);
        System.out.println("21. Problem: convert a decimal number to an octal number.");
        decimalToOctal(15);
        System.out.println("22. Problem: convert a binary number to a decimal number.");
        binaryToDecimal("100");
        System.out.println("23. Problem: convert a binary number to hexadecimal number.");
        binaryToHexadecimal("1101");
        System.out.println("24. Problem: convert a binary number to an Octal number.");
        binaryToOctal("111");
        System.out.println("25. Problem: convert an octal number to a decimal number.");
        octalToDecimal("10");
        System.out.println("26. Problem: convert an octal number to a binary number.");
        octalToBinary("7");
        System.out.println();
        System.out.println("27. Problem: convert an octal number to a hexadecimal number.");
        octalToHexadecimal("100");
        System.out.println();
        System.out.println("28. Problem: convert a hexadecimal to a decimal number.");
        hexaToDecimal("25");
        System.out.println("29. Problem: convert a hexadecimal to a binary number.");
        System.out.println();
        hexadecimalToBinary("37");
        System.out.println("30. Problem: convert a hexadecimal to an octal number.");
        hexaToOctal("40");
        System.out.println("31. Problem: find minimum subarray sum of specified size in a given array of\n" +
                "integers.");
        System.out.println("?????");
        System.out.println("32. Problem: compare two numbers.");
        compare(25, 39);
        System.out.println("33. Problem: compute the sum of the digits of an integer.");
        sumOfDigits(25);
        System.out.println("34. Problem: accept four integers from the user and prints equal if all four are equal,\n" +
                "and not equal otherwise.");
        checkEqual(25, 37, 45, 23);
        System.out.println("35. Problem: accept two double variables and test if both strictly between 0 and 1\n" +
                "and false otherwise.");
        between(5, 1);
        System.out.println("36. Problem: print the contents of a two-dimensional Boolean array where “t” will\n" +
                "represent true and “f”will represent false.");
        boolean[][] array = {{true, false, true}, {false, true, false}};
        for (boolean[] booleans : array) {
            System.out.println();
            for (int j = 0; j < booleans.length; j++) {
                System.out.print(booleans[j] + " ");
            }

        }
        System.out.println("37. Problem: print an array after changing the rows and columns of a given\n" +
                "two-dimensional array.");
        int[][] arr = {{10, 20, 30}, {40, 50, 60}};
        int[][] array1 = {{10, 40}, {20, 50}, {30, 60}};
        arr = array1;
        for (int[] ints : array1) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(anInt + " ");

            }

        }
        System.out.println();
        System.out.println("38. Problem: create a two-dimensional array (m x m) A[][] such that A[i][j] is true if I\n" +
                "and j are prime and have no common factors, otherwise A[i][j] becomes false.");
        int[][] prime = {{1, 2, 3}, {4, 5, 6}};
        for (int i = 0; i < prime.length; i++) {
            System.out.println();
            for (int j = 0; j < prime[i].length; j++) {
                if (i == j) {
                    System.out.print(false + " ");
                } else {
                    System.out.print(true + " ");
                }

            }

        }
        System.out.println();
        System.out.println("39. Problem: find the k largest elements in a given array. Elements in the array can be\n" +
                "in any order.");
        System.out.println("43.find the numbers greater than the average of the numbers of a given\n" +
                "array.");
        greaterThanAverage();
        System.out.println();
        System.out.println("43. Problem: that will accept an integer and convert it into a binary representation.\n" +
                "Now count the number of bits which is equal to zero of the said binary\n" +
                "representation.");
        toBinaryRep(25);
        System.out.println();
        System.out.println("44. Problem: divide the two given integers using subtraction operators.");
        System.out.println(divide(625, 25));
        System.out.println("45. Problem: move every positive number to the right and every negative number to\n" +
                "the left of a given array of integers.");
        moveArray(new int[]{-2, 3, 4, -1, -3, 1, 2, -4, 0});
        zeroToRight();
        System.out.println("48. Problem: print the odd numbers from 1 to 99. Prints one number per line.");
        printOddNumbers();
        System.out.println("49. Problem: accept a number and check if the number is even or not. Prints 1 if the\n" +
                "number is even or 0 if the number is odd.");
        evenOddCheck(20);
        System.out.println("50. Problem: print numbers between 1 to 100 which are divisible by 3, 5 and by both.");
        divisible();
        System.out.println();
        System.out.println("51. Problem: convert a string to an integer in Java.");
        stringToInteger("25");
        System.out.println();
        System.out.println("52. Problem: calculate the sum of two integers and return true if the sum is equal to a\n" +
                "third integer.");
        System.out.println(sumOfIntegers(5, 10, 15));
        System.out.println("53. Problem: that accepts three integers from the user and returns true if the second\n" +
                "number is greater than the first number and the third number is greater than the\n" +
                "second number. If \"abc\" is true, the second number does not need to be greater than\n" +
                "the first number.");
        System.out.println(compareNumbers(5, 10, 15));
        System.out.println("54. Problem: that accepts three integers from the user and returns true if two or more\n" +
                "of them (integers ) have the same rightmost digit. The integers are non-negative.");
        System.out.println(rightmost(5, 10, 15));
        System.out.println("55. Problem: multiply two given integers without using the multiply operator(*).");
        multiply(25, 5);
        System.out.println("56. Problem: find the number of integers within the range of two specified numbers\n" +
                "and that are divisible by another number.");
        System.out.println(range(5, 20));
        System.out.println("57. Problem: reverse the content of a sentence (assume a single space between two\n" +
                "words) without reversing every word.");
        reverse();
        System.out.println("58. Problem: find the length of the longest consecutive sequence of a given array of\n" +
                "integers.");
        System.out.println("????");
        System.out.println("Problem: accept two strings and test if the second string contains the first one.");
        System.out.println(stringCheck()); ////????
        System.out.println("60. Problem: find the penultimate (next to last) word of a sentence.");
        penultimate();
        System.out.println("61. Problem: reverse a word.");
        reverseWord("dsaf");
        System.out.println();
        System.out.println("62. Problem: accept three integer values and return true if one of them is 20 or more\n" +
                "and less than the subtractions of others.");
        System.out.println(sub(15, 20, 25));
        System.out.println("63. Problem: accept two integer values from the user and return the larger values.\n" +
                "However if the two values are the same, return 0 and return the smaller value if the\n" +
                "two values have the same remainder when divided by 6.");
        System.out.println(mix(12, 13));
        System.out.println("accept two integer values between 25 to 75 and return true if there is a\n" +
                "common digit in both numbers.");
        System.out.println(num(25, 75));
        System.out.println("65. Problem: calculate the modules of two numbers without using any inbuilt\n" +
                "modulus operator.");
        modul(19, 7);
        System.out.println("66. Problem: compute the sum of the first 100 prime numbers.");
        sumOfPrimes();
        System.out.println("67. Problem: insert a word in the middle of another string.");
        stringInsert();
        System.out.println();
        System.out.println("68. Problem: create a new string of 4 copies of the last 3 characters of the original\n" +
                "string. The length of the original string must be 3 and above.");


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

    public static void toBinary(int decimal) {
        String s = Integer.toBinaryString(5);
        System.out.println(s);

    }

    public static void compare(int x, int y) {
        if (x == y) {
            System.out.println("25=39");
        } else
            System.out.println("25!=39");
        if (x < y) {
            System.out.println("39>25");
        }
        if (x <= 39) {
            System.out.println("25<=39");
        }


    }


    public static void decimalToBinary(int number) {
        int i = 0;
        int binary[] = new int[100];
        while (number != 0) {
            binary[i] = number % 2;
            number = number / 2;
            i++;
        }
        System.out.println("Binary value is ");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binary[j] + " ");

        }
    }

    public static void decimalToHexadecimal(int decimal) {
        int remainder;
        int i = 0;
        char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexaValue = new char[100];
        while (decimal > 0) {
            remainder = decimal % 16;
            hexaValue[i] = hexa[remainder];
            decimal = decimal / 16;
            i++;

        }
        System.out.println("Hexavalue is ");
        for (int j = i - 1; j >= 0; j--) {
            System.out.println(hexaValue[j]);

        }


    }

    public static void decimalToOctal(int decimal) {
        int i = 0;
        int[] oct = new int[100];
        while (decimal > 0) {
            oct[i] = decimal % 8;
            decimal = decimal / 8;
            i++;
        }
        System.out.println("The octal will be");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(oct[j]);
        }


    }

    public static void binaryToDecimal(String binaryNumber) {
        int number = 0b100;
        System.out.println();
        System.out.println(number);
        int decimal = Integer.parseInt(binaryNumber, 2);
        System.out.println("DEcimal number is " + decimal);
    }

    public static void binaryToHexadecimal(String num) {
        int decimal = Integer.parseInt(num, 2);
        int i = 0;
        char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexaValue = new char[100];
        while (decimal > 0) {
            int remainder = decimal % 16;
            hexaValue[i] = hexa[remainder];
            decimal = decimal / 16;
            i++;
        }

        System.out.println("The hexa number will be");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(hexaValue[j]);
        }


    }

    public static void binaryToOctal(String binary) {
        int decimal = Integer.parseInt(binary, 2);
        int[] oct = new int[100];
        int i = 0;

        while (decimal > 0) {
            oct[i] = decimal % 8;
            decimal = decimal / 8;
            i++;

        }
        System.out.println("The octal will be");
        for (int j = i - 1; j >= 0; j--) {
            System.out.println(oct[j]);

        }


    }

    public static void octalToDecimal(String octal) {
        int decimal = Integer.parseInt(octal, 8);
        System.out.println(decimal);

    }

    public static void octalToBinary(String octal) {
        int decimal = Integer.parseInt(octal, 8);
        int i = 0;
        int[] binary = new int[100];
        while (decimal > 0) {
            binary[i] = decimal % 2;
            decimal = decimal / 2;
            i++;

        }
        System.out.println("The binary will be");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binary[j]);

        }

    }

    public static void octalToHexadecimal(String octal) {
        int decimal = Integer.parseInt(octal, 8);
        char[] hexa = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] hexaValue = new char[100];
        int remainder;
        int i = 0;
        while (decimal > 0) {
            remainder = decimal % 16;
            hexaValue[i] = hexa[remainder];
            decimal = decimal / 16;
            i++;

        }
        System.out.println("The hexadecimal wil be");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(hexaValue[j]);

        }

    }

    public static void hexaToDecimal(String hexa) {
        int decimal = Integer.parseInt(hexa, 16);
        System.out.println(decimal);

    }

    public static void hexadecimalToBinary(String hexa) {
        int decimal = Integer.parseInt(hexa, 16);
        int i = 0;
        int[] binary = new int[100];
        while (decimal > 0) {
            binary[i] = decimal % 2;
            decimal = decimal / 2;
            i++;
        }
        System.out.println("The binary will be");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binary[j]);

        }


    }

    public static void hexaToOctal(String hexa) {
        int decimal = Integer.parseInt(hexa, 16);
        int i = 0;
        int[] oct = new int[100];
        while (decimal > 0) {
            oct[i] = decimal % 8;
            decimal = decimal / 8;
            i++;
        }
        System.out.println("The octal will be");
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(oct[j]);
        }

    }

    public static void sumOfDigits(int number) {
        int remainder = 0;
        int sum = 0;
        while (number > 0) {
            remainder = number % 10;
            sum = sum + remainder;
            number = number / 10;
        }
        System.out.println(sum);
    }

    public static void checkEqual(int x, int y, int z, int l) {
        if (x == y && y == z && z == l) {
            System.out.println("The digits are equal");
        } else {
            System.out.println("The digits are not equal");
        }

    }

    public static void between(double x, double y) {
        if (x > 0 && x < 1 && y > 0 && y < 1) {
            System.out.println("Between 0 and 1");
        } else {
            System.out.println("False");
        }

    }

    public static void klargest(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            System.out.println(arr[i]);

        }


    }

    public static void greaterThanAverage() {
        int[] numbers = {1, 4, 17, 7, 25, 3, 100};
        int average = 0;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        average = sum / numbers.length;
        System.out.println(average);
        int[] greater = new int[7];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > average) {
                greater[i] = numbers[i];
                System.out.print(greater[i] + " ");
            }

        }

    }

    public static void toBinaryRep(int number) {
        int[] binary = new int[100];
        int i = 0;
        int count = 0;
        while (number > 0) {
            binary[i] = number % 2;
            number = number / 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binary[j] + " ");
            if (binary[j] == 0) {
                count++;


            }
        }
        System.out.println("The number of bits that are equal to zero is " + count);

    }

    public static float divide(int dividend, int divider) {
        if (divider == 0) {
            return 0;
        }
        float result = 0;
        while (dividend > divider) {
            dividend -= divider;
            result++;
        }
        float decimalPart = (float) dividend / (float) divider;
        result = result + decimalPart;
        return result;

    }

    public static int[] moveArray(int[] nums) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
        return nums;

    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    public static void zeroToRight() {
        int[] nums = {0, 3, 4, 0, 1, 2, 5, 0};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        boolean swap = true;
        int temp;
        while (swap) {
            swap = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] != 0) {
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swap = true;
                }
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
    }

    public static void printOddNumbers() {
        int n = 99;
        while (n > 0) {
            if (n % 2 == 1) {
                System.out.println(n);
            }
            n--;
        }


    }

    public static void evenOddCheck(int number) {
        if (number % 2 == 0) {
            System.out.println("The number is even");
        } else if (number % 2 == 1) {
            System.out.println("The number is odd");
        }
    }

    public static void divisible() {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }

        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.print(i + " ");

            }

        }

    }

    public static void stringToInteger(String input) {

        Integer num = Integer.parseInt(input);
        System.out.println(num);

    }

    public static boolean sumOfIntegers(int x, int y, int z) {
        int sum = x + y;
        return sum == z;
    }

    public static boolean compareNumbers(int x, int y, int z) {
        if (y > x && z > y) {
            return true;
        }

        return true;


    }

    public static boolean rightmost(int x, int y, int z) {
        return (x % 10 == y % 10) || (x % 10 == z % 10) || (y % 10 == z % 10);

    }

    public static void multiply(int x, int y) {
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum = sum + y;
        }
        System.out.println(sum);
    }

    public static int range(int x, int y) {
        int p = 3;
        int numbers = y - x + 1;
        if (x % p == 0) {
            return (y / p - x / p + 1);
        }
        return (y / p - x / p);
    }

    public static void reverse() {
        String sentence = "The quick brown fox jumps over the lazy dog";
        String[] sen = "The quick brown fox jumps over the lazy dog".split(" ");
        for (int i = sen.length - 1; i >= 0; i--) {
            System.out.print(sen[i] + " ");
        }
    }

    public static void array() {
        int[] array = {1, 1, 2, 3, 3, 4, 5, 2, 4, 5, 6, 7, 8, 9, 6, -1, -2};
    }

    public static boolean stringCheck() {
        String str1 = "Once in a blue moon";
        String str2 = "See eye to eye";
        boolean flag = false;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(0)) {
                for (int j = 0; j < str1.length(); j++) {
                    if ((i + j) < str2.length() && str1.charAt(j) == str2.charAt(i + j) && j == str1.length() - 1) {
                        flag = true;
                        break;

                    }

                }
            }
        }
        return true;
    }

    public static void penultimate() {
        String sentence = "The quick brown fox jumps over the lazy dog.";
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            if (i == words.length - 2) {
                System.out.print(words[i]);
            }


        }

    }

    public static void reverseWord(String word) {
        char[] w = word.toCharArray();
        for (int i = w.length - 1; i >= 0; i--) {
            System.out.print(w[i]);

        }

    }

    public static boolean sub(int x, int y, int z) {
        return Math.abs(x - y) >= 20 || Math.abs(y - z) >= 20 || Math.abs(z - x) >= 20;
    }

    public static int mix(int first, int second) {
        if (first == second)
            return 0;
        if (first % 6 == second % 6)
            return (first < second) ? first : second;
        return (first > second) ? first : second;
    }

    public static boolean num(int x, int y) {
        if (x < 25 || y > 75)
            return false;
        int rem = x % 10;
        int rem1 = y % 10;
        x /= 10;
        y /= 10;
        return (rem == rem1 || x == y);
    }

    public static void modul(int x, int y) {
        int divided = x / y;
        int remainder = x - (divided * y);
        System.out.println(remainder);
    }

    public static void sumOfPrimes() {
        int sum = 0;
        int count = 0;
        int i = 3;
        while (isPrime(i)) {
            sum = sum + i;
            i++;
        }
        System.out.println(sum);

    }


    public static boolean isPrime(int n) {
        boolean prime = true;
        int i = 2;
        while (i <= n / 2) {
            if (n % i == 0) {
                prime = false;
                break;
            }
            i++;
        }
        return prime;

    }

    public static void stringPermutation() {
        String s1 = "xxyz";
        String s2 = "yxzx";
        int[] arr = new int[100];
        for (int i = 0; i < s1.length(); i++) {
            arr[(int) s1.charAt(i)] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr[(int) s2.charAt(i)] -= 1;
        }
        for (int j : arr) {
            if (j != 0) {
                System.out.println(false);
            }
        }

    }

    public static void stringInsert() {
        String s = "Python 3.0";
        String insert = "Tutorial";
        String[] s1 = new String[3];
        s1[0] = "Python";
        s1[1] = null;
        s1[2] = "3.0";
        String[] inserted = s1;
        for (int i = 0; i < inserted.length; i++) {
            if (i == 1) {
                inserted[1] = "Tutorial";
            }
            System.out.print(inserted [i] + " ");

        }
    }

    public static  void lastString() {
        String main="Python 3.0";

    }
}










