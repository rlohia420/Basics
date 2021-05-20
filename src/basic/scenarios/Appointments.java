package basic.scenarios;

import java.util.Iterator;
import java.util.List;

public class Appointments {

	long start, end;
	boolean hasConflicts= false;
	public void finConflict(List<Appointments> apps) {
		Appointments latest = null;
		Iterator<Appointments> itr = apps.iterator();
		while(itr.hasNext()) {
			Appointments next = itr.next();
			if(latest!=null && next.start < latest.end) {
				next.hasConflicts=true;
				latest.hasConflicts=true;
			}
			if(latest==null || next.start >latest.end) {
				latest=next;
			}
		}
	}
}
