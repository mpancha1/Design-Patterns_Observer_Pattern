package manav_panchal_assign_2;

public interface SubjectI {
	
	public void registerObserver(ObserverI o);
	public void removeObserver(ObserverI o);
	public void notifyObserver();
}
