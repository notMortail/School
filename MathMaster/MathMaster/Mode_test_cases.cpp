/**
 * @file Mode_test_cases.cpp
 * 
 * Mode_test_cases contains the test cases for Mode.cpp
 * By Mark Kiefer
 * November 28, 2023
 * 
 * To run test cases do the following commands:
 * 
 * g++ -c Mode.cpp Mode_test_cases.cpp
 * g++ Mode.o Mode_test_cases.o -o Mode_test_cases -lsqlite3
 * ./Mode_test_cases
 */

#include "Mode.h"

using namespace std;

int main(int argc, char **argv){

    //create mode instance
    Mode current_game = Mode();

    /**
     * TEST 1: Check that the timer works
     */

    cout << "\nTEST 1: Check that the timer works\n";

    //check time left and sleep for 1 second
    cout << "Current question time: " << current_game.get_time_left() << "\n";
    this_thread::sleep_for(chrono::seconds(1));

    //check time left and sleep for 1 second
    cout << "Current question time: " << current_game.get_time_left() << "\n";
    this_thread::sleep_for(chrono::seconds(1));

    //check time left and then get new question
    cout << "Current question time: " << current_game.get_time_left() << "\n";

    cout << "New question\n";
    current_game.next_question();

    //check time left and sleep for 1 second
    cout << "Current question time: " << current_game.get_time_left() << "\n";
    this_thread::sleep_for(chrono::seconds(1));

    //check time left and sleep for 1 second
    cout << "Current question time: " << current_game.get_time_left() << "\n";
    this_thread::sleep_for(chrono::seconds(1));

    //check time left
    cout << "Current question time: " << current_game.get_time_left() << "\n";

    /**
     * TEST 2: Check that the questions get harder
     */

    cout << "\nTEST 2: Check that the questions get harder\n";

    //print three questions
    cout << "Current question: " << current_game.get_current_question() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";

    //increase the difficultly
    current_game.increase_level();
    cout << "Difficulty increased\n";
    current_game.next_question();

    //print three questions
    cout << "Current question: " << current_game.get_current_question() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";

    //increase the difficultly
    current_game.increase_level();
    cout << "Difficulty increased\n";
    current_game.next_question();

    //print three questions
    cout << "Current question: " << current_game.get_current_question() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";

    /**
     * TEST 3: Check that the ends when the player gets a question wrong
     */

    cout << "\nTEST 3: Check that the ends when the player gets a question wrong\n";

    //check if not eliminated
    if (current_game.is_eliminated()){
        cout << "Player is eliminated\n";
    }
    else{
        cout << "Player is not eliminated\n";
    }

    //check an answer that is not correct
    current_game.check_answer("?????");
    cout << "Inputted an incorrect answer\n";

    //check if eliminated
    if (current_game.is_eliminated()){
        cout << "Player is eliminated\n";
    }
    else{
        cout << "Player is not eliminated\n";
    }
    
    /**
     * TEST 4: Check that score is working correctly
     * 
     * Note: update_score is called whenever a player gets a question right
    */

    cout << "\nTEST 4: Check that score is working correctly\n";

    //print out current score, should be zero
    cout << current_game.get_score() << "\n";

    //update score and print again
    current_game.update_score();
    cout << current_game.get_score() << "\n";

    //wait three seconds and try again, value added should be less
    this_thread::sleep_for(chrono::seconds(3));
    current_game.update_score();
    cout << current_game.get_score() << "\n";

    //wait three seconds and try again, value added should be less
    this_thread::sleep_for(chrono::seconds(3));
    current_game.update_score();
    cout << current_game.get_score() << "\n";

    return 0;

}