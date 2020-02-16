import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DegreenNavitagtorMainTest {

	public static void main(String[] args) {
		DegreeNavigatorMain test = new DegreeNavigatorMain();
		Requisites requisites = new Requisites();
		ArrayList<String> testArray = new ArrayList<String>();
		testArray.add("MATH265");
		testArray.add("MATH211");
		HashMap<String, String> output = test.analyze( test.requisites.getPreRequisites(), testArray);
		for (String name: output.keySet()){
            String key = name.toString();
            String value = output.get(name).toString();  
            System.out.println(key + ": " + value);  
} 
		return;

		
	}

}
