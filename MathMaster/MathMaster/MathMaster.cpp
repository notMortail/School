/**
 * @file MathMasterApp.cpp
 * By Richard Zhang
 * @brief Implementation of the MathMasterApp class.
 */

#include <Wt/WApplication.h>
#include <Wt/WBreak.h>
#include <Wt/WContainerWidget.h>
#include <Wt/WLineEdit.h>
#include <Wt/WPushButton.h>
#include <Wt/WCheckBox.h>
#include <Wt/WText.h>
#include <Wt/WTimer.h>
#include <Wt/WVBoxLayout.h>


#include <vector>
#include <string>
#include <algorithm>
#include <ctime>
#include <cstdlib>
#include "MathMaster.h"
#include "Mode.h"
#include <regex>
#include <fstream>

using namespace std;

/**
 * @class MathMasterApp
 * @brief The main application class for the MathMaster game.
 */
Mode current_game = Mode(); // Initialize a game mode object

/**
 * @brief Constructor for MathMasterApp class.
 * @param env The Wt::WEnvironment for the application.
 */
MathMasterApp::MathMasterApp(const Wt::WEnvironment& env)
    : Wt::WApplication(env), gameWon_(false), inSettings_(false) {
    setTitle("MathMaster");

    // Apply a stylesheet to the application
    useStyleSheet("style.css");
    //startNewGame();
    createStartMenu();
    
}

/**
 * @brief Creates the start menu for the application.
 */
void MathMasterApp::createStartMenu() {
    startMenu_ = root()->addNew<Wt::WMenu>();
    startMenu_->setStyleClass("start-menu"); // Add CSS style if needed

    //Adds menu items
    startGameItem_ = startMenu_->addItem("Start Game");
    startPracticeItem_ = startMenu_->addItem("Practice");
    settingsItem_ = startMenu_->addItem("Settings");
    exitItem_ = startMenu_->addItem("Exit");

    // Connect the "Start Game" and "Exit" menu items to their respective functions
    if (!inSettings_) {
        startGameItem_->clicked().connect(this, &MathMasterApp::startNewGame); //Starts Elimination mode
        startPracticeItem_->clicked().connect(this, &MathMasterApp::startPractice); //Starts Practice mode
        exitItem_->clicked().connect([=]{ // Close the application when Exit is clicked
            startMenu_->hide();
            root()->addWidget(std::make_unique<Wt::WText>("Goodbye"));
        });
        startGameItem_->clicked().connect([=] {
            startMenu_->hide();
        });
        startPracticeItem_->clicked().connect([=] {
            startMenu_->hide();
        });
        settingsItem_->clicked().connect(this, &MathMasterApp::settingsPage); //Go to settings  page
    }
}

/**
 * @brief Starts a new game, displaying the question and input field.
 */
void MathMasterApp::startNewGame() {
    current_game = Mode();
    current_game.setGameMode("Elimination");
    auto gameContainer = root()->addWidget(std::make_unique<Wt::WContainerWidget>());
    gameContainer->setStyleClass("game-container");

    // Text for timer
    timerText_ = gameContainer->addWidget(std::make_unique<Wt::WText>());
    timerText_->setInline(false);
    timerText_->setStyleClass("timer");

    questionText_ = gameContainer->addWidget(std::make_unique<Wt::WText>()); //Will hold the question

    // Play again once game is over
    auto playAgain = gameContainer->addWidget(std::make_unique<Wt::WPushButton>("Play Again"));
    playAgain->setStyleClass("play-again-button");
    playAgain->hide();
    playAgain->clicked().connect([=] {
        gameContainer->clear();
        startNewGame();
    });

    // Return to main menu option
    auto mainMenuButton = gameContainer->addWidget(std::make_unique<Wt::WPushButton>("Main Menu"));
    mainMenuButton->setStyleClass("main-menu-button");
    mainMenuButton->hide();
    mainMenuButton->clicked().connect([=] {
        gameContainer->clear();
        current_game.setGameMode("");
        createStartMenu();
    });


    // Updates the timer to countdown the seconds
    Wt::WTimer* updateTimer = new Wt::WTimer();
    updateTimer->timeout().connect([=] {
        timerText_->setText("Time left: " + std::to_string(current_game.get_time_left()) + " seconds");
        if (current_game.is_eliminated() || current_game.get_time_left() <= 0) {
            updateTimer->stop(); 
            playAgain->show();
            mainMenuButton->show();
            gameOver();
        }
    });
    updateTimer->setInterval(std::chrono::seconds(1));
    timerText_->setText("Time left: " + std::to_string(current_game.get_time_left()) + " seconds");
    updateTimer->start();

    // Enter input
    guessInput_ = gameContainer->addWidget(std::make_unique<Wt::WLineEdit>());
    guessInput_->setPlaceholderText(current_game.get_current_answer());

    questionText_->setText(current_game.get_current_question());
    questionText_->setInline(false);
    questionText_->setStyleClass("question");
    

    // FOR NOW to check right answers
    guessInput_->enterPressed().connect(this, &MathMasterApp::checkGuess); 
    guessInput_->setTextSize(40);
    guessInput_->setFocus();
    guessInput_->setStyleClass("guess-input");

    resultText_ = gameContainer->addWidget(std::make_unique<Wt::WText>());
    resultText_->setInline(false);

    historyText_ = gameContainer->addWidget(std::make_unique<Wt::WText>());
    historyText_->setInline(false);
    historyText_->setStyleClass("history-text");

    gameWon_ = false;
}

/**
 * @brief Starts a new Practice mode session with no score and timer
*/
void MathMasterApp::startPractice() {
    //Set to practice mode
    current_game.setGameMode("Practice");
    auto gameContainer = root()->addWidget(std::make_unique<Wt::WContainerWidget>());
    gameContainer->setStyleClass("game-container");

    //Displays "Practice Mode" instead of timer
    timerText_ = gameContainer->addWidget(std::make_unique<Wt::WText>());
    timerText_->setInline(false);
    timerText_->setText("Practice Mode");

    questionText_ = gameContainer->addWidget(std::make_unique<Wt::WText>());

    // To input an answer
    guessInput_ = gameContainer->addWidget(std::make_unique<Wt::WLineEdit>());
    guessInput_->setPlaceholderText(current_game.get_current_answer());

    // Shows the current question
    questionText_->setText(current_game.get_current_question());
    questionText_->setInline(false);
    questionText_->setStyleClass("question");

    // Gets next question
    auto nextQuestion = gameContainer->addWidget(std::make_unique<Wt::WPushButton>("Next Question"));
    nextQuestion->setStyleClass("main-menu-button");

    // Gets the hint
    auto hint = gameContainer->addWidget(std::make_unique<Wt::WPushButton>("Hint"));
    hint->setStyleClass("main-menu-button");

    // Return to main menu
    auto mainMenuButton = gameContainer->addWidget(std::make_unique<Wt::WPushButton>("Main Menu"));
    mainMenuButton->setStyleClass("main-menu-button");
    mainMenuButton->clicked().connect([=] {
        gameContainer->clear();
        current_game.setGameMode("");
        createStartMenu();
    });
    

    // FOR NOW to check right answers
    
    guessInput_->setTextSize(40);
    guessInput_->setFocus();
    guessInput_->setStyleClass("guess-input");

    resultText_ = gameContainer->addWidget(std::make_unique<Wt::WText>());
    resultText_->setInline(false);

    guessInput_->enterPressed().connect(this, &MathMasterApp::checkGuess); 

    // Hint for question
    auto hintText_ = gameContainer->addWidget(std::make_unique<Wt::WText>());
    hintText_->setInline(false);
    hintText_->setText("");

    hint->clicked().connect([=] {
        hintText_->setText(current_game.get_hint());
    });

    nextQuestion->clicked().connect([=] {
        current_game.next_question();
        hintText_->setText("");
        questionText_->setText(current_game.get_current_question());
        guessInput_->setPlaceholderText(current_game.get_current_answer());
        resultText_->setText("");
        guessInput_->setText(""); // Clear the input field
    });

    historyText_ = gameContainer->addWidget(std::make_unique<Wt::WText>());
    historyText_->setInline(false);
    historyText_->setStyleClass("history-text");
}

/**
 * @brief Checks the user's guess and updates the result text.
 */
void MathMasterApp::checkGuess() {
    std::string guess = guessInput_->text().toUTF8();
    std::transform(guess.begin(), guess.end(), guess.begin(), ::tolower);

    if (current_game.check_answer(guess)) {
            // The answer is correct, update score and display the next question
        if (current_game.getGameMode() == "Elimination") {
            current_game.update_score();
            current_game.next_question();
            questionText_->setText(current_game.get_current_question());
            guessInput_->setPlaceholderText(current_game.get_current_answer());
            guessInput_->setText(""); // Clear the input field
            timerText_->setText("Time left: " + std::to_string(current_game.get_time_left()) + " seconds");
        } else if (current_game.getGameMode() == "Practice") {
            resultText_->setText("Correct!");
            resultText_->setStyleClass("result-text-correct");
        }
    } else {
        if (current_game.getGameMode() == "Elimination") {
            // The answer is incorrect, end the game
            gameOver();
        } else if (current_game.getGameMode() == "Practice") {
            resultText_->setText("Incorrect! Answer is : " + current_game.get_current_answer());
            resultText_->setStyleClass("result-text-incorrect");
        }
    }

}

/**
 * @brief The settings page where the user can personlize their game experience
*/
void MathMasterApp::settingsPage() {
    inSettings_ = true;

    root()->clear();

    auto settingsContainer = root()->addWidget(std::make_unique<Wt::WContainerWidget>());
    settingsContainer->setStyleClass("settings-container");

    auto layout = settingsContainer->setLayout(std::make_unique<Wt::WVBoxLayout>());

    // Change to dark mode
    auto darkButton = layout->addWidget(std::make_unique<Wt::WPushButton>("Dark Mode"));
    darkButton->setStyleClass("settings-button"); // Add a custom style class for styling
    darkButton->clicked().connect([=] {
        Wt::WApplication::instance()->doJavaScript("document.body.classList.add('dark-mode');");
        Wt::WApplication::instance()->doJavaScript("document.body.classList.remove('light-mode');");
    });

    // Change to light mode
    auto lightButton = layout->addWidget(std::make_unique<Wt::WPushButton>("Light Mode"));
    lightButton->setStyleClass("settings-button");
    lightButton->clicked().connect([=] {
        Wt::WApplication::instance()->doJavaScript("document.body.classList.remove('dark-mode');");
        Wt::WApplication::instance()->doJavaScript("document.body.classList.add('light-mode');");
    });

    layout->addSpacing(20);

    // Return to main menu
    auto backToMenu = layout->addWidget(std::make_unique<Wt::WPushButton>("Main Menu"));
    backToMenu->setStyleClass("settings-button");
    backToMenu->clicked().connect([=] {
        inSettings_ = false;

        root()->removeChild(settingsContainer);

        createStartMenu();
    });
}

/**
 * @brief Shows score once player is eliminated in Elimination mode
*/
void MathMasterApp::gameOver() {
    timerText_->setText("Game Over!");
    guessInput_->hide();
    questionText_->setText("Your Score: " + std::to_string(current_game.get_score()));
}