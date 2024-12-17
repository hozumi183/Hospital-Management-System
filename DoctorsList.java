package finalproject;
class DNode {
	Doctor doctor;
	DNode next, previous;
	public DNode() {
	}
	public DNode(Doctor doctor) {
		this.doctor = doctor;
		next = null;
		previous = null;
	}
}
public class DoctorsList {
DNode head, tail;
public  DoctorsList() {
	head = null;
	tail = null;
}
public void Insert(Doctor doctor) {
	DNode node = new DNode(doctor);
	if (head == null || tail == null) {
		head = node;
		tail = node;
	} else {
		head.next = node;
		node.previous = head;
		head = node;
	}
}
public Doctor searchByID(String id) {
	DNode temp = head;
	while (temp!= null) {
		if(temp.doctor.getId().equals(id)) {
			return temp.doctor;
		}
		temp = temp.previous;
	}
	return null;
}
public Doctor searchByContact(String contact) {
	DNode temp = head;
	while (temp!= null) {
		if(temp.doctor.getContact().equals(contact)) {
			return temp.doctor;
		}
		temp = temp.previous;
	}
	return null;
}
public void AllDoctorInfo() {
	DNode temp = head;
	while (temp!= null) {
	System.out.println("Doctor ID = "+ temp.doctor.getId()+"       Specialty = " + temp.doctor.getSpecialty());
	temp = temp.previous;
}
}
public Doctor getAtIndex(int Index) {
	DNode temp = head;
	for (int i = 0; i <Index; i++) {
		temp = temp.previous;
		
	}
	return temp.doctor;
}
public int size() {
	DNode temp = head;
	int count = 0;
	while (temp!= null) {
		count++;
		temp = temp.previous;
	}
	return count;
}
public void PrintData() {
	DNode temp = head;
	int count = 0;
	while (temp!= null) {
		count++;
		System.out.println(count+ ":   " + temp.doctor.toString());
		temp = temp.previous;
		
	}
}
}
