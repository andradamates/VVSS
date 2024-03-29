package agenda.model.repository.interfaces;

import java.util.Date;
import java.util.List;

import agenda.model.base.Activity;

public interface RepositoryActivity {

	List<Activity> getActivities();
	boolean addActivity(Activity activity);
	boolean removeActivity(Activity activity);
	boolean saveActivities();
	int count();
	List<Activity> getActivitiesByName(String name);
	List<Activity> getActivitiesOnDate(String name, Date d);
	
}
