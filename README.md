# Math Puzzle Game

A desktop math puzzle game built with **JavaFX**. Solve 30 unique math puzzles level by level, with a sleek user interface, hints, and fun visuals.

---

## 🎯 Features

- 30 levels of math puzzles
- Attractive JavaFX UI
- Hints and visual feedback
- Custom application icon
- EXE version for easy use on Windows

---

## 🗂️ Folder Structure

MATH PUZZLE GAME/
│
├── MathGameProject/
│ ├── pics/ # All level images, hints, tick logos
│ │ ├── level1.png
│ │ ├── level2.png
│ │ └── ...
│ │
│ ├── MathPuzzleApp.java
│ ├── MathPuzzleHomePage.java
│ ├── MathPuzzleLevelPage.java
│ ├── Level1Page.java
│ ├── Level2Page.java
│ ├── ...
│ ├── ContinuePage.java
│ ├── LastPage.java
│ ├── SecondLastPage.java
│ ├── MainFile.java
│ ├── MathPuzzleGame.jar # JAR file of the app
│ ├── MathPuzzleGame.exe # EXE created via Launch4j
│ ├── applogo.ico # App icon
│ ├── runtime/ # Custom JVM created with jlink
│ │ ├── bin/
│ │ ├── lib/
│ │ └── ...
│ └── .gitignore
│
├── dist/ # (optional) Used during jpackage experiments
│
└── .vscode/ # VS Code configs


---

## 🚀 How to Run

### ✅ Run Directly For Playing

Just double-click:
MATHPUZZLEGAME/MathGameProject/MathPuzzleGame.exe

### ✅ Run JAR manually

If you have Java and JavaFX installed, run:

```powershell
java --module-path "C:\javafx-sdk-21.0.7\lib" --add-modules javafx.controls,javafx.fxml -jar MathPuzzleGame.jar
```

### ✅ Build Instructions

This app was built using JavaFX and Launch4j. If you ever need to rebuild:

- Compile Java files: 
    javac --module-path "C:\javafx-sdk-21.0.7\lib" --add-modules javafx.controls,javafx.fxml MathPuzzleApp.java

- Create JAR:
    jar --create --file MathPuzzleGame.jar --main-class=MathPuzzleApp -C . .

- Create Custom Runtime:
    jlink --module-path "C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\jmods;C:\javafx-sdk-21.0.7\lib" --add-modules java.base,javafx.controls,javafx.fxml --output runtime

- Craete EXE cia Launch4j
    in launch4j:
        Jar: MathPuzzleGame.jar

            Output EXE: MathPuzzleGame.exe

            Icon: applogo.ico

            Bundled JRE path: runtime

            Min JRE version: 21

            JVM Options:
                --module-path "C:\javafx-sdk-21.0.7\lib" --add-modules javafx.controls,javafx.fxml


## 👨‍💻 Author

Sarib Khan