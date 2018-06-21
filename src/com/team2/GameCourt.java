package com.team2;

//by Gustaf Matsson
//2018-06-20

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class GameCourt {

    public void board() throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));

        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        int x = 0;
        int y = 0;
        int x2 = 5;
        int y2 = 5;

        while (true)

        {
//Wait for a key to be pressed
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            }
            while (key == null);
            switch (key.getKind()) {
                case ArrowDown:
                    terminal.clearScreen();
                    terminal.moveCursor(x, ++y);
                    terminal.putCharacter('\u263A');
                    terminal.moveCursor(x2, y2 -= 2);
                    terminal.putCharacter('X');
                    break;
                case ArrowUp:
                    terminal.clearScreen();
                    terminal.moveCursor(x, --y);
                    terminal.putCharacter('\u263A');
                    terminal.moveCursor(x2, y2 -= 2);
                    terminal.putCharacter('X');
                    break;
                case ArrowLeft:
                    terminal.clearScreen();
                    terminal.moveCursor(--x, y);
                    terminal.putCharacter('\u263A');
                    terminal.moveCursor(x2 -= 2, y2);
                    terminal.putCharacter('X');
                    break;
                case ArrowRight:
                    terminal.clearScreen();
                    terminal.moveCursor(++x, y);
                    terminal.putCharacter('\u263A');
                    terminal.moveCursor(x2 += 2, y2);
                    terminal.putCharacter('X');
                    break;
            }
        }
    }
}
