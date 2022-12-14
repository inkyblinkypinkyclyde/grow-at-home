import RPi.GPIO as GPIO
import time

class Plant:
    def __init__(self, bcm_pump_channel, bcm_sensor_channel, db_id, name):
        self.bcm_pump_channel = bcm_pump_channel
        self.bcm_sensor_channel = bcm_sensor_channel
        self.db_id = db_id
        self.name = name
        self.thirstyMultiplier = None
        self.averageWaterInterval = None
        
    def setup(self):
        GPIO.setmode(GPIO.BCM)
        GPIO.setup(self.bcm_pump_channel, GPIO.OUT)
        GPIO.output(self.bcm_pump_channel, GPIO.HIGH)
        GPIO.setup(self.bcm_sensor_channel, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)

    def run_pump_for_given_time(self, seconds):
        GPIO.output(self.bcm_pump_channel, GPIO.LOW)
        time.sleep(seconds)
        GPIO.output(self.bcm_pump_channel, GPIO.HIGH)
    
    def get_sensor_reading(self):
        if GPIO.input(self.bcm_sensor_channel):
            return False # your plant is dry
        else:
            return True # your plant is wet

