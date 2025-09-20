package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        *             *
//        * *         * *
//        * * *     * * *
//        * * * * * * * *
//        * * * * * * * *
//        * * *     * * *
//        * *         * *
//        *             *

//        int rows = 8;
//
//        //Upper pattern
//        for (int i = 1; i <= rows / 2; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");  //Don't use println because we have to print star in same line
//            }
//            for (int spaces = rows / 2; spaces > i; spaces--) {
//                System.out.print("    ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println(); //Use println because we have to move to next line when first row is completed
//        }
//
//        //Lower pattern
//        for (int i = 1; i <= rows / 2+1; i++) {
//            for (int j = rows / 2; j >= i; j--) {
//                System.out.print("* ");
//            }
//            for (int spaces = 1; spaces <= i - 1; spaces++) {
//                System.out.print("    ");  //Don't use println because we have to print star in same line
//            }
//            for (int j = rows / 2 + 1; j > i; j--) {
//                System.out.print("* ");  //Don't use println because we have to print star in same line
//            }
//            System.out.println();
//        }
//    }

//          *
//        * *
//      * * *
//    * * * *
//      * * *
//        * *
//          *

//        int rows = 9;
//        for (int i = 1; i <= rows/2; i++) {
//            for (int spaces = rows/2; spaces > i; spaces--) {
//                System.out.print("  ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 1; i <= rows/2; i++) {
//            for (int spaces = 1; spaces <= i; spaces++) {
//                System.out.print("  ");  //Don't use println because we have to print star in same line
//            }
//
//            for (int j = rows /2; j > i; j--) {
//                System.out.print("* ");  //Don't use println because we have to print star in same line
//            }
//            System.out.println();
//        }
//    }


//            *
//            * *
//            * * *
//            * * * *
//            * * *
//            * *
//            *

//        int rows = 7;
//        for (int i = 1; i <= rows / 2 + 1; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");  //Don't use println because we have to print star in same line
//            }
//            System.out.println(); //Use println because we have to move to next line when first row is completed
//        }
//
//        for (int i = 1; i <= rows / 2 + 1; i++) {
//            for (int j = rows / 2; j >= i; j--) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }

//                     *
//                    ***
//                   *****
//                  *******
//                 *********
//                ***********
//                 *********
//                  *******
//                   *****
//                    ***
//                     *
//
//        int rows = 11;
//        for (int i = 1; i <= rows / 2 + 1; i++) {
//            for (int spaces = rows / 2 + 1; spaces > i; spaces--) {
//                System.out.print("  ");
//            }
//            for (int stars = 1; stars <= i; stars++) {
//                System.out.print("*   ");
//            }
//            System.out.println();
//        }
//
//        for (int i = 1; i <= rows / 2 + 1; i++) {
//            for (int spaces = 1; spaces <= i; spaces++) {
//                System.out.print("  ");  //Don't use println because we have to print star in same line
//            }
//
//            for (int j = rows / 2 + 1; j > i; j--) {
//                System.out.print("*   ");  //Don't use println because we have to print star in same line
//            }
//            System.out.println(); //Use println because we have to move to next line when first row is completed
//        }
//    }

//        6 5 4 3 2 1 2 3 4 5 6
//          5 4 3 2 1 2 3 4 5
//            4 3 2 1 2 3 4
//              3 2 1 2 3
//                2 1 2
//                  1

//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = 1; spaces <= i; spaces++) {
//                System.out.print("  ");  //Don't use println because we have to print star in same line
//            }
//            for (int j = rows , k = rows - i + 1; j > i; j--, k--) {
//                System.out.print(k+ " ");  //Don't use println because we have to print star in same line
//            }
//            for (int j = rows, k = 1; j >= i; j--, k++) {
//                System.out.print(k + " ");
//            }
//            System.out.println();
//        }
//    }


//        1 2 3 4 5 6
//         2 3 4 5 6
//          3 4 5 6
//           4 5 6
//            5 6
//             6
//
//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = 1; spaces <= i; spaces++) {
//                System.out.print(" ");
//            }
//            for (int numbers = rows, k = i; numbers >= i; numbers--, k++) {
//                System.out.print(k + " ");  //Don't use println because we have to print star in same line
//            }
//            System.out.println();
//        }
//    }

//        * * * * * *
//         * * * * *
//          * * * *
//           * * *
//            * *
//             *
//
//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = 1; spaces <= i; spaces++) {
//                System.out.print(" ");  //Don't use println because we have to print star in same line
//            }
//
//            for (int j = rows; j > i; j--) {
//                System.out.print("* " );  //Don't use println because we have to print star in same line
//            }
//            System.out.println(); //Use println because we have to move to next line when first row is completed
//        }
//    }

//                  1
//                2 1 2
//              3 2 1 2 3
//            4 3 2 1 2 3 4
//          5 4 3 2 1 2 3 4 5
//        6 5 4 3 2 1 2 3 4 5 6

//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = rows; spaces > i; spaces--) {
//                System.out.print("  ");
//            }
//            for (int j = 1, k = i; j <= i; j++, k--) {
//                System.out.print(k+ " ");
//            }
//
//            for (int j = 2; j <= i; j++) {
//                System.out.print(j+" ");
//            }
//            System.out.println();
//
//        }
//    }

//             1
//            2 2
//           3 3 3
//          4 4 4 4
//         5 5 5 5 5
//        6 6 6 6 6 6
//
//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = rows; spaces > i; spaces--) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//    }

//             *
//            * *
//           * * *
//          * * * *
//         * * * * *
//        * * * * * *
//
//        int rows = 5;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = rows; spaces > i; spaces--) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//    }

//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = rows; spaces > i; spaces--) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= (2 * i) - 1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }


//        654321
//         54321
//          4321
//           321
//            21
//             1

//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = 1; spaces <= i; spaces++) {
//                System.out.print(" ");  //Don't use println because we have to print star in same line
//            }
//
//            for (int j = rows + 1, k = rows - i + 1; j > i; j--, k--) {
//                System.out.print(k);  //Don't use println because we have to print star in same line
//            }
//            System.out.println(); //Use println because we have to move to next line when first row is completed
//        }
//    }

//        ******
//         *****
//          ****
//           ***
//            **
//             *
//
//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = 1; spaces <= i; spaces++) {
//                System.out.print(" ");  //Don't use println because we have to print star in same line
//            }
//
//            for (int j = rows; j > i; j--) {
//                System.out.print("*");  //Don't use println because we have to print star in same line
//            }
//            System.out.println(); //Use println because we have to move to next line when first row is completed
//        }
//    }


//            1
//           21
//          321
//         4321
//        54321

//        int rows = 5;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = rows; spaces > i; spaces--) {
//                System.out.print(" ");
//            }
//            for (int j = 1, k = i; j <= i; j++, k--) {
//                System.out.print(k);
//            }
//            System.out.println();
//        }
//    }

//                 *
//                **
//               ***
//              ****
//             *****
//            ******
//
//        int rows = 5;
//        for (int i = 1; i <= rows; i++) {
//            for (int spaces = rows; spaces > i; spaces--) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }

//        1 2 3 4 5 6
//        1 2 3 4 5
//        1 2 3 4
//        1 2 3
//        1 2
//        1
//
//        int rows = 6;
//        for (int i = 1; i <= rows; i++) {
//            for (int j = rows, k = 1; j >= i; j--, k++) {
//                System.out.print(k + " ");
//            }
//            System.out.println();
//        }
//    }

//                    *****
//                    ****
//                    ***
//                    **
//                    *

//        int rows = 5;
//        for (int i = 1; i <= rows; i++) {
//            for (int j = rows; j >= i; j--) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }

//        1
//        1 2
//        1 2 3
//        1 2 3 4
//        1 2 3 4 5
//
//        int rows = 5;
//
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
//    }

//                *
//                * *
//                * * *
//                * * * *
//
//        int rows = 4;
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print("*");  //Don't use println because we have to print star in same line
//                System.out.print("\t");
//            }
//            System.out.println(); //Use println because we have to move to next line when first row is completed
//        }
//    }

//        //Swap with temp variable
//        int a = 5;
//        int b = 7;
//
//        System.out.println("Before swap a : " + a);
//        System.out.println("Before swap b : " + b);
//
//        a = a + b; //12
//        b = a - b; //5
//        a = a - b; //7
//
//        System.out.println("After swap a : " + a);
//        System.out.println("After swap b : " + b);
//    }
//        //Sorting in ascending and decending order
//        int[] a = {3, 6, 2, 4, 1, 7};
//        int temp;
//
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//
//                if (a[i] > a[j]) {  // for decending order change operator to <
//                    //swap
//                    temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            System.out.println("Ascending order Array: " + a[i]);
//        }
//    }
//        //Compare 2 arrays and create another array with matching elements
//        int[] a = {3, 4, 7, 6, 9};  //If we know all values
//        int[] b = {1, 4, 2, 7, 9};
//        int[] c = new int[4];   //If we don't know values and just know the size
//        ArrayList<Integer> d = new ArrayList<>();  //If we don't know exact size and it is dynamic
//
//        for (int i = 0; i <= a.length - 1; i++) {
//            if (a[i] == b[i]) {
//                d.add(a[i]);
//            }
//        }
//        System.out.println("New Array: " + d);
//    }


//        //Find max difference between adjacent numbers
//        int[] a = {2, 6, 4, 8, 13, 6, 8, 9}; //4, -2, 4, 5, -7, 2, 1 //5 is max difference
//        int diff = 0;
//
//        for (int i = 0; i < a.length - 1; i++) {
//
//            if (a[i + 1] - a[i] > diff) {
//                diff = a[i + 1] - a[i];
//            }
//        }
//
//        System.out.println("Max difference: " + diff);
//    }

//        Reverse words

//        String str = "I hate myself";
//        String [] reverse = null;
//        String mainString = " ";
//
//        reverse = str.split(" ");


        //Print frequency of numbers in array
