package com.team2;

//by Gustaf Matsson
//2018-06-20

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;
import java.util.Random;

import static com.googlecode.lanterna.input.Key.Kind.ArrowDown;

public class GameCourt {
    Terminal terminal;
    Screen screen;
    ScreenWriter writer;
    Person person;
    Monster[] monsters;
    Goal goal;
    int counter = 1;

    public void startGame() {
        monsters = new Monster[10];
        person = new Person(40, 10);
        for(int i = 0; i < counter; i++)
            monsters[i] = new Monster(person);
        goal = new Goal(person);
    }
    public void drawScreen() throws InterruptedException {

        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF-8"));
        screen = new Screen(terminal);
        screen.startScreen();
        writer = new ScreenWriter(screen);
        writer.setForegroundColor(Terminal.Color.CYAN);
        screen.setCursorPosition(null);
        drawStart();
        startGame();
    }

    public void movement() throws InterruptedException {
        drawScreen();
        while (true) {
            screen.clear();
            Key key;
            do {
                Thread.sleep(5);
                key = screen.readInput();
            }
            while (key == null);
            switch (key.getKind()) {
                case ArrowDown:
                    drawPerson(0);
                    for(Monster m: monsters)
                        drawMonster(m);
                    drawGoal();
                    break;
                case ArrowUp:
                    drawPerson(1);
                    for(Monster m: monsters)
                        drawMonster(m);
                    drawGoal();
                    break;
                case ArrowLeft:
                    drawPerson(2);
                    for(Monster m: monsters)
                        drawMonster(m);
                    drawGoal();
                    break;
                case ArrowRight:
                    drawPerson(3);
                    for(Monster m: monsters)
                        drawMonster(m);
                    drawGoal();
                    break;
                case Escape:
                    System.exit(0);
            }
            drawBorder();
            for(Monster m: monsters) {
                if (m != null)
                    collideGameOver(person.getX(), person.getY(), m.getX(), m.getY());
            }
            collideWin(person.getX(), person.getY(), goal.getX(), goal.getY());
            screen.refresh();
        }
    }

    public void drawPerson(int x) {
        switch (x) {
            case 0:
                person.setY(person.getY() + 1);
                writer.drawString(person.getX(), person.getY(), "\u263A");
                break;
            case 1:
                person.setY(person.getY() - 1);
                writer.drawString(person.getX(), person.getY(), "\u263A");
                break;
            case 2:
                person.setX(person.getX() - 1);
                writer.drawString(person.getX(), person.getY(), "\u263A");
                break;
            case 3:
                person.setX(person.getX() + 1);
                writer.drawString(person.getX(), person.getY(), "\u263A");
                break;
        }
    }

    public void drawMonster(Monster monster) {
        if(monster != null) {
            if (monster.getY() != person.getY())
                monster.setY(monster.getY());
            if (monster.getX() != person.getX())
                monster.setX(monster.getX());
            writer.drawString((int) monster.getX(), (int) monster.getY(), "\u6596");
        }
    }

    public void drawGoal() {
        if (goal.getY() != person.getY())
            goal.setY(goal.getY());
        if (goal.getX() != person.getX())
            goal.setX(goal.getX());
        writer.drawString((int) goal.getX(), (int) goal.getY(), "\u2764");
    }

    public void drawBorder() {
        writer.drawString(0, 0, "#Level "+ counter+"########################################################################");
        for (int i = 1; i < 23; i++) {
            writer.drawString(0, i, "#");
            writer.drawString(79, i, "#");
        }
        writer.drawString(0, 23, "################################################################################");
        screen.refresh();
    }

    public void collideGameOver(int x, int y, float x2, float y2) throws InterruptedException {
        if (x == x2 && y == y2 || x == 0 || x == 79 || y == 0 || y == 23)
            gameOver();
    }

    public void collideWin(int x, int y, float x2, float y2) {
        if (x == x2 && y == y2)
            win();
    }

    public void gameOver() throws InterruptedException {
        screen.clear();
        drawBorder();
        writer.drawString(20, 10, "##############################");
        writer.drawString(20, 11, "#         Game over!         #");
        writer.drawString(20, 12, "#    Press key to restart    #");
        writer.drawString(20, 13, "##############################");
        counter = 1;
        startGame();
    }

    public void win() {
        counter++;
        screen.clear();
        drawBorder();
        writer.drawString(20, 10, "##############################");
        writer.drawString(20, 11, "#          You win!          #");
        writer.drawString(20, 12, "#          Level " + counter +"           #");
        writer.drawString(20, 13, "##############################");
        startGame();
    }
    public void drawStart() {
        drawBorder();
        writer.drawString(20, 10, "##############################");
        writer.drawString(20, 11, "#         The Shaw Game      #");
        writer.drawString(20, 12, "#   Press key to play level  #");
        writer.drawString(20, 13, "#              1             #");
        writer.drawString(20, 14, "##############################");
        screen.refresh();
    }
}