package com.team2;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Player {
    public int x;
    public int y;

    public Player(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void arrowDown(int x, int y){
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        terminal.moveCursor(x, ++y);
        terminal.putCharacter('\u263A');
    }
}
