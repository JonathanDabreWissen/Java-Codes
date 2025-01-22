//package CollectionFramework;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import java.util.Date;
import java.util.TreeSet;
import java.util.*;

public class DemoCollectionFramework {
    public static void main(String[] args) {
        Vector v1 = new Vector();

        v1.add("Hello");
        v1.add(2324);
        v1.add(new Date());
        v1.add(new Thread());
        v1.add(324.33);

        Enumeration e = v1.elements();

        while(e.hasMoreElements()){

            System.out.println(e.nextElement());
        }

        System.out.println("----------------------");

        // HashSet obj = new HashSet();
        // TreeSet obj = new TreeSet();
        // LinkedHashSet obj = new LinkedHashSet();
        // ArrayList obj = new ArrayList();
        LinkedList<String> obj = new LinkedList();

        obj.add("111");
        obj.add("222");
        obj.add("333");
        obj.add("444");
        obj.add("555");
        // obj.addFirst("000");
        obj.addLast("999");
        obj.add("333");

        Iterator i = obj.iterator();

        while(i.hasNext()){
            System.out.println(i.next());
        }

        System.out.println("----------------------");


        // Hashtable mobj = new Hashtable();
        // HashMap mobj = new HashMap();
        //LinkedHashMap mobj = new LinkedHashMap();
        TreeMap<String, String> mobj = new TreeMap();

        mobj.put("111", "Rajesh");
        mobj.put("333", "Ramesh");
        // mobj.put(null, "Rakesh");
        mobj.put("222", "Rakesh");
        // mobj.put("444", null);
        mobj.put("444", "Dinesh");
        mobj.put("555", "Suresh");
        

        Set s = mobj.entrySet();
        Iterator mi = s.iterator();

        while(mi.hasNext()){
            Map.Entry me = (Map.Entry) mi.next();
            System.out.println("ID: " +me.getKey() + " Name: " + me.getValue());
            
        }
    }   
}

/*

Collection Framework
-----------------------------
Collection 
        Set
                HashSet - Uses Hashalgorithm
                TreeSet - User Binary Tree algorithm
                LinkedHashSet - Arranges in your order.
        List
                Vector
                        Stack
                ArrayList -> better at accessing
                LinkedList -> better at insertion and deletion.
        Queue
                Priority Queue
                DeQueue
                        ArrayDeque

            

Map
        Hastable
        HashMap
        TreeMap
        LinkedHashMap



Enumeration     - hasMoreElements(), nextElement()
Iterator        - hasNext(), next(), remove()

*/
