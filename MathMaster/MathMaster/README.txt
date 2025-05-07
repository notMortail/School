//Group 35 - MathMaster
//This repository has essential components for the game


How To Play 
-----------------------------------
In your terminal:
cd into the game directory
You may need to adjust the 6th line in the makefile to change WT_BASE to wherever Wt was installed on your device. /usr/local is the default.
Run: 
> sudo apt-get install libsqlite3-dev
> make
> ./mathmaster --docroot . --http-listen 00.0.0:8080
In your browser, go to http://localhost:8080/


Database Setup
-----------------------------------
Database Setup
1. Refer to 'GameQuestions_dbSetup_script.sql' for detailed instructions on setting up the database environment for the game. Follow the steps provided to establish the required database environment.
2. Execute 'GameQuestions_dbSetup_script.sql' to initialize the GameQuestions.db database with the necessary tables and data.

Database Validation
1. To verify the question solutions, follow the steps outlined in 'GameQuestions_dbValidation_script.sql'. 
2. Execute 'GameQuestions_dbValidation_script.sql' to run checks and confirm that the database updates the solution_verification_status to true (1).

Database Acceptance Tests
1. To run the the acceptance tests for the database, follow the steps in GameQuestions_dbAcceptanceTests_script.sql
2. The results from this script are in database_acceptance_tests.txt


Repository Contents
-----------------------------------
database_setup.txt
Results from running the GameQuestions_dbSetup_script.sql

database_validation.txt
Results from running the GameQuestions_dbValidation_script.sql

database_acceptance_tests.txt
Results from running the GameQuestions_dbAcceptanceTests_script.sql

GameQuestions.db
The primary database file that stores all the question data needed for the game. This SQLite database is essential for smooth gameplay. It contains tables and records that store questions and relevant data.

GameQuestions_dbSetup_script.sql
A SQL script that automates the setup process for the 'GameQuestions.db' database. By executing this script, you can initialize the database with the necessary tables and data. This script simplifies the database setup process and can be run to create a fresh database with the required structure. To run the script please review the script comments for instructions.

GameQuestions_dbValidation_script.sql
This SQL script helps you verify the correctness and reliability of the solution to each math question. It contains queries to update the solution_verification_status to true. To run the script please review the script comments for instructions.

GameQuestions_dbAcceptanceTests_script.sql
This SQL script contains the test case for each acceptance tests for the game question database user story. To run the script please review the script comments for instructions.

mathQuestions.txt
Contains a collection of math questions, which are essential for gameplay. Has easy, medium and hard questions that vary in topics to provide a broad scope of math questions.

Mode.cpp
The C++ source code file that implements the game mode. Is is responsible for game mechanics, user interaction, and managing the flow of the game.

Mode.h
The associated header file for 'Mode.cpp'. It defines the interface and data structures used by the game mode.

Mode_test_cases.cpp
A collection of test cases to ensure the game mode's functionality and correctness.


Question Data
'mathQuestions.txt' contains the question data for the game. Follow the format specified in the file to add or modify questions.

