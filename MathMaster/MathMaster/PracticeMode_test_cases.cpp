/**
 * @file PracticeMode_test_cases.cpp
 * 
 * PracticeMode_test_cases contains the test cases for Practice mode 
 * By Jennifer Dong
 * November 28, 2023
 * 
 * To run test cases do the following commands:
 * 
 * g++ -c Mode.cpp PracticeMode_test_cases.cpp
 * g++ Mode.o PracticeMode_test_cases.o -o PracticeMode_test_cases -lsqlite3
 * ./PracticeMode_test_cases
 */

#include "Mode.h"

using namespace std;

int main(int argc, char **argv){

    //create mode instance
    Mode current_game = Mode();
    //set the current mode to practice
    current_game.setGameMode("Practice");

    /**
     * TEST 1: Check that there is no timer for practice mode
     */

    cout << "\nTEST 1: No Timer\n";

    //check time left and sleep for 1 second
    cout << "No Question Timer: " << current_game.get_time_left() << "\n";
    this_thread::sleep_for(chrono::seconds(1));


    cout << "New question\n";
    current_game.next_question();

    //check time left and sleep for 1 second
    cout << "No Question Timer: " << current_game.get_time_left() << "\n";
    this_thread::sleep_for(chrono::seconds(1));


    /**
     * TEST 2: Check that a hint is given and is correct
     */

    cout << "\nTEST 2: Check that a hint is provided, for all difficulty levels and that the hint is right for the question\n";

    //print three questions
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";

    //increase the difficultly
    current_game.increase_level();
    cout << "Difficulty increased\n";
    current_game.next_question();

    //print three questions
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";

    //increase the difficultly
    current_game.increase_level();
    cout << "Difficulty increased\n";
    current_game.next_question();

    //print three questions
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";
    current_game.next_question();
    cout << "Current question: " << current_game.get_current_question() << "\n";
    cout << "Hint: " << current_game.get_hint() << "\n";

    /**
     * TEST 3: Check that there is no score in practice mode
     */

    cout << "\nTEST 3: Check that there is no score\n";

    //print out current score, should be zero
    cout << current_game.get_score() << "\n";

    //update score and print again, should remain 0
    current_game.update_score();
    cout << current_game.get_score() << "\n";

    //wait three seconds and try again
    this_thread::sleep_for(chrono::seconds(3));
    current_game.update_score();
    cout << current_game.get_score() << "\n";

    //wait three seconds and try again
    this_thread::sleep_for(chrono::seconds(3));
    current_game.update_score();
    cout << current_game.get_score() << "\n";
  

    return 0;

}