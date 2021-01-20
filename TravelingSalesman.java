import java.util.*;
import java.io.*;

public class travelingSalesman {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    String fileInput = "";
    while (sc.hasNextLine()) {
      fileInput = fileInput + sc.nextLine() + "\n";
    }
    System.out.println(fileInput);
    ArrayList<String> cityIndexes = new ArrayList<String>();

    sc = new Scanner(fileInput);
    while (sc.hasNextLine()) {
      String lines = sc.nextLine();
      String city1 = lines.split(" ")[0];
      String city2 = lines.split(" ")[2];
      //System.out.println(city);
      if (cityIndexes.contains(city1) == false) {cityIndexes.add(city1);}
      if (cityIndexes.contains(city2) == false) {cityIndexes.add(city2);}
    }
    int[][] table = new int[cityIndexes.size()][cityIndexes.size()];
    sc = new Scanner(fileInput);
    while (sc.hasNext()) {
      String city1 = sc.next();
      sc.next(); //"to"
      String city2 = sc.next();
      sc.next(); // "="
      int distance = sc.nextInt();
      //System.out.println(city1 + " to " + city2 + " = " + distance);
      table[cityIndexes.indexOf(city1)][cityIndexes.indexOf(city2)] = distance;
      table[cityIndexes.indexOf(city2)][cityIndexes.indexOf(city1)] = distance;
    }
    //System.out.println(Arrays.deepToString(table));

    //actually solve the problem
    int[] counting = new int[table.length];
    for (int i = 1; i < counting.length; i++) {
      counting[i] = i;
    }
    int minDistance = Integer.MAX_VALUE;
    while (true) {
      int dist = 0;
      for (int i = 1; i < counting.length; i++) {
        if (containsSpecial(counting,counting[i],i)) {
          dist = Integer.MAX_VALUE;
          break;
        }
        dist += table[counting[i-1]][counting[i]];
      }
      //if (dist != Integer.MAX_VALUE) {
      //  System.out.println(Arrays.toString(counting));
      //}
      minDistance = Math.min(minDistance,dist);
      int d;
      for (d = 1; d <= counting.length && counting[counting.length-d] >= counting.length - 1; d++) {
          counting[counting.length-d] = 0;
      }
      if (d <= counting.length) {
        counting[counting.length-d]++;
      } else {break;}
    }

    System.out.println("\nAnswer: " + minDistance);
  }
  public static boolean containsSpecial(final int[] array, final int v, int maxIndex) {
    for(int i = 0; i < maxIndex; i++) {
      if(array[i] == v){
        return true;
      }
    }
    return false;
  }
}