//        int arr[] = {1, 2, 2, 3, 4, 3, 2, 3};
//        for (int i = 0; i <= arr.length - 1; i++) {
//            int count = 1;
//            boolean countedalready = false;
//
//            for (int k = 0; k < i; k++) {
//                if (arr[i] == arr[k]) {
//                    countedalready = true;
//                    break;
//                }
//            }
//
//            if (countedalready) continue;
//
//            for (int j = i + 1; j <= arr.length - 1; j++) {
//                if (arr[i] == arr[j]) {
//                    count++;
//                }
//            }
//            System.out.println(arr[i] + " : " + count);
//        }


//        //Print duplicates of int array
//        int[] arr = new int[]{1, 2, 3, 3, 2};
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] == arr[j]) {
//                    System.out.println(arr[j]);
//                }
//            }
//        }


        //Print duplicates in string
//        String S ="fddfddsss";
//        String t = "";
//        for (int i = 0; i < S.length(); i++) {
//            for (int j = i + 1; j < S.length(); j++) {
//                if (S.charAt(i) == S.charAt(j) && !t.contains(S.charAt(j) + "")) {
//                    t = t + S.charAt(j);
//                }
//            }
//        }
//        System.out.println(t);


        //Print Characters first and then special characters
//        String input = "R^*E$S&T";
//        String schar = " ";
//        String str = " ";
//        char ch;
//        for (int i = 0; i < input.length(); i++) {
//            ch = input.charAt(i);
//            if (!Character.isDigit(ch) &&
//                    !Character.isLetter(ch) &&
//                    !Character.isWhitespace(ch)) {
//                str = ch + str;
//            } else {
//                schar = ch + schar;
//            }
//        }
//        System.out.print(schar.trim() + str.trim());
//    }

////  Find min number in 3 dimentional array
//
//        int[][] abc = {{2, 5, 4}, {2, 8, 5}, {5, 8, 7}};
//        int max = abc[0][0];
//
//        for (int row = 1; row < 3; row++) {
//            for (int column = 1; column < 3; column++) {
//                if (abc[row][column] > max) {
//                    max = abc[row][column];
//                }
//            }
//        }
//        System.out.println(max + " is max number");
//    }

////    Prime Number
//        // Logic --> remainder > 0 is prime number
//
//        int num = 29;
//        boolean flag = false;
//
//        for (int i = 2; i <= num / 2; i++) {
//            if (num % i == 0) {
//                flag = true;
//                break;
//            }
//        }
//
//        if (flag)
//            System.out.println(num + " is not a prime number.");
//        else {
//            System.out.println(num + " is a prime number.");
//        }
//    }


        //Reverse of Number
//        int n = 371, rem, reverse = 0;
//
//        while (n != 0) {
//            rem = n % 10;
//            reverse = rem + reverse * 10;
//            n = n / 10;
//        }
//
//        System.out.println(reverse);


        //Armstrong number
//        int n = 371, n2, rem, result = 0;
//        n2 = n;
//
//        while (n2 != 0) {
//            rem = n2 % 10;
//            result = result + rem * rem * rem;
//            n2 = n2 / 10;
//        }
//
//        if (result == n) {
//            System.out.println("armstrong");
//        } else {
//            System.out.println("not armstrong");
//        }
//    }


////        Reverse of string/ String Palindrome
//        String str1 = "ramya";
//        String str2 = " ";
//        char ch;
//
//        for (int i = 0; i < str1.length(); i++) {
//            ch = str1.charAt(i);
//            str2 = ch + str2;
//        }
//
//        System.out.println(str2);
//
//        if(str1==(str2)) {
//            System.out.println("palindrome");
//        } else {
//            System.out.println("not palindrome");
//        }
//    }


////    Fibonacci series
//        //0,1,1,2,3,5,8,13.......................
//        int n1 = 0, n2 = 1, n3, count = 10;
//        System.out.print(n1 + " " + n2);
//
//        for (int i = 2; i < count; i++) {
//            n3 = n1 + n2;
//            System.out.print(" " + n3);
//            n1 = n2;
//            n2 = n3;
//        }
//    }


        //Count digits of number
//        int number = 3456, digits = 0;
//
//        while (number != 0) {
//            number = number / 10;
//            digits++;
//        }
//        System.out.println(digits);
//    }
//}

////        Print of numbers in a array
//        int[] a = {3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8};
//
//        ArrayList<Integer> a1 = new ArrayList<Integer>();
//
//        for (int i = 0; i < a.length; i++) {
//            int k = 0;
//
//            if (!a1.contains(a[i])) {
//                a1.add(a[i]);
//                k++;
//                for (int j = i + 1; j < a.length; j++) {
//                    if (a[i] == a[j]) {
//                        k++;
//                    }
//                }
//                //Occurance of each element
//                System.out.println(a[i] + " occured " + k + " times");
//
//                //Unique elements
//                if (k == 1) {
//                    System.out.println(a[i]);
//                }
//
//                // Duplicate elements in array
//                if (k > 1) {
//                    System.out.println(a[i]);
//                }
//            }
//        }
//    }

        //Factorial
//        4! = 4*3*2*1
//        int n = 4;
//        int result = 1;
//
//        for (int i = 1; i <= n; i++) {
//            result = result * i;
//        }
//        System.out.println(result);
    }
}