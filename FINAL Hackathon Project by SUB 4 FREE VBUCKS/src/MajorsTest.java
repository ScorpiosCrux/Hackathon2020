
public class MajorsTest {


	public static void main(String[] args) {
		Majors major = new Majors("CoMputer ScieNce", "information security");
		System.out.println("Major Number: " + major.getMajorNumber());
		System.out.println("Concentration: " + major.getConcentration());
		System.out.println("Major and Concentration: " + major.getMajorAndConcentration());

	}

}
