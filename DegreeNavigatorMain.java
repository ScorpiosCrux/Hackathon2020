import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DegreeNavigatorMain {

	private Majors major;
	private Concentration concentration;
	public Requisites requisites;
	
	public DegreeNavigatorMain(){
		this.major = new Majors("computer science", "information security");
		this.concentration = new Concentration();
		this.requisites = new Requisites(); 
		System.out.println(this.requisites.getPreRequisites().keySet());
		makeAntirequisites(requisites.getAntiRequisites());
	}
	
	public void analyze(ArrayList<String> classesTaken, HashMap<String, String> requisites) {
		ArrayList<String> allPrerequisites = new ArrayList<String>();
		for (String i : requisites.values()) {
			i = i.replace(" | ", " ");
			String[] array = i.split(" ");
			for (int j = 0; j < array.length; j++) {
				if (array[j].equals(""))
					break;
				allPrerequisites.add(array[j]);
			}
		}
		uhUhUhUhAbnerYouShouldNameItAMethodYourHeartDesiresNowIHopeYouHaveToWriteThatEverytime(classesTaken,allPrerequisites);
/*		ArrayList<String> finalizedArray = new ArrayList<String>();
		for (String i : allPrerequisites){
			for (int j=0; j < finalizedArray.size(); j++){
				String additionToFinalArray;
				additionToFinalArray = finalizedArray(j);
				boolean appearsInPrerequisites = additionToFinalArray.equals(i);
				if (appearsInPrerequisites == false){
					finalizedArray.add();
				}
				else{
					continue;
				}
			}
		}*/
		for (String i : requisites.keySet()) {
			int occurrences = Collections.frequency(allPrerequisites, i);
			System.out.println(i + ": " + occurrences);
		}
	}

	//put classes taken first, put prereqs second
	public void uhUhUhUhAbnerYouShouldNameItAMethodYourHeartDesiresNowIHopeYouHaveToWriteThatEverytime(ArrayList<String> x, ArrayList<String> y){
		String s;
		String w;
		for (int i=0; i<x.size(); i++){
			s = x.get(i);
			for (int j=0; j<y.size(); j++){
				w = y.get(j);
				boolean hasTakenPrereq = s.equals(w);
				if (hasTakenPrereq == true){
					y.remove(j);
				}
				else{
					continue;
				}
			}	
		}
	}

	public ArrayList<String> makeAntirequisites(HashMap<String, String> requisites){
		ArrayList<String> allAntirequisites = new ArrayList<String>();
		for (String i : requisites.values()) {
			i = i.replace(" | ", " ");
			String[] array = i.split(" ");
			for (int j = 0; j < array.length; j++) {
				if (array[j].equals(""))
					break;
				allAntirequisites.add(array[j]);
			}
		}
		return allAntirequisites;
	}

	public void compareAntirequisites(ArrayList<String> x, ArrayList<String> y)
	{
		String s, w;
		int j, h;
		boolean isAntirequisite;
		HashMap<String, String> antiRequisites = requisites.getAntiRequisites();
		for (int i=0; i<x.size(); i++){
			s = x.get(i);
			for (j=0; j<y.size(); j++){
				w = y.get(j);
				isAntirequisite = s.equals(w);
				if (isAntirequisite == true){
					System.out.println("Sorry, you cannot take this class. Please go see an advisor.");
					return;
				}
				else{
					continue;
				}
			}	
		}
		System.out.println("All set, thanks!");
	}
}
