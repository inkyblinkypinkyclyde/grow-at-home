import RPi.GPIO as GPIO
import time

class PumpControl:
    def setup():
        GPIO.setmode(GPIO.BCM)
        for i in range(4):
            GPIO.setup(i + 22, GPIO.OUT)
            GPIO.output(i + 22, GPIO.HIGH)

    def run_pump_for_given_time(pump_number, seconds):
        pin = pump_number + 21
        GPIO.output(pin, GPIO.LOW)
        time.sleep(seconds)
        GPIO.output(pin, GPIO.HIGH)

    def cleanup():
        GPIO.cleanup()

