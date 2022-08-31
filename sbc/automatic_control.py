from plant import Plant
from bed import Bed
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
bed = Bed(18, 2)
bed.setup()
plant_1 = Plant(22, 7, 6, "Corn")
plant_1.setup()
plant_2 = Plant(23, 4, 7, "Red Onions")
plant_2.setup()
plant_3 = Plant(24, 5, 8, "Red Chillies")
plant_3.setup()
plant_4 = Plant(25, 6, 9, "Caulifower")
plant_4.setup()
bed.add_plant(plant_1)
bed.add_plant(plant_2)
bed.add_plant(plant_3)
bed.add_plant(plant_4)

try:
    while True:
        bed.water_plants_automatically(1, 1)
                
except KeyboardInterrupt:
    bed.cleanup()
finally:
    bed.cleanup()