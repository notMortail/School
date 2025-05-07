/**
 * @file main.cpp
 * @brief This file contains the main function for the MathMasterApp.
 */

#include <Wt/WApplication.h>
#include "MathMaster.h"

/**
 * @brief The main function for the MathMasterApp.
 *
 * This function is the entry point for the application. It initializes and starts the Wt application.
 *
 * @param argc The number of command-line arguments.
 * @param argv An array of command-line argument strings.
 *
 * @return The exit status of the application.
 */
int main(int argc, char** argv) {
    // Call Wt::WRun to start the Wt application
    return Wt::WRun(argc, argv, [](const Wt::WEnvironment& env) {
        /**
         * @brief Create and return an instance of the MathMasterApp.
         *
         * This lambda function is called to create and return an instance of the MathMasterApp, which
         * is the main application class for the MathMaster application.
         *
         * @param env The Wt environment containing information about the application's context.
         * @return A unique pointer to the MathMasterApp instance.
         */
        return std::make_unique<MathMasterApp>(env);
    });
}
