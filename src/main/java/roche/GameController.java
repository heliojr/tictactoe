package roche;

import org.springframework.web.bind.annotation.*;

@RestController
    public class GameController {

        @RequestMapping(value = "/nextmovement", method = { RequestMethod.POST}, produces = "application/json")
        public @ResponseBody TicTacToe ComputerNextMovement(@RequestBody TicTacToe game ) {

            TicTacToe newBoard = new TicTacToe(game);
            newBoard.getComputerMove();

            return newBoard;
        }
    }
