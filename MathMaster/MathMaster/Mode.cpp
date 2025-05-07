/**
 * @file Mode.cpp
 * 
 * Mode class contains the functionality of the main game
 * By Richard Zhang & Jennifer Dong
 * November 28, 2023
 */

#include "Mode.h"


using namespace std;

/**
 * Constructor for mode
 */
Mode::Mode(){

    time_limit = 30;
    start_time = 0;
    current_level = "easy";

    current_question_id = 0;
    question = "";
    answer = "";
    hint = "";

    wrong_answers = 0;

    score = 0;
    
    next_question();

    gameMode_ = "";
    
}

/**
 * Deconstructor for mode
 */
Mode::~Mode(){

}

/**
 * function returns the question the player is currently being asked
 * 
 * @return the question being asked
 */
string Mode::get_current_question(){

    return question;

}

/**
 * function returns the answer to the current question
 * 
 * @return the answer to the current question
 */
string Mode::get_current_answer(){

    return answer;

}

/**
 * function returns the hint to the current question
 * 
 * @return the hint for a practice mode question
 */
string Mode::get_hint(){
    return hint;
}

/**
 * function returns the amount of time left for the question
 * 
 * @return the amount of time left
 */
int Mode::get_time_left(){
    if (gameMode_=="Practice"){
        return 0;
    }

    int time_left = ((static_cast<int>(time(nullptr)) - start_time) * -1 + time_limit);

    if (time_left >= 0){
        return time_left;

    }
    else {
        return 0;

    }

}

/**
 * function sets an amount of time for the question
 * 
 * @param timer the updated time
 */
void Mode::set_timer(int timer){

    time_limit = timer;

    start_time = static_cast<int>(time(nullptr));

}

/**
 * function returns the level that the player has gotten to
 * 
 * @return the level that the player is on
 */
string Mode::get_level(){

    return current_level;

}

/**
 * function increases the level to the next hardest level
 */
void Mode::increase_level(){

    if (current_level == "easy"){
        current_level = "medium";

    }
    else if (current_level == "medium"){
        current_level = "hard";

    }

}

/**
 * function returns the player's current score
 * 
 * @return the player's score
 */
int Mode::get_score(){

    return score;

}

/**
 * function uses current game state to update the player's score
 */
void Mode::update_score(){
    if (gameMode_=="Elimination") {

        int multiplier = 0;

        //get variables based on difficulty
        if (Mode::get_level() == "easy"){
            multiplier = 1;

        }
        else if (Mode::get_level() == "medium") {
            multiplier = 2;

        }
        else {
            multiplier = 3;

        }

        //calculate score for current question
        float question_score = multiplier * 1000 * (static_cast<float>(Mode::get_time_left()) / static_cast<float>(time_limit));
        
        //add question score to the game score
        score = score + static_cast<int>(question_score);
    };

}

/**
 * function checks if the players answer is correct
 * 
 * @param player_answer the player's answer to the question
 * @return true or false depending on the player's value
 */
bool Mode::check_answer(string player_answer){

    if (player_answer == answer){
        Mode::update_score();

        return true;

    }
    else{
        wrong_answers++;

        return false;
    }

}

/**
 * function updates the information about the current question
 * 
 * @param data points to user data
 * @param argc number of columns for the current row
 * @param argv an array storing the data for each column
 * @param col_name an array storing the names of the columns
 */
void Mode::next_question_query(void* data, int argc, char** argv, char** col_name){

    current_question_id = atoi(argv[0]);
    question = argv[1];
    answer = argv[2];
    hint = argv[6];

}

/**
 * intermediate function for next_question and next_question_query
 * 
 * @param data points to user data
 * @param argc number of columns for the current row
 * @param argv an array storing the data for each column
 * @param col_name an array storing the names of the columns
 */
int next_question_query_callback(void* data, int argc, char** argv, char** col_name) {

    Mode* mode = static_cast<Mode*>(data);

    mode->next_question_query(data, argc, argv, col_name);

    return 0;

}

/**
 * function gets and displays the next question to be asked
 */
void Mode::next_question(){

    //open database
    sqlite3* db;
    int rc = sqlite3_open("GameQuestions.db", &db);

    //check if successful
    if (rc) {
        return ;

    } 

    //the query
    string string_sql_query = "SELECT * FROM game_questions WHERE question_difficulty = \"" + Mode::get_level() + "\"" + " ORDER BY random() LIMIT 1;";

    const char* sql_query = string_sql_query.c_str();
    char* errorMessage = 0;    

    //do the query which calls next_question_query
    rc = sqlite3_exec(db, sql_query, next_question_query_callback, this, &errorMessage);

    //check for an error
    if (rc != SQLITE_OK){
        fprintf(stderr, "SQL error: %s\n", sqlite3_errmsg(db));
    }

    //close the database
    sqlite3_close(db);

    //start question timer
    if (Mode::get_level() == "easy"){
        set_timer(30);

    }
    else if (Mode::get_level() == "medium") {
        set_timer(120);

    }
    else {
        set_timer(300);

    }
}

/**
 * function checks if the player has any more attempts left
 * 
 * @return true or false depending on the number of wrong answers
 */
bool Mode::is_eliminated(){

    if (wrong_answers >= 1 || Mode::get_time_left() <= 0){
        return true;

    }
    else{
        return false;

    }

}

/**
 * function sets the gamemode the user is playing
 * @return set the gamemode
 */
void Mode::setGameMode(std::string mode) {
    gameMode_ = mode;
}

/**
 * function returns the gamemode the user is currently in
 * 
 * @return the gamemode
 */
std::string Mode::getGameMode() {
    return gameMode_;
}