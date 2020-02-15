
public class Majors {

	
	private int major;
	private double concentration;
	
	public String getMajor() {
		if (this.major == 1) {
			return "Computer Science";
		}else {
			return "This major number does not exist";
		}
	}
	
	public int getMajorNumber() {
		return major;
	}
	
	public double getConcentration() {
		return concentration;
	}
	
	public double getMajorAndConcentration() {
		return (major + concentration);
	}
	
	public Majors(String major) {
		if (major.toLowerCase().equals("computer science"))
			this.major = 1;
		
	}
	
	public Majors(String major, String concentration) {
		if (major.toLowerCase().equals("computer science"))
			this.major = 1;
		if (concentration.toLowerCase().equals("information security"))
			this.concentration = 0.1;
		else if (concentration.toLowerCase().equals("computer game development"))
			this.concentration = 0.2;
		else if (concentration.toLowerCase().equals("computer graphics"))
			this.concentration = 0.3;
		else if (concentration.toLowerCase().equals("human computer interactions"))
			this.concentration = 0.4;
		else if (concentration.toLowerCase().equals("networks and distributed computing"))
			this.concentration = 0.5;
		else if (concentration.toLowerCase().equals("scientific computation"))
			this.concentration = 0.6;
		else if (concentration.toLowerCase().equals("software engineering"))
			this.concentration = 0.7;
		else if (concentration.toLowerCase().equals("visualization and analytics"))
			this.concentration = 0.8;
	}
	
	
}
