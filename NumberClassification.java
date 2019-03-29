/*
 * Nicholas Weber
 *computs 25 3 digits random numbers 
 *finds all the numbers 
 *finds all of the odd numbers 
 *finds all of the monotonic number
 *finds all of the paired number
 *finds all of the sum of the numbers 
 */
package review;

import java.util.ArrayList;
import java.util.Random;
import static review.LetterLines.randomAlphabet;

public class NumberClassification {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        RandoNum(a);
        System.out.println("The numbers...");
        NumbersPrint(a);
        System.out.println("");
        System.out.println("The odd numbers...");
        OddPrint(a);
        System.out.println("");
        System.out.println("The strictly monotonic numbers...");
        MonotonicNum(a);
        System.out.println("");
        System.out.println("The pairs...");
        PairNum(a);
        System.out.println("");
        System.out.println("The numbers by digit Sum...");
        digitSum(a);
        System.out.println("");
    }
    //genorates 25 random numbers 
    public static void RandoNum(ArrayList<Integer> a) {
        for ( int x = 0; x < 25; x++ ) {
            Random rand = new Random();
            int n = rand.nextInt(900) + 100;
            a.add(n);
        }
    }
    //prints all 25 numbers 
    public static void NumbersPrint(ArrayList<Integer> a) {
        for ( int i = 0; i < a.size(); i++ ) {
            System.out.print(a.get(i) + " ");
        }
    }
    //prints all odd numbers 
    public static void OddPrint(ArrayList<Integer> a) {
        for ( int i = 0; i < a.size(); i++ ) {
            if (a.get(i) % 2 != 0) {
                System.out.print(a.get(i) + " ");
            }
        }
    }
    //separates the int to 3 differnet than compares them 
    public static void MonotonicNum(ArrayList<Integer> a) {
        for ( int x = 0; x < a.size(); x++ ) {
            ArrayList<Integer> b = new ArrayList<>();
            int num = a.get(x);
            while (num > 0) {
                b.add(num % 10);
                num /= 10;
            }
            if (b.get(0) > b.get(1) && b.get(1) > b.get(2)) {
                System.out.print(a.get(x) + " ");
            } else if (b.get(0) < b.get(1) && b.get(1) < b.get(2)) {
                System.out.print(a.get(x) + " ");
            }
        }
    }
    //fix
    public static void PairNum(ArrayList<Integer> a) {
        for ( int x = 0; x < a.size(); x++ ) {
            ArrayList<Integer> c = new ArrayList<>();
            int num = a.get(x);
            while (num > 0) {
                c.add(num % 10);
                num /= 10;
            }
            if ( c.get(0) == c.get(1) || c.get(1) == c.get(2) || c.get(0) == c.get(2) ) {
                System.out.print(a.get(x) + " ");
            }
        }
    }
    // uses arraylist that corresponds with the sum arraylist to add to another arraylist than sorts that arraylist 
    public static void digitSum(ArrayList<Integer> a) {
        ArrayList<Integer> E = new ArrayList<>();
        for ( int x = 0; x < a.size(); x++ ) {
            ArrayList<Integer> D = new ArrayList<>();
            int num = a.get(x);
            while ( num > 0 ) {
                D.add(num % 10);
                num /= 10;
            }
            E.add(D.get(0) + D.get(1) + D.get(2));

        }
        for ( int i = 1; i < 27; i++ ) {
            ArrayList<Integer> F = new ArrayList<>();
            for ( int j = 0; j < 25; j++ ) {
                if (E.get(j) == i) {
                    F.add((a.get(j)));
                }
            }
            if (F.isEmpty()) {
                System.out.print("");
            } else {
                System.out.print("{ ");
                for (int t : F) {
                    System.out.print(t + " ");
                }
                System.out.println("}");
            }
        }

    }
}
