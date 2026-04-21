![ISTitle](https://github.com/9711519-png/ImpossiSpell/blob/main/images/ISTitle.png)

# ImpossiSpell
The game uses a word bank to randomly choose words and read them out loud using text-to-speech. The player listens to the word and types what they hear into a text box. There is a repeat button if the player needs to hear the word again. A timer counts down from 10 seconds for each word. As the game continues, the words become more difficult.

# Purpose

This project is a spelling game designed to help users improve their spelling and listening skills. It provides a fun and interactive way to practice spelling words using audio.

# Target User

This game is for students or anyone who wants to practice and improve their spelling in an engaging way.

# Planned Features

- Random words selected from a word bank
- Text-to-speech to read each word aloud
- Repeat button to hear the word again
- 10-second countdown timer for each round
- Text box for users to type their answer
- Increasing difficulty as the game progresses

# Program Structure

- Main/Game Class – controls the game flow and rounds
- WordBank Class – stores and selects words by difficulty
- TTS Class – handles text-to-speech
- Timer Class – manages the countdown
- UI Class – handles the interface and user input

# Challenges

- Getting text-to-speech to work smoothly
- Managing the timer alongside user input
- Increasing difficulty in a balanced way
- Making the UI responsive and easy to use

![SB-UMLDiagram](https://github.com/9711519-png/SpellingBee/blob/main/images/SB-UMLDiagram.png)

![SBMockup](https://github.com/9711519-png/SpellingBee/blob/main/images/SBMockup.png)

# Phase One

# Classes Created

- GameController: Coordinates the entire game flow, including starting rounds, receiving user input, interacting with other classes, and managing the overall state of the game.
- WordBank: Stores words organized by difficulty level and provides random words when requested.
- DifficultyManager: Tracks the current difficulty level (1–5) and handles increasing difficulty as the game progresses.
- ScoreManager: Manages the player’s score and applies difficulty‑based scoring multipliers.
- TTS: Handles text‑to‑speech functionality for reading words aloud and repeating them.
- Timer: Manages the 10‑second countdown for each round and will notify the game when time runs out.
- UI: Displays information to the player (timer, score, messages) and collects user input.


# Next Steps
- Connect the classes together inside `GameController`
- Load actual word lists into `WordBank`
- Implement the TTS and Timer functionality
- Build the UI interactions
- Begin writing the game loop and round logic
