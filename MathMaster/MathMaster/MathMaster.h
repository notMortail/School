/**
 * @file MathMasterApp.h
 * By Jennifer Dong & Anastasiia Shutenk
 * @brief Defines the MathMasterApp class, a web application for a math quiz game.
 */

#include <Wt/WApplication.h>
#include <Wt/WBreak.h>
#include <Wt/WContainerWidget.h>
#include <Wt/WLineEdit.h>
#include <Wt/WPushButton.h>
#include <Wt/WText.h>
#include <vector>
#include <string>
#include <algorithm>
#include <ctime>
#include <cstdlib>
#include <Wt/WMenu.h>
#include <Wt/WMenuItem.h>

/**
 * @class MathMasterApp
 * @brief Represents a web application for a math quiz game.
 */
class MathMasterApp : public Wt::WApplication {
public:
    /**
     * @brief Constructor for the MathMasterApp class.
     * @param env The Wt environment.
     */
    MathMasterApp(const Wt::WEnvironment& env);

private:
    Wt::WText* questionText_; /**< Text widget for displaying the math question. */
    Wt::WLineEdit* guessInput_; /**< Input widget for user's guess. */
    Wt::WText* resultText_; /**< Text widget for displaying the result of the guess. */
    Wt::WText* historyText_; /**< Text widget for displaying the history of guesses. */

    bool gameWon_; /**< Flag to track if the game is won. */
    bool inSettings_; /**<Flag to track if you're in the settings Page. */

    Wt::WMenu* startMenu_; /**< Menu widget for starting a new game and accessing settings. */
    Wt::WMenuItem* startGameItem_; /**< Menu item for starting a new game. */
    Wt::WMenuItem* startPracticeItem_; /**<Menu item for starting in Practice mode. */
    Wt::WMenuItem* settingsItem_; /**< Menu item for accessing game settings. */
    Wt::WMenuItem* exitItem_; /**< Menu item for exiting the game. */
    Wt::WText* timerText_; /**To display the game timer*/

    /**
     * @brief Start a new game.
     */
    void startNewGame();

    /**
     * @brief Starts the practice mode seession.
    */
    void startPractice();

    /**
     * @brief Check the user's guess and update the game state.
     */
    void checkGuess();

    /**
     * @brief Create the start menu for the game.
     */
    void createStartMenu();

    /**
     * @brief Creates the settings page for the game.
    */
    void settingsPage();

    /**
     * @brief Creates the game over page for Elimination mode
    */
    void gameOver();
};