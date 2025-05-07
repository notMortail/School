-- -----------
-- Author: Muaaz Masood
-- CS3307- GROUP 35, MathMaster Game Question Database 
-- Database validation script 

-- Once all questions and solutions in the database have been manually validated, run this script.
-- To run this script start this process by running the commented out commands below:
-- sqlite3 GameQuestions.db;
-- .read GameQuestions_dbValidation_script.sql

-- First step is to update the solution_verification_status field to true (1).
UPDATE game_questions SET solution_verification_status = 1 WHERE solution_verification_status = 0;

-- Second step is to update the hint_verification_status field to true (1).
UPDATE game_questions SET hint_verification_status = 1 WHERE hint_verification_status = 0;
-- Second step is to setup the table for display and review the updated table.
.header on 
.mode line
SELECT * FROM game_questions;

-- exit the database
.quit
