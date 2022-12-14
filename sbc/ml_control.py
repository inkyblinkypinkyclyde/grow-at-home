from plant import Plant
from bed import Bed
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
bed = Bed(18, 2)
bed.setup()
plant_1 = Plant(22, 7, 7, "Broccoli")
plant_1.setup()
plant_2 = Plant(23, 4, 8, "Radish")
plant_2.setup()
plant_3 = Plant(24, 5, 9, "Red cabbage")
plant_3.setup()
plant_4 = Plant(25, 6, 10, "Brussel Sprouts")
plant_4.setup()
bed.add_plant(plant_1)
bed.add_plant(plant_2)
bed.add_plant(plant_3)
bed.add_plant(plant_4)

# try:
#     while True:
#         bed.water_plants_cleverly(1)

try:
    while True:
        option = int(input('select 1-4 to recieve json:'))
        bed.json_requester(option)            
except KeyboardInterrupt:
    bed.cleanup()
finally:
    bed.cleanup()