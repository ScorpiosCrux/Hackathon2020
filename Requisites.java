import java.util.HashMap;

public class Requisites {
	private HashMap<String, String> preRequisites = new HashMap<String, String>();
	private HashMap<String, String> antiRequisites = new HashMap<String,String>();

	
	
	public Requisites() {
	    preRequisites.put("CPSC231", "");
	    preRequisites.put("CPSC233", "CPSC231");    
	    preRequisites.put("MATH211", "");    
	    preRequisites.put("MATH271", "MATH211");    
	    preRequisites.put("CPSC331", "MATH271 | CPSC233");    
	    preRequisites.put("CPSC313", "MATH271 | CPSC233 | PHIL279");
	    preRequisites.put("CPSC413", "CPSC313 | CPSC331 | MATH211 | MATH265");
	    preRequisites.put("CPSC355", "CPSC233");
	    preRequisites.put("CPSC359", "CPSC355 | CPSC279");
	    preRequisites.put("CPSC449", "CPSC331 | PHIL279");    
	    preRequisites.put("CPSC457", "CPSC331 | CPSC359");
	    preRequisites.put("MATH265", "");
	    preRequisites.put("STAT213", "");
	    preRequisites.put("SENG300", "CPSC331");
	    
	    antiRequisites.put("CPSC231","CPSC215 | CPSC217 | CPSC235 | DATA211 | ENGG233 | ENCM339");
	    antiRequisites.put("CPSC233","CPSC219 | CPSC235 | ENEL497 | ENCM493");
	    antiRequisites.put("MATH211","MATH213");
	    antiRequisites.put("MATH271","");
	    antiRequisites.put("CPSC331","CPSC319");
	    antiRequisites.put("CPSC313","");
	    antiRequisites.put("CPSC355","CPSC265 | ENCM369");
	    antiRequisites.put("CPSC359","CPSC325 | CPSC455 | ENCM415");
	    antiRequisites.put("CPSC413","");
	    antiRequisites.put("CPSC449","");
	    antiRequisites.put("CPSC457","");
	    antiRequisites.put("MATH265", "MATH249 | MATH275");
	    antiRequisites.put("STAT213", "STAT205 | STAT327 | POLI399 | PSYC300 | PSYC301 | PSYC312 | SOCI311");
	    antiRequisites.put("SENG300", "SENG301 | SENG311 | SENG403 | SENG411 | CPSC301 | CPSC333 | CPSC451 | ENSF480")
	}
	
	
	public HashMap<String, String> getPreRequisites() {
		return preRequisites;
	}
	
	public HashMap<String, String> getAntiRequisites() {
		return antiRequisites;
	}
	
}
