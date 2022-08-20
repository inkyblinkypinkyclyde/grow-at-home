import RPi.GPIO as GPIO
import time

class PumpControl:
    def setup():
        GPIO.setmode(GPIO.BCM) ##set to broadcom numbering system
        GPIO.setup(22, GPIO.OUT) ##set gpio mode to out
        GPIO.output(22, GPIO.HIGH) ##set pin to HIGH *BUT* pump to off
        GPIO.setup(23, GPIO.OUT)
        GPIO.output(23, GPIO.HIGH)
        GPIO.setup(24, GPIO.OUT)
        GPIO.output(24, GPIO.HIGH)
        GPIO.setup(25, GPIO.OUT)
        GPIO.output(25, GPIO.HIGH)


    def pump1_run_for(seconds):
        GPIO.output(22, GPIO.LOW)
        time.sleep(seconds)
        GPIO.output(22, GPIO.HIGH)
    
    def pump2_run_for(seconds):
        GPIO.output(23, GPIO.LOW)
        time.sleep(seconds)
        GPIO.output(23, GPIO.HIGH)

    def pump3_run_for(seconds):
        GPIO.output(24, GPIO.LOW)
        time.sleep(seconds)
        GPIO.output(24, GPIO.HIGH)

    def pump4_run_for(seconds):
        GPIO.output(25, GPIO.LOW)
        time.sleep(seconds)
        GPIO.output(25, GPIO.HIGH)
    
    def cleanup():
        GPIO.cleanup()

