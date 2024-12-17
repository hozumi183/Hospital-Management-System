package finalproject;

public class Doctor {
private String Id;
private String Name;
private String Contact;
private String Specialty;
private int fee;

public Doctor() {
	
}
public Doctor(String Id, String Name, String Contact, String Specialty, int fee) {
	this.Id = Id;
	this.Name = Name;
	this.Contact = Contact;
	this.Specialty = Specialty;
	this.fee = fee;
}
public String getId() {
	return Id;
}
public void setId(String Id) {
	this.Id = Id;
}
public String getName() {
	return Name;
}
public void setName(String Name) {
	this.Name = Name;
}
public String getContact() {
	return Contact;
}
public void setContact(String Contact) {
	this.Contact = Contact;
}
public String getSpecialty() {
	return Specialty;
}
public void setSpeacialty(String Specialty) {
	this.Specialty = Specialty;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
@Override
public String toString() {
	return "Doctor(" + "Id=" + Id + ", Name=" + Name + ", Contact=" + Contact + ", Speicalty=" + Specialty + ". fee=" + fee + ')';
}
}
