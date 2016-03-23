package com.j2.w3;

import java.util.Date;


public class j2_201511095_w3 {
    public static void main(String[] args) {
        String[] fruit={"Pineapple", "Banana", "Apple", "Kiwifruit", "Strawberry"};
        Comparator ReverseComp=new ReverseComparator();
        InverseSorter.sort(fruit, ReverseComp);

        Integer[] date = {new Integer(24), new Integer(25), new Integer(23), new Integer(22), new Integer(21)};
        Comparator DateComp=new DateComparator();
        Sorter.sort(date, DateComp);

        for(int i=0; i<fruit.length; i++)
            System.out.println("fruit["+i+"]="+fruit[i]);
        for(int i=0; i<date.length; i++)
            System.out.println("date["+i+"]="+date[i]);

        }
}

class Sorter {
  public Sorter() {}
    public static void sort(Object[] data, Comparator comp) {
        for(int i=data.length-1; i>=1; i--) {
            int indexOfMax=0;
            for(int j=1; j<=i; j++) {
                if(comp.compare(data[j], data[indexOfMax]) > 0)
                    indexOfMax=j;
                }
                Object temp=data[i];
                data[i]=data[indexOfMax];
                data[indexOfMax]=temp;
        }
    }
}

class InverseSorter {
  public InverseSorter() {}
    public static void sort(Object[] data, Comparator comp) {
        for(int i=data.length-1; i>=1; i--) {
            int indexOfMax=0;
            for(int j=1; j<=i; j++) {
                if(comp.compare(data[j], data[indexOfMax]) <= 0)
                    indexOfMax=j;
                }
                Object temp=data[i];
                data[i]=data[indexOfMax];
                data[indexOfMax]=temp;
        }
    }
}

interface Comparator {
    public int compare(Object o1, Object o2);
    public boolean equals(Object o);
}

class DateComparator implements Comparator {
  public DateComparator() {}
  public int compare(Object o1, Object o2){
    return (Integer)o1 - (Integer)o2;
  }
}

class ReverseComparator implements Comparator {
    public ReverseComparator() {}
    public int compare(Object o1, Object o2) {
        String s1=(String)o1;
        String s2=(String)o2;
        return s1.compareTo(s2);
    }
}
