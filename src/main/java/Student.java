
public class Student {

	int rno;
	String name;
	String division;

	void display() {
		System.out.println("Roll no is " + rno);
		System.out.println("Name  is " + name);
		System.out.println("Division is " + division);
	}

	public static void main(String[] args) {

		Student std1 = new Student();
		std1.rno = 003;
		std1.name = "Mallikarjuna";
		std1.division = "9th Standard";
		std1.display();
		System.out.println("------------------------------------------");
		Student std2 = new Student();
		std2.rno = 004;
		std2.name = "Ramesh";
		std2.division = "5th Standard";
		std2.display();

	}

}
