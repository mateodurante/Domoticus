package domoticus

import sensors.ObservableSensor

class SensorListener {
	def observable
	def lastValue = "Iniatializing Sensor...";

    static constraints = {
    }
	
	def setObservable(o){
		observable o
	}
	
	def notifyValue(String v){
		lastValue = v
		if(v==null){
			lastValue="Sensor Not Found."
		}
		println this.lastValue
	}
	
}
