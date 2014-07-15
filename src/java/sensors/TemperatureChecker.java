package sensors;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TemperatureChecker extends ObservableSensor {
	static TemperatureChecker tc;
	boolean started = false;
	
	static TemperatureChecker getTC(){
		if(tc==null){
			tc = new TemperatureChecker();
		}
		return tc;
	}
	
	void sense(){
		if(!started) {
			this.startCheck();
		}
	}

	void startCheck(){
		Process p;
		String line;
		started = true;
		try {
			while (true){
				p = Runtime.getRuntime().exec("cat /dev/ttyACM0");
				BufferedReader reader = 
						new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line=reader.readLine())!=null){
					this.notifyToObservers(line);
				}
				this.notifyToObservers(null);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
