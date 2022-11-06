# Grow at Home - a home automation project

This was created as the final project submission for the CodeClan Professional Development Award. The purpose of this app is to water a number of houseplants using a combination of water pumps and soil moisture sensors. This data is passed to a server where it can be stored for future reference and viewed by a React.JS front end.

In order to install the project simply clone the repo to your directory of choice:

```bash
git clone https://github.com/inkyblinkypinkyclyde/grow-at-home
```


This project consists of three parts the Python app designed to run on a Raspberry Pi, the Java server running a Spring Boot app and a React.JS front end.

## The React.JS Front End

This is a simple React app and can be installed by running the following code from within grow_at_home/client.

```bash
npm install
```

...and then started with:

```bash
npm start
```

## The Java backend

This uses was built using Maven and uses the Spring Boot framework and stores data in a H2 database with Hibernate. The app can be run from the grow_at_home/grow_at_home_server directory. Version numbers are listed below:
* Java (v18.0.2)
* Spring Boot (v2.7.3)
* Hibernate (v5.6.10)

## The Python SBC

This was built on a Raspberry Pi (3 Model B) and uses a system of relays and pumps to irrigate the plants.

In order to setup the watering module I used capacitive moisture sensors and relays to control 5v pumps. Realistically, once complete this project could control pumps of any size and throughput.

Below is the connection schema showing both physical pins and the BCM numbers.


|Physical pin number| BCM Pin Number| attach to|
|-|-|-|
|3|2|Plant 1 sensor|
|7|4|Plant 2 sensor|
|12|18|Reservoir sensor|
|15|22|Plant 1 pump|
|16|23|Plant 2 pump|
|18|24|Plant 3 pump|
|22|25|Plant 4 pump|
|29|5|Plant 3 sensor|
|31|6|Plant 4 sensor|



Once this is all set up copy the sbc directory to the Raspberry pi and run automatic_control.py on the Raspberry Pi, It should now start passing JSONs over to the java server once the water sensors are triggered.


## Future improvements
* Add setup page to frontend
* Refactor SBC to take data from the frontend during the setup phase and initialise from that.

