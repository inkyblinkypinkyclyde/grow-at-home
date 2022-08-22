import RPi.GPIO as GPIO
import time
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
                    plant.run_pump_for_given_time(time_to_run_pump)
        else:
            print('Uh-oh, looks like you are all out of water, waiting for a refill')
        time.sleep(loop_length)
            

    def cleanup(self):
        GPIO.cleanup()