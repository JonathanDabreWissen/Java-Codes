// package UtilPackage;
import java.util.*;


public class UtilDemo {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1); 
        System.out.println(d1.getTime());
        // d1.setTime(1234567899998L);
        System.out.println(d1);

        Date d2 = new Date();
        d2.setTime(-999993992347L);
        System.out.println(d2);

        d1.setMonth(15);
        System.out.println(d1);
        System.out.println(1900 + d1.getYear());

        Stack s1 = new Stack();

        s1.push("111");
        s1.push("222");
        s1.push("333");
        s1.push("444");
        s1.push("555");

        System.out.println(s1.pop());
        System.out.println(s1.peek());

        System.out.println(s1.empty());
        System.out.println(s1.search("222"));
        System.out.println(s1.search("111"));
        System.out.println(s1.search("777"));


        System.out.println("------------------");

        // Calendar c1 = new Calendar(); //-> we cannot do this, since calendar class is abstract class
        GregorianCalendar cg = new GregorianCalendar(); // Extends Calendar class.

        System.out.println("-------------------");

        BitSet b1 = new BitSet(16);
        BitSet b2 = new BitSet(16);

        
        for(int i = 0; i<16; i++){
            if(i%3==0){
                b1.set(i);
            }
            
            if(i%4==0){
                b2.set(i);
            }
        }
        
        System.out.println(b1);
        System.out.println(b2);

        // b1.and(b2);
        // b1.or(b2);
        b1.xor(b2);
        System.out.println(b1);


    }
}


/*
********Contents of Util Package********
Scanner
Random
Date
Stack 
Calendar 
Gregoriancalendar
BitSet

ArrayList 
LinkedList
HashSet
HashMap
TreeMap
TreeSet
LinkedHashSet
PriorityQueue
collections

Enumeration
Iterator
Comparator


*/