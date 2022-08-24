from plant_repository import Plant
from bed_repository import Bed
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
bed = Bed(18)
bed.setup()
plant_1 = Plant(22, 2, "Broccoli")
plant_1.setup()
plant_2 = Plant(23, 4, "Radish")
plant_2.setup()
plant_3 = Plant(24, 5, "Red cabbage")
plant_3.setup()
plant_4 = Plant(25, 6, "Brussel Sprouts")
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