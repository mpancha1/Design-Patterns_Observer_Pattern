package manav_panchal_assign_2;

import java.util.ArrayList;

public class Node implements Cloneable, SubjectI, ObserverI {

	private ArrayList<Object> listeners;
	private String course;
	public int B_num;
	Node left, right;
	public ArrayList<String> courses = new ArrayList<String>();

	public Node(int b_number, String course) {
		this.course = course;
		B_num = b_number;
		courses.add(course);

		listeners = new ArrayList<Object>();

	}

	public Object clone() {
		Node clone = null;

		clone = new Node(B_num, course);

		return clone;
	}

	@Override
	public void registerObserver(ObserverI o) {
		// TODO Auto-generated method stub
		listeners.add(o);
	}

	@Override
	public void removeObserver(ObserverI o) {
		// TODO Auto-generated method stub
		int i = listeners.indexOf(o);
		if (i >= 0) {
			listeners.remove(i);
		}
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (int i = 0; i < listeners.size(); i++) {
			ObserverI observer = (ObserverI) listeners.get(i);
			observer.update(courses);
			;
		}
	}

	@Override
	public void update(ArrayList<String> courses) {
		// TODO Auto-generated method stub
		this.courses = courses;
	}

	public void somethingHappened() {

		notifyObserver();
	}

}
