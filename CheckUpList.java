package finalproject;
class CNode {
	Checkup checku;
	CNode next, previous;
	public CNode(Checkup checku) {
		next = null;
		previous = null;
		this.checku = checku;
	}
}

public class CheckUpList {
CNode head, tail;
public CheckUpList() {
	head = null;
	tail = null;
}
public void Enqueue(Checkup checku) {
	CNode node = new CNode(checku);
	if (head == null || tail == null) {
		head = node;
		tail = node;
	} else if (head.checku.getPriority()<checku.getPriority()) {
		head.next = node;
		node.previous = head;
		head = node;
	} else if (tail.checku.getPriority()>=checku.getPriority()) {
		tail.previous = node;
		node.next = tail;
		tail = node;
	} else {
		CNode temp = tail;
		while (temp != null) {
			if (temp.checku.getPriority()>=checku.getPriority()) {
				break;
			}
			temp = temp.next;
		}
		node.next = temp;
		node.previous = temp.previous;
		temp.previous.next = node;
		temp.previous = node;
	}
}
public Checkup deQueue() {
	if(head == null) {
		return null;
	}
	CNode checkup = head;
	head = head.next;
	return checkup.checku;
}
public void addRecommendation(int Index, String rec) {
	CNode temp = head;
	int i = 0;
	while (temp!= null ) {
		if (Index == 1) {
			temp.checku.setRecommendation(rec);
		}
		i++;
		temp = temp.previous;
	}
}
public Patient getPatient(int index) {
    CNode temp = head;
    int i = 0;
    while (temp != null) {
        if (i == index) {
            return temp.checku.getPatient();
        }
        i++;
        temp = temp.previous;
    }

    return null;
}

public int Size() {
	CNode temp = head;
	int count = 0;
	while (temp!= null) {
		count++;
		temp = temp.previous;
	}
	return count;
}
public void Print() {
	CNode temp = head;
	while(temp!= null) {
		System.out.println(temp.checku.getPriority()+ "      "+temp.checku.getRecommendation());
		temp = temp.previous;
	}
}
}
 