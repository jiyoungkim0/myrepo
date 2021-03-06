package com.j2.w3;
import java.util.Date;
import ch.aplu.turtle.*;
import com.sd.turtle.WeightTurtle;

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
        
    public static void main(String[] args) {
    WeightTurtle wt30 = new WeightTurtle(340);
    WeightTurtle wt10 = new WeightTurtle(250);
    WeightTurtle wt20 = new WeightTurtle(380);
    WeightTurtle[] wts={wt340, wt250, wt380};
    Comparator turtleComp=new TurtleComparator();
    Sorter.sort(wts, turtleComp);

    for(int i=0; i<wts.length; i++)
      System.out.println("WeightTurtleArray["+i+"]="+wts[i].getWeight());WeightTurtle wt30 = new WeightTurtle(30);
  }
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

class TurtleComparator implements Comparator {
    public int compare(Object t1, Object t2) {
        return ((WeightTurtle)t1).getWeight()-((WeightTurtle)t2).getWeight();
    }
}