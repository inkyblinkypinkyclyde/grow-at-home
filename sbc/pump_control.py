from pump_runner import PumpControl

PumpControl.setup()
try:
    while True:
        option = int(input('select a pump to run or press 0 to exit:'))
        if option > 0 and option < 5:
            PumpControl.run_pump_for_given_time(option, 1)
        elif option == 0:
            break
except KeyboardInterrupt:
    PumpControl.cleanup()
finally:
    PumpControl.cleanup()