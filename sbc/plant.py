import RPi.GPIO as GPIO
import time
import requests
from datetime import datetime

class Plant:
    def setup(self, db_id):
        self.db_id = db_id
        print('Sending request...')
        r = requests.get(f'http://192.168.1.120:8080/plants/{self.db_id}')
        print('Request recieved.')
        response = r.json()
        print('Setting properties...')
        self.name = response['name']
        self.bcm_sensor_channel = response['soilSensor']
        self.bcm_overfill_channel = response['overfillSensor']
        self.bcm_pump_channel = response['pump']
        self.average_water_interval = response['averageWaterInterval']
        self.thirsty_multiplier = response['thirstyMultiplier']
        self.print_configs()
        print('Object built.')
        print('Setting GPIO configs...')
        # GPIO.setmode(GPIO.BCM)
        # GPIO.setup(self.bcm_pump_channel, GPIO.OUT)
        print(f'BCM pin {self.bcm_pump_channel} set to OUT')
        # GPIO.output(self.bcm_pump_channel, GPIO.HIGH)
        print(f'BCM pin {self.bcm_pump_channel} set to HIGH')
        # GPIO.setup(self.bcm_sensor_channel, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
        print(f'BCM pin {self.bcm_sensor_channel} set to IN and PULL DOWN')
        # GPIO.setup(self.bcm_overfill_channel, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
        print(f'BCM pin {self.bcm_overfill_channel} set to IN and PULL DOWN')
        print(f'Setup complete at {datetime.now()}')
    
    def print_configs(self):
        print(f'              Name: {self.name}')
        print(f'              Pump: {self.bcm_pump_channel}')
        print(f'              Soil: {self.bcm_sensor_channel}')
        print(f'          Overfill: {self.bcm_overfill_channel}')
        print(f'              DBID: {self.db_id}')
        print(f'Thirsty multiplier: {self.thirsty_multiplier}')
        print(f'    Water interval: {self.average_water_interval}')


    def run_pump_for_given_time(self, seconds):
        GPIO.output(self.bcm_pump_channel, GPIO.LOW)
        time.sleep(seconds)
        GPIO.output(self.bcm_pump_channel, GPIO.HIGH)
    
    def get_sensor_reading(self):
        if GPIO.input(self.bcm_sensor_channel):
            return False # your plant is dry
        else:
            return True # your plant is wet

