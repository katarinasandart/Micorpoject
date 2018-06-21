package com.team2;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GameCourt game = new GameCourt();
        game.movement();
    }
}



