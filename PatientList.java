package finalproject;
class PNode {
	Patient patient;
	PNode next, previous;
	public PNode() {
	}
	public PNode(Patient patient) {
		this.patient = patient;
		next = null;
		previous = null;
	}
}
public class PatientList {
PNode head, tail;
public PatientList() {
	head = null;
	tail = null;
	
}
public void Insert(Patient patient) {
	PNode node = new PNode(patient);
	if (head == null || tail == null) {
		head = node;
		tail = node;
	} else {
		head.next = node;
		node.previous = head;
		head = node;
	}
}
public Patient searchByID(String id) {
	PNode temp = head;
	while (temp!= null) {
		if(temp.patient.getId().equals(id)) {
			return temp.patient;
		}
		temp = temp.previous;
	}
	return null;
}
public Patient searchByContact(String contact) {
	PNode temp = head;
	while (temp!= null) {
		if(temp.patient.getContact().equals(contact)) {
			return temp.patient;
		}
		temp = temp.previous;
	}
	return null;
}
public int Size() {
	PNode temp = head;
	int count = 0;
	while (temp!= null) {
		count++;
		temp = temp.previous;
	}
	return count;
}
public void PrintData() {
	PNode temp = head;
	int count = 0;
	while (temp!= null) {
count++;	
System.out.println(count+ ":    " + temp.patient.toString());
temp = temp.previous;
	}
}
}
