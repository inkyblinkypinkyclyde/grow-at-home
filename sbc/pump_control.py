from secrets import choice
from pump_runner import PumpControl

PumpControl.setup()
while True:
    choice = int(input('select a pump to run: '))
    if choice == 1:
        PumpControl.pump1_run_for(1)
    if choice == 2:
        PumpControl.pump2_run_for(1)
    if choice == 3:
        PumpControl.pump3_run_for(1)
    if choice == 4:
        PumpControl.pump4_run_for(1)
    if choice == 0:
        break
    

PumpControl.cleanup()