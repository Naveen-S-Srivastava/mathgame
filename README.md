Math Game

Overview

Math Game is an educational Android application designed to help users improve their mathematical skills through fun and engaging gameplay. Developed in Kotlin, the app offers various game modes that challenge players with different types of math problems.


Features

Multiple game modes: Addition, Subtraction, Multiplication, Division

Increasing difficulty levels

Timer-based challenges

Score tracking and leaderboards

User-friendly interface

Technologies Used

Kotlin

Android SDK

RecyclerView

ViewModel

LiveData

Room Database

Data Binding

Material Design Components

Getting Started

Prerequisites

Android Studio 4.0 or higher

Minimum SDK version 21

Target SDK version 30

Installation

Clone the repository:

sh

Copy code

git clone https://github.com/Naveen-S-Srivastava/mathgame.git


Open the project in Android Studio.

Sync the project with Gradle files.

Build and run the app on an emulator or physical device.

Usage

Launch the app.

Select a game mode from the home screen.

Answer the math problems within the time limit.

View your score and try to beat your high score.

Project Structure

css

Copy code

├── app

│   ├── src

│   │   ├── main

│   │   │   ├── java/com/example/mathgame

│   │   │   │   ├── data

│   │   │   │   │   ├── Score.kt

│   │   │   │   │   ├── ScoreDao.kt

│   │   │   │   │   ├── ScoreDatabase.kt

│   │   │   │   ├── ui

│   │   │   │   │   ├── HomeActivity.kt

│   │   │   │   │   ├── GameActivity.kt

│   │   │   │   │   ├── ScoreActivity.kt

│   │   │   │   ├── viewmodel

│   │   │   │   │   ├── GameViewModel.kt

│   │   │   │   │   ├── ScoreViewModel.kt

│   │   │   ├── res

│   │   │   │   ├── layout

│   │   │   │   │   ├── activity_home.xml

│   │   │   │   │   ├── activity_game.xml

│   │   │   │   │   ├── activity_score.xml

│   │   │   ├── AndroidManifest.xml

│   ├── build.gradle

├── build.gradle

├── README.md

Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.


