# Grow at Home

Create a full stack app with associated hardware components to allow automated management of a home based hydroponics system.

## MVP

### Hardware requirements:
- Use an SBC to retrieve sensor data on soil moisture levels.
- Use an SBC to activate a water pump to increase soil moisture levels.
- Pass the data from the SBC to a database hosted on another machine.

### Software requirements:
- Create a back end app capable of hosting a database to which the SBC can send data.
- The database should be set up to allow further expansion of the SBC to take in extra data as required (see extensions).
- Create an expandable front end to visialise the data collected from the hardware. 
- The user should be able to control the actuators through the front end. For example the user should be able to log into the app and water their plants.

## Extensions

### Hardware:
- Add additional sensors for ambient light levels, air quality, soil acidity and pass new data up to the database.
- Add a camera to take photos of the plant's progress throughout the year.
- Add an alert function which will alert the user when the water reservoir is empty.

### Software:
- Send alerts through to the user so they can see them when they are not logged into the app. This could be through a service like IFTTT or email.


## Advanced Extensions:

### Hardware
- Add additional nodes to the system which would be able to post data back up to the server using another SBC

### Software:
- Add a predictive element to the service which would take in data previosuly collected and make a guess at when the reservoir will run out.