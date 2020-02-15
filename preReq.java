import java.util.HashMap; 

public class preReq
{

    HashMap<String,String> preReq = new HashMap<String, String>();


    preReq.put("CPSC231", "");
    preReq.put("CPSC233", "CPSC231");    
    preReq.put("MATH211", "");    
    preReq.put("MATH271", "MATH211");    
    preReq.put("CPSC331", "MATH271 | CPSC233");    
    preReq.put("CPSC313", "MATH271 | CPSC233 | PHIL279");
    preReq.put("CPSC413", "CPSC313 | CPSC331 | MATH211 | MATH265");
    preReq.put("CPSC355", "CPSC233");
    preReq.put("CPSC359", "CPSC355 | CPSC279");
    preReq.put("CPSC449", "CPSC331 | PHIL279");    
    preReq.put("CPSC457", "CPSC331 | CPSC359");
    preReq.put("MATH211", "");
    preReq.put("MATH265", "");

}
