-- -----------
-- Author: Muaaz Masood
-- CS3307- GROUP 35, MathMaster Game Player Database 
-- Database setup 
-- Using sqlite3 on gaul as the database management system.

-- First step is to create the game players database.
-- To run this script start this process by running the commented out commands below:
-- sqlite3 GamePlayers.db;
-- .read GamePlayers_dbSetup_script.sql

-- The fields are defined as the following:
-- player_name is to store player name
-- player_username is to store the player created username
-- player_password is to store the player created password
-- total_games_played is the total number of games played by the player
-- total_questions_solved is the total number of questions solved by the player.
-- total_score_for_all_games is the cumulative score summed up from all played games.
-- highest_score_achieved is the highest score achieved by the player in a game.
-- Second step is to create the table in the database
CREATE TABLE game_players(player_name TEXT, player_username TEXT, player_password TEXT, total_games_played INT, total_questions_solved INT, total_score_for_all_games INT, highest_score_achieved INT);

-- exit the database
.quit
