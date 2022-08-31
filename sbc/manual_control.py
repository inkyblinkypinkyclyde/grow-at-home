from plant import Plant
from bed import Bed
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
bed = Bed(18, 2)
bed.setup()
plant_1 = Plant(22, 7, "Broccoli")
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
        option = int(input('select a pump to run or press 0 to exit:'))
        if option >= 1 and option <= 4:
            bed.water_plant_manually(option)
        elif option >= 5 and option <= 8:
            print(f'sensor channel: {bed.plants[option-5].bcm_sensor_channel}')
            print(f'sensor reading: {bed.plants[option-5].get_sensor_reading()}')
        elif option == 9:
            print(bed.get_reservoir_level())
        elif option == 10:
            for plant in bed.plants:
                print(plant.get_sensor_reading())
        elif option == 0:
            break
except KeyboardInterrupt:
    bed.cleanup()
finally:
    bed.cleanup()