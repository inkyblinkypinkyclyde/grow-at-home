from plant import Plant
from bed import Bed
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
bed = Bed(18, 2)
bed.setup()
plant_1 = Plant()
plant_2 = Plant()
bed.add_plant(plant_1)
bed.add_plant(plant_2)
plant_1.setup(6)
plant_2.setup(7)

try:
    while True:
        bed.water_plants_automatically(1, 1)
                
except KeyboardInterrupt:
    bed.cleanup()
finally:
    bed.cleanup()