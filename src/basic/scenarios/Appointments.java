package basic.scenarios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Appointments {

	public Appointments(int id,long start, long end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}
	int id;
	long start, end;
	boolean hasConflicts= false;
	public static void finConflictUsingFor(List<Appointments> apps) {
		for(int i=0;i<apps.size()-1;i++) {
			Appointments current = apps.get(i);
			Appointments next = apps.get(i+1);
			if(current!=null && next!=null && next.start < current.end) {
				next.hasConflicts=true;
				current.hasConflicts=true;
			}
		}
	}
	public static void main(String args[]) {
		List<Appointments> apps = new ArrayList<>();
		Appointments app1 = new Appointments(1,200,230);
		Appointments app2 = new Appointments(2,215,300);
		Appointments app3 = new Appointments(3,315,430);
		Appointments app4 = new Appointments(4,440,530);
		Appointments app5 = new Appointments(5,525,600);
		apps.add(app1);
		apps.add(app2);
		apps.add(app3);
		apps.add(app4);
		apps.add(app5);
		finConflictUsingFor(apps);
		
		for(int i=0;i<apps.size();i++) {
			System.out.println(apps.get(i).id + " = "+apps.get(i).hasConflicts);
		}
		
	}
}
