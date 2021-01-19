import java.util.*;
public class TravelingSalesman{

	public static void PossibleRoutes(ArrayList<Distance> cities){
		//this should get the running list of cities just to append on that
		//for i in remaining cities
		//idk about handling what combos to test
	}

	public static void main(String[] args){
		ArrayList<Distance> cities = new ArrayList<Distance>();
		Scanner Sca = new Scanner(System.in);
		String origin = "";
		String destination = "";
		int distance = 0;
		while(Sca.hasNextLine()){
			String nline = Sca.nextLine();
			Scanner Scar = new Scanner(nline);
			int wordcount = 0;
			while(Scar.hasNext()){
				String word = Scar.next();
				if(wordcount == 0)
					origin = word;
				if(wordcount == 2)
					destination = word;
				if(wordcount == 4)
					distance = Integer.parseInt(word);
				wordcount += 1;
			}
			Distance city = new Distance(origin, destination, distance);
			cities.add(city);
		}
		for(int i = 0; i < cities.size(); i++){
			System.out.println(cities.get(i));
		}

		//for i in cities
		//make a running list of cities visited
	}
}
