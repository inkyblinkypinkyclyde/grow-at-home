from datetime import datetime
from datetime import date
import RPi.GPIO as GPIO
import time
import requests
class Bed:
    def __init__(self, bcm_reservoir_channel):
        self.bcm_reservoir_channel = bcm_reservoir_channel
        self.plants = []
        self.watering_queue = []

    def add_plant(self, plant):
        self.plants.append(plant)
    
    def setup(self):
        GPIO.setmode(GPIO.BCM)
        GPIO.setup(self.bcm_reservoir_channel, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
    
    def get_reservoir_level(self):
        if GPIO.input(self.bcm_reservoir_channel):
            return False # There is not water
        else:
            return True # There is water

    def water_plant_manually(self, plant_number):
        if self.get_reservoir_level():
            print('Your reservoir has water! watering will start now')
            self.plants[plant_number-1].run_pump_for_given_time(1)
            print('watering completed')
        else:
            print('Uh-oh! looks like you are out of water')
    
    def water_plants_automatically(self, time_to_run_pump, loop_length):
        if self.get_reservoir_level():
            print('looks like you have enough water, let\'s check those plants')
            for plant in self.plants:
                if plant.get_sensor_reading():
                    print('nothing to do here, checking the next plant')
                else:
                    print('looks like this one is a little dry, let\'s water it')
                    print(plant.name)
                    ###find a better way to do this bit
                    if plant.name == "Broccoli":
                        self.json_poster_broccoli(time_to_run_pump)
                        plant.run_pump_for_given_time(time_to_run_pump)
                    if plant.name == "Radish":
                        self.json_poster_radish(time_to_run_pump)
                        plant.run_pump_for_given_time(time_to_run_pump)
                    if plant.name == "Red cabbage":
                        self.json_poster_red_cabbage(time_to_run_pump)
                        plant.run_pump_for_given_time(time_to_run_pump)
                    if plant.name == "Brussel Sprouts":
                        self.json_poster_brussel_sprouts(time_to_run_pump)
                        plant.run_pump_for_given_time(time_to_run_pump)

        else:
            print('Uh-oh, looks like you are all out of water, waiting for a refill')
        time.sleep(loop_length)
    
    def java_time_now(self):
            today = date.today()
            now = datetime.now()
            current_time = now.strftime("%H:%M:%S")
            return(f'{today}T{current_time}')

##### find a better way to do this bit  
    def json_poster_broccoli(self, time_to_run_pump):
        r = requests.post('http://192.168.1.120:8080/waterEvents', json={
            "eventDateTime": self.java_time_now(),
            "duration": time_to_run_pump,
            "success": True,
            "plant": {
                "id": 7,
                "name": "Broccoli",
                "species": "Broccolus Brocollilicus",
                "tag": None,
                "produces": "broccoli shoots",
                "units": "GRAMS",
                "dateAdded": "2022-08-23",
                "dateRemoved": None,
                "waterSensorEvents": [],
                "bed": {
                    "id": 6,
                    "name": "MicroGreens",
                    "reservoirCapacity": 1000,
                    "waterSensorReservoirEvents": [],
                    "garden": {
                        "id": 3,
                        "name": "Smart Garden"
                        }
                    }
                }})
        print(f"Status Code: {r.status_code}, Response: {r.json()}")
    
    def json_poster_radish(self, time_to_run_pump):
        r = requests.post('http://192.168.1.120:8080/waterEvents', json={
            "eventDateTime": self.java_time_now(),
            "duration": time_to_run_pump,
            "success": True,
            "plant": {
                "id": 8,
                "name": "Radish",
                "species": "Spicucus Redvegicus",
                "tag": None,
                "produces": "Raddish shoots",
                "units": "GRAMS",
                "dateAdded": "2022-08-23",
                "dateRemoved": None,
                "waterSensorEvents": [],
                "bed": {
                    "id": 6,
                    "name": "MicroGreens",
                    "reservoirCapacity": 1000,
                    "waterSensorReservoirEvents": [],
                    "garden": {
                        "id": 3,
                        "name": "Smart Garden"
                        }
                    }
                }})
        print(f"Status Code: {r.status_code}, Response: {r.json()}")

    def json_poster_red_cabbage(self, time_to_run_pump):
        r = requests.post('http://192.168.1.120:8080/waterEvents', json={
            "eventDateTime": self.java_time_now(),
            "duration": time_to_run_pump,
            "success": True,
            "plant": {
                "id": 9,
                "name": "Red Cabbage",
                "species": "Cabbagicum Cabaragicus",
                "tag": None,
                "produces": "red cabbage shoots",
                "units": "GRAMS",
                "dateAdded": "2022-08-23",
                "dateRemoved": None,
                "waterSensorEvents": [],
                "bed": {
                    "id": 6,
                    "name": "MicroGreens",
                    "reservoirCapacity": 1000,
                    "waterSensorReservoirEvents": [],
                    "garden": {
                        "id": 3,
                        "name": "Smart Garden"
                        }
                    }
                }})
        print(f"Status Code: {r.status_code}, Response: {r.json()}")

    def json_poster_brussel_sprouts(self, time_to_run_pump):
        r = requests.post('http://192.168.1.120:8080/waterEvents', json={
            "eventDateTime": self.java_time_now(),
            "duration": time_to_run_pump,
            "success": True,
            "plant": {
                "id": 10,
                "name": "Brussel Sprouts",
                "species": "Brusselus Tasteslikefarticus",
                "tag": None,
                "produces": "brussel sprout shoots",
                "units": "GRAMS",
                "dateAdded": "2022-08-23",
                "dateRemoved": None,
                "waterSensorEvents": [],
                "bed": {
                    "id": 6,
                    "name": "MicroGreens",
                    "reservoirCapacity": 1000,
                    "waterSensorReservoirEvents": [],
                    "garden": {
                        "id": 3,
                        "name": "Smart Garden"
                        }
                    }
                }})
        print(f"Status Code: {r.status_code}, Response: {r.json()}")


    def cleanup(self):
        GPIO.cleanup()