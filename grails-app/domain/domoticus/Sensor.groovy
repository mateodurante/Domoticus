package domoticus

import sensors.ObservableSensor
import sensors.TemperatureChecker

class Sensor extends SensorListener {
	static Sensor sensor;	
	
    static constraints = {
    }
	
	static Sensor getTemperatureSensor(){
		if(!sensor){
			sensor = new Sensor()
			sensor.startCheck()
		}
		return sensor
	}
	
	ObservableSensor getSensor(){
		return TemperatureChecker.getTC()
	}
	
	def startCheck(){
			println("A")
		runAsync {
			println("b")
			def s = getSensor()
			println("c")
			s.addObserver(this)
			println("D")
			s.sense()
			println("d")
		}
	}
	
	def setValue(String v){
		this.lastValue = v
	}
	
	def getValue(){
		def str = lastValue
		if(lastValue.startsWith('s')) {
			str = lastValue[13..17]
		}
		return str
	}
	
}
