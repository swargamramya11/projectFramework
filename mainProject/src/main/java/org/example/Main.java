package org.example;

public class Main {
    public static void main(String[] args) {

//        Reverse words

        String str = "I hate myself";
        String [] reverse = null;
        String mainString = " ";

        reverse = str.split(" ");



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


        //Prime Number
//        int num = 29;
//        boolean flag = false;
//
//        // 0 and 1 are not prime numbers
//        if (num == 0 || num == 1) {
//            flag = true;
//        }
//
//        for (int i = 2; i <= num / 2; ++i) {
//
//            // condition for nonprime number
//            if (num % i == 0) {
//                flag = true;
//                break;
//            }
//        }
//
//        if (!flag)
//            System.out.println(num + " is a prime number.");
//        else {
//            System.out.println(num + " is not a prime number.");
//        }


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


        //Reverse of string/ String Palindrome
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


        //Fibonacci series
//        int n1 = 0, n2 = 1, n3, count = 10;
//        System.out.print(n1 + " " + n2);
//
//        for (int i = 2; i < count; i++) {
//            n3 = n1 + n2;
//            System.out.print(" " + n3);
//            n1 = n2;
//            n2 = n3;
//        }


        //Count digits of number
//        int number = 3456, digits = 0;
//
//        while(number!=0){
//            number = number / 10;
//            digits++;
//        }
//        System.out.println(digits);
    }
}