-- -----------
-- Author: Muaaz Masood
-- CS3307- GROUP 35, MathMaster Game Question Database 
-- Game Question Database Acceptance Test script

-- This script is designed to validate the database currently meets all acceptance test requirements.
-- To run this script start this process by running the commented out commands below:
-- sqlite3 GameQuestions.db;
-- .read GameQuestions_dbAcceptanceTests_script.sql

-- First step is to setup the table for display.
.header on 
.mode line


-- 1) Test if questions can be queried from the database.
SELECT question_number, question FROM game_questions;
-- 2) Test if new questions with solutions can be inserted into the database.
INSERT INTO game_questions VALUES ('100', 'TEST QUESTION: 1 + 1', '1', 'addition', 'easy', '0', 'TEST HINT: 0101','0');
-- 3) Test if for an existing question a solution can be edited.
UPDATE game_questions SET solution = 2 WHERE question_number = 100;
-- 4) Validate if the solutions match the correct questions when the data is saved. 
SELECT question_number, question, solution FROM game_questions;
-- 5) Test if a hint can be queried for a given question
SELECT question_number, question, question_hint FROM game_questions;
-- 6) Test if a hint can be edited for a given question
UPDATE game_questions SET question_hint = 'HINT UPDATE TEST IN PROGRESS' WHERE question_number = 100;
-- 7) Test if a hint matches the correct question
SELECT question, question_hint FROM game_questions;
-- 8) Validate all questions have an associated hint field.
SELECT question_number, question, question_hint FROM game_questions;
-- 9) Test if existing questions with solutions can be removed from the database
DELETE FROM game_questions WHERE question_number = 100;
SELECT question_number, question, solution FROM game_questions;

-- exit the database
.quit
