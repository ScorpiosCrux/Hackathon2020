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
		analyze(requisites.getPreRequisites());
		
	}
	
	
	public void analyze(HashMap<String, String> requisites) {
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
		for (String i : requisites.keySet()) {
			int occurrences = Collections.frequency(allPrerequisites, i);
			System.out.println(i + ": " + occurrences);
		}
		
	}
	public void compareAntirequisites(ArrayList<String> x)
	{
		//String[]trimmedW;
		String s;
		String w;
		int i;
		int j;
		int h;
		HashMap<String, String> antiRequisites = requisites.getAntiRequisites();
		for (i=0; i<x.size(); i++){
			s = x.get(i);
			String[] antiRequisiteTrimmed = antiRequisites.get(s).split("|");
			String antiRequisite = antiRequisiteTrimmed[1];
			for (j=0; j<antiRequisites.size(); j++){}
				w = antiRequisites.get(j).trim();
				h = w.compareTo(s);
				if (h!=0){
					System.out.println("Sorry, you cannot take this class. Go see an advisor.");
					return;
				}	
				else{
					continue;
				}	
		}
	}
}
