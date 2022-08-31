from datetime import datetime
from datetime import date
from pickle import FALSE
import RPi.GPIO as GPIO
import time
import requests
class Bed:
    def __init__(self, bcm_reservoir_channel, bcm_relay_channel):
        self.bcm_reservoir_channel = bcm_reservoir_channel
        self.bcm_relay_channel = bcm_relay_channel
        self.plants = []

    def add_plant(self, plant):
        self.plants.append(plant)
    
    def setup(self):
        GPIO.setmode(GPIO.BCM)
        GPIO.setup(self.bcm_relay_channel, GPIO.OUT)
        GPIO.output(self.bcm_relay_channel, GPIO.HIGH)
        GPIO.setup(self.bcm_reservoir_channel, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
    
    def get_reservoir_level(self):
        output = False
        GPIO.output(self.bcm_relay_channel, GPIO.LOW)
        time.sleep(.1)
        output = self.check_reservoir()
        time.sleep(.1)
        GPIO.output(self.bcm_relay_channel, GPIO.HIGH)
        return output
    
    def check_reservoir(self):
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
        for plant in self.plants:
                if plant.get_sensor_reading():
                    print(f'The {plant.name} seems fine, let\'s check the next one')
                else:
                    print(f'looks like the {plant.name} is a little dry, let\'s check if we have water...')
                    if self.get_reservoir_level():
                        print(f'Looks like we have water, lets water the {plant.name}')
                        try:
                            self.json_poster(time_to_run_pump, plant.db_id)
                        finally:
                            plant.run_pump_for_given_time(time_to_run_pump)
                    else:
                        print(f'Oh No! there\'s no water to water the {plant.name} with!!!!')
                        self.reservoir_status(False)
                        ### add alert behavior here ###
                        wait_for_water_loop = True
                        while wait_for_water_loop == True:
                            GPIO.output(self.bcm_relay_channel, GPIO.LOW)
                            print('waiting for water...')
                            print(self.check_reservoir())
                            if self.check_reservoir() == True:
                                print('got some water now')
                                self.reservoir_status(True)
                                GPIO.output(self.bcm_relay_channel, GPIO.HIGH)
                                time.sleep(1)
                                wait_for_water_loop = False
        time.sleep(loop_length)
    
    # def water_plants_cleverly(self, time_to_run_pump):
    #     loop_size = 0
    #     for plant in self.plants:
    #         if plant.averageWaterInterval > loop_size:
    #             loop_size = (plant.averageWaterInterval)+1
    #     for i in range(loop_size):
    #         for plant in self.plants:
    #             if plant.
        


                                
    def java_time_now(self):
            today = date.today()
            now = datetime.now()
            current_time = now.strftime("%H:%M:%S")
            return(f'{today}T{current_time}')

    def reservoir_status(self, wet):
        print('sending water filled json')
        r = requests.post('http://192.168.1.120:8080/waterSensorReservoirEvents', json={
            "eventDateTime": self.java_time_now(),
            "wet": wet,
            "bedId": 5
            })
        print(f"Status Code: {r.status_code}, Response: {r.json()}")


    def plant_water_data_setter(self, plant):
        r = requests.get(f'http://192.168.1.120:8080/plants/{plant.db_id}')
        response = r.json()
        print(response['id'])
        print(response['name'])
        print(response['averageWaterInterval'])
        print(response['thirstyMultiplier'])
        plant.thirstyMuliplier = response['thirstyMultiplier']
        plant.averageWaterInterval = response['averageWaterInterval']
        
        

    def json_poster(self, time_to_run_pump, plantId):
        r = requests.post('http://192.168.1.120:8080/waterEvents', json={
            "eventDateTime": self.java_time_now(),
            "duration": time_to_run_pump,
            "success": True,
            "plantId": plantId})
        print(f"Status Code: {r.status_code}, Response: {r.json()}")

    def cleanup(self):
        GPIO.cleanup()