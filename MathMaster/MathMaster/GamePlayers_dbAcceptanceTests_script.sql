-- -----------
-- Author: Muaaz Masood
-- CS3307- GROUP 35, MathMaster Game Players Database 
-- Game Players Database Acceptance Test script

-- This script is designed to validate the database currently meets all acceptance test requirements.
-- To run this script start this process by running the commented out commands below:
-- sqlite3 GamePlayers.db;
-- .read GamePlayers_dbAcceptanceTests_script.sql

-- First step is to setup the table for display.
.header on 
.mode line


-- 1) Test if new username with password can be inserted into the database.
INSERT INTO game_players VALUES ('TEST NAME MATHMASTER', 'mathmaster1', 'get100', '0', '0', '0', '0');
-- 2) Test if for a given player you can update their player statistics 
UPDATE game_players SET total_games_played = 10, total_questions_solved = 5, total_score_for_all_games = 500, highest_score_achieved = 50 WHERE player_username = 'mathmaster1';
-- 3) Validate if the player stats can be viewed. 
SELECT player_username, total_games_played, total_questions_solved, total_score_for_all_games, highest_score_achieved FROM game_players;
-- 4) Test if a player can update their password
UPDATE game_players SET player_password = 'NEW PASSWORD' WHERE player_username = 'mathmaster1';
-- 5) Test if a player can be deleted from the database.
DELETE FROM game_players WHERE player_username = 'mathmaster1';
-- The select statement is expected not to produce output since there are no data records in the table. 
SELECT * FROM game_players;

-- exit the database
.quit
