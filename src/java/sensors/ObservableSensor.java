package sensors;

import java.util.ArrayList;
import java.util.List;

import domoticus.SensorListener;

public class ObservableSensor {
	List<SensorListener> sl = new ArrayList<SensorListener>();
	
	public void addObserver(SensorListener sl){
		this.sl.add(sl);
	}
	
	public void notifyToObservers(String v){
		for (SensorListener s : sl) {
			s.notifyValue(v);
		}
	}
}
