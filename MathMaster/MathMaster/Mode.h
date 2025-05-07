/**
 * @file Mode.h
 * 
 * Header file for mode class
 * By Mark Kiefer & Jennifer Dong
 * November 28, 2023
 */

#ifndef MODE_H
#define MODE_H

#include <string>
#include <ctime>
#include <sqlite3.h>
#include <iostream>
#include <chrono>
#include <thread>

class Mode {
    private:
        int time_limit; /**< The amount of time that the player has to answer the question */
        int start_time; /**< The time that the timer was started */

        std::string current_level; /**< The level the the player has gotten to */

        int current_question_id; /**< The id of the question being asked to the player */
        std::string question; /**< The question being asked */
        std::string answer; /**< The answer to the question */
        std::string hint; /**< The hint to the question */

        int wrong_answers; /**< The amount of answers that the player has gotten wrong */

        int score; /**< The score the player has gotten */

        std::string gameMode_; /**< The current gameMode being played */

    public:

        /**
         * Constructor for mode
         */
        Mode();

        /**
         * Deconstructor for mode
         */
        ~Mode();

        /**
         * function returns the question the player is currently being asked
         * 
         * @return the question being asked
         */
        std::string get_current_question();

        /**
         * function returns the answer to the current question
         * 
         * @return the answer to the current question
         */
        std::string get_current_answer();

        /**
         * function returns the hint associated with the question in practice mode
         * 
         * @return the hint to the current question
        */
        std::string get_hint();

        /**
         * function returns the amount of time left for the question
         * 
         * @return the amount of time left
         */
        int get_time_left();

        /**
         * function sets an amount of time for the question
         * 
         * @param timer the updated time
         */
        void set_timer(int timer);

        /**
         * function returns the level that the player has gotten to
         * 
         * @return the level that the player is on
         */
        std::string get_level();

        /**
         * function increases the level to the next hardest level
         */
        void increase_level();

        /**
         * function returns the player's current score
         * 
         * @return the player's score
         */
        int get_score();
        
        /**
         * function uses current game state to update the player's score
         */
        void update_score();

        /**
         * function checks if the players answer is correct
         * 
         * @param player_answer the player's answer to the question
         * @return true or false depending on the player's value
         */
        bool check_answer(std::string player_answer);

        /**
         * function updates the information about the current question
         * 
         * @param data points to user data
         * @param argc number of columns for the current row
         * @param argv an array storing the data for each column
         * @param col_name an array storing the names of the columns
         */
        void next_question_query(void* data, int argc, char** argv, char** col_name);

        /**
         * function gets and displays the next question to be asked
         */
        void next_question();

        /**
         * function checks if the player has any more attempts left
         * 
         * @return true or false depending on the number of wrong answers
         */
        bool is_eliminated();

        /**
         * function sets the gamemode to whatever the user is current playing in
        */
        void setGameMode(std::string mode);

        /**
         * function returns the gamemode that the player is currently in
         * 
         * @return the current mode: Elimination or Practice mode
        */
        std::string getGameMode();

};

#endif 