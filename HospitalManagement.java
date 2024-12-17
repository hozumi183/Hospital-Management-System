package finalproject;
import java.util.*;
public class HospitalManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
PatientList plist = new PatientList();
DoctorsList dlist = new DoctorsList();
Scanner s = new Scanner(System.in);
String choice;
while(true) {
	MainMenu();
	choice = s.nextLine();
	if(choice.equals("1")) {
		System.out.println("Doctor ID");
		String id = s.nextLine();
		System.out.println("Doctor Name");
		String name = s.nextLine();
		System.out.println("Doctor Contact");
		String contact = s.nextLine();
		System.out.println("Doctor Specialty");
		String specialty = s.nextLine();
		System.out.println("Doctor Fee");
		int fee = s.nextInt();
		s.nextLine();
		
		Doctor d = new Doctor(id,name,contact,specialty,fee);
		dlist.Insert(d);
	} else if (choice.equals("2")) {
		System.out.println("Patient ID");
		String id = s.nextLine();
		System.out.println("Patient Name");
		String name = s.nextLine();
		System.out.println("Patient Contact");
		String contact = s.nextLine();
		Patient patient = new Patient(id, name ,contact);
		plist.Insert(patient);
	} else if (choice.equals("3")) {
		dlist.PrintData();
	} else if (choice.equals("4")) {
		plist.PrintData();
	} else if (choice.equals("5")) {
		System.out.println("Welcome to the Checkup Menu");
		CheckUpList[] clist = new CheckUpList[dlist.size()];
		for (int i = 0; i < clist.length; i++) {
			clist[i] = new CheckUpList();
			Doctor doctor = dlist.getAtIndex(i);
			System.out.println("Enter Patient for Doctor");
			System.out.println("Name:" + doctor.getName());
			System.out.println("Specialty:" + doctor.getSpecialty());
			System.out.println("Fees:" + doctor.getFee());
			System.out.println("All Patients: ");
			plist.PrintData();
			while (true) {
				System.out.println("Enter patient Id or type null to exit");
				String id = s.nextLine();
				if (id.equals("null")) {
					break;
				}
				System.out.println("Priority 3 for Emergency, 2 for VIP, any other for Normal");
				String per = s.nextLine();
				int p = 1;
				if (per.equals("3")) {
					p = 3;
				} else if (per.equals("2")) {
					p = 2;
				}
				Patient patient = plist.searchByID(id);
				if (patient == null) {
					System.out.println("Invalid Patient ID ");
				} else {
					Checkup cup = new Checkup(doctor, patient, p, "", "" + java.util.Calendar.getInstance().getTime().toString());
					clist[i].Enqueue(cup);
				}
			}
			
		}
		for (int i = 0; i < clist.length; i ++) {
			System.out.println("\n\n Patient " + (i+1) + " In queue for doctor " + dlist.getAtIndex(i).getName());
			for (int j = 0; j < clist[i].Size(); j ++) {
				System.out.println("Enter recommendation for patient: " + clist[i].getPatient(j));
				String rec = s.nextLine();
				clist[i].addRecommendation(j, rec);
			}
		}
	}
	else if (choice.equals("0")) {
		break;
	} else {
		System.out.println("\n Invalid choice");
	}
}
	}
	public static void MainMenu() {
		System.out.println("\n\n          HOSPITAL MANAGEMENT SYSTEM"          );
		System.out.println("                 Main Menu");
		System.out.println("Enter 1 for Insert new Doctor: ");
		System.out.println("Enter 2 for Insert new Patient");
		System.out.println("Enter 3 for print all Doctor:");
		System.out.println("Enter 4 for print all Patient");
		System.out.println("Enter 5 for checkup menu");
		System.out.println("Enter 0 for exit");
	}
}
