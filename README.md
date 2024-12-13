# Tic-Tac-Toe Game

Welcome to the **Tic-Tac-Toe Game**, a JavaFX-based desktop application that provides a fun and engaging way to play the classic game. This project implements robust design patterns, AI strategies, and state management to ensure a professional and seamless user experience.

---

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage Guide](#usage-guide)
- [Modules Overview](#modules-overview)
    - [Controllers](#controllers)
    - [Models](#models)
    - [Factories](#factories)
    - [Utilities](#utilities)
    - [Services](#services)
- [AI Strategies](#ai-strategies)
- [Game States and Persistence](#game-states-and-persistence)
- [File Structure](#file-structure)
- [How to Contribute](#how-to-contribute)


---

## Features

This project also includes comprehensive unit tests for various components, ensuring robust functionality and easy maintainability.

### Core Features:
- **Player vs Player**: Compete with a friend locally.
- **Player vs AI**: Challenge an AI opponent with two difficulty levels:
    - *Easy*: AI makes random moves.
    - *Hard*: AI uses the Minimax algorithm for optimal gameplay.
- **Leaderboard**: Tracks and displays player win counts.
- **Game Results**: View the history of past game results.
- **Modern UI**: Clean and responsive design for better user interaction.

### Additional Features:
- Persistent storage for leaderboard and game results.
- Robust error handling with detailed logs.
- Real-time updates to the game board and status messages.

---

## Technologies Used

- **Java 11+**: Core programming language.
- **JavaFX**: User interface framework.
- **TinyLog**: Lightweight logging library for debug and error tracking.
- **FXML**: Declarative UI design with XML.

---

## Setup and Installation

### Prerequisites:
1. Java Development Kit (JDK) 11 or higher.
2. IDE (e.g., IntelliJ IDEA, Eclipse, or NetBeans).
3. Maven (for dependency management).

### Steps:
1. Clone this repository:
   ```bash
   git clone https://github.com/your-repo/tictactoe.git
   ```
2. Navigate to the project directory:
   ```bash
   cd tictactoe
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn javafx:run
   ```

---

## Usage Guide

### Starting the Game:
1. Launch the application.
2. Choose between "Player vs AI" or "Player vs Player" mode.
3. Follow the on-screen prompts:
    - For Player vs AI:
        - Select AI difficulty (Easy/Hard).
        - Enter your name.
    - For Player vs Player:
        - Enter names for both players.
4. Play the game and enjoy!

### Viewing Stats:
- After the game ends, view results and leaderboard from the "Stats" screen.

---

## Modules Overview

The project structure is complemented by a suite of unit tests to verify the behavior and correctness of each module, increasing the reliability of the system.

### Controllers
Manages the application's user interactions and UI logic, and includes unit tests to validate all controller functionalities:
- **MainMenuController**: Handles game mode selection.
- **AIDifficultyController**: Manages AI difficulty selection and player name input.
- **EnterNamesController**: Handles player name inputs for Player vs Player mode.
- **GameController**: Manages the game board and gameplay logic.
- **StatsController**: Displays game results and leaderboard.

### Models
Encapsulates business logic and core application data. Extensive unit tests ensure the correctness of operations such as move validation, state transitions, and win condition detection:
- **Player**: Represents players with their name and symbol.
- **Board**: Manages the Tic-Tac-Toe board state.
- **GameState**: Manages game logic, including turn switching and win conditions.
- **AIPlayer**: Represents the AI opponent with its strategies.
- **Leaderboard**: Tracks and persists player win counts.
- **Stats**: Manages and persists game results.

### Factories
Provides reusable components for dynamic instantiation:
- **ControllerFactory**: Creates pre-configured controllers and stages.
- **StrategyFactory**: Manages and retrieves AI difficulty strategies.

### Utilities
Simplifies error handling, logging, and file operations:
- **ErrorHandler**: Logs warnings/errors and displays alerts.
- **FileUtils**: Handles file read/write operations.

### Services
Manages data persistence:
- **FilePersistenceService**: Saves and loads game results.
- **StatsPersistenceService**: Handles leaderboard statistics.

---

## AI Strategies

### Easy Strategy
- Randomly selects an available cell on the board.
- Suitable for casual players or beginners.

### Hard Strategy
- Implements the **Minimax Algorithm**:
    - Evaluates all possible moves and outcomes.
    - Optimizes for the best possible result for the AI.
    - Challenges experienced players.

---

## Game States and Persistence

### Game Results
- Results are stored persistently in a file (`game_results.txt`).
- Accessible via the "Stats" screen.

### Leaderboard
- Tracks player wins and persists data in `leaderboard.txt`.
- Sorted by the number of wins in descending order.

---

## File Structure

### Unit Tests
Unit tests are located alongside their respective modules to ensure modular testing and ease of maintenance:
```
project-root/
├── src/test/java/org/example/testtictactoe/
│   ├── models/            # Tests for core game models
```

```
project-root/
├── src/main/java/org/example/testtictactoe/
│   ├── controllers/       # JavaFX controllers
│   ├── factories/         # Factory classes
│   ├── models/            # Core game models
│   ├── services/          # Persistence services
│   ├── utils/             # Utility classes
│   ├── Main.java          # Application entry point
│
├── src/main/resources/
│   ├── org/example/views/ # FXML files for UI
│   ├── styles/            # CSS stylesheets
│
├── target/                # Compiled classes
├── pom.xml                # Maven configuration
└── README.md              # Project documentation
```

---

## How to Contribute

1. Fork the repository.
2. Create a new feature branch:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add feature-name"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-name
   ```
5. Open a pull request and describe your changes.

---


---

Enjoy playing Tic-Tac-Toe and feel free to contribute to make this project even better!
