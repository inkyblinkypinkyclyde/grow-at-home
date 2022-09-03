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