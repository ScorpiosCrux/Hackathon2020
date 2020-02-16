import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main{
	private DegreeNavigatorMain dnm;
	private Requisites requisites;
	public static void main(String[] args){
		Main m = new Main();
		m.realMain();
		return;
	}
	public void realMain(){
		this.dnm = new DegreeNavigatorMain();
		this.requisites = new Requisites();
		ArrayList<String> testArray = new ArrayList<String>();
		testArray.add("MATH265");
		testArray.add("MATH211");
		dnm.analyze(testArray, dnm.requisites.getPreRequisites());
		return;
	}
}
