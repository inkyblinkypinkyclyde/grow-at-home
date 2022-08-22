#!/usr/bin/python
from datetime import date, datetime
import RPi.GPIO as GPIO
import time
 
#GPIO SETUP
channel = 4
GPIO.setmode(GPIO.BCM)
GPIO.setup(4, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)

while True:
    if GPIO.input(channel):
        print('dry')
    else:
        print('wet')
    time.sleep(0.5)
 
