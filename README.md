# Weather App

> This is a web application where you can check actual weather and forecast for next 5 days.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Usage](#usage)
* [Project Status](#project-status)

## General Information
Weather App is an application that allows you check the current weather status 
for specified city and the weather forecast for next five days. Weather data are
fetched from OpenWeatherMap API:

[API LINK](https://openweathermap.org/)


## Technologies Used
- Spring Boot v. 3.1.3 (including web, webflux, test)
- JUnit
- Mockito
- Rest Assured v. 5.3.1
- WireMock v. 2.27.2
- Lombok
- Swagger v. 2.2.0

Others:
- OpenWeatherMap API


## Features
As application user you can use the following features:
- fetch information about current weather for specified city
- fetch information about weather forecast for next five days for specified city

## Usage
To run this application you need to perform the following steps:
- install JDK - version 17+
- download jar file from the repository root folder
- open command line and execute command: java -jar <file_name>

Note: application is set to run on port 8080 - make sure this port is available on your machine


## Project Status
Project status: _completed_.