# tictactoe
TicTacToe Implementation

1. how to build
Maven has been used to manage the build cycle. Just create the jar file running "mvn package"

2. Running
  java -jar tictactoe-1.0-SNAPSHOT.jar
  
3. Rest API
There is one REST Api to return the computer move in the tictactoe board. 
  Request : POST localhost:8080/nextmovement
  Body : 
  {
	"user": "X",
	"computer": "O",
	"board": 
		[
			["X", "O", " "],
			[" ", "X", " "],
			[" ", " ", " "]
			]
   }
   
You will get a response with the new board configuration including the computer movement.
{
    "user": "X",
    "computer": "O",
    "board": [
        "XOO",
        " X ",
        "   "
    ]
}
