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

public class GameCourt {
    Terminal terminal;
    Screen screen;
    ScreenWriter writer;
    Person person;
    Monster monster;
    Goal goal;

    public void drawScreen() throws InterruptedException {

        terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF-8"));
        screen = new Screen(terminal);
        person = new Person();
        monster = new Monster(person);
        goal = new Goal(person);
        screen.startScreen();
        writer = new ScreenWriter(screen);
        writer.drawString(person.getX(), person.getY(),"\u263A");
        drawBorder();
    }
    public void movement() throws InterruptedException{
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
                    person.setY(person.getY() + 1);
                    writer.drawString(person.getX(), person.getY(),"\u263A");
                    drawMonster();
                    drawGoal();
                    break;
                case ArrowUp:
                    person.setY(person.getY() - 1);
                    writer.drawString(person.getX(), person.getY(),"\u263A");
                    drawMonster();
                    drawGoal();
                    break;
                case ArrowLeft:
                    person.setX(person.getX() - 1);
                    writer.drawString(person.getX(), person.getY(),"\u263A");
                    drawMonster();
                    drawGoal();
                    break;
                case ArrowRight:
                    person.setX(person.getX() + 1);
                    writer.drawString(person.getX(), person.getY(),"\u263A");
                    drawMonster();
                    drawGoal();
                    break;
                case Escape:
                    System.exit(0);
            }
            drawBorder();
            collide(person.getX(), person.getY(), monster.getX(), monster.getY());
            screen.refresh();

        }
    }
    public void drawMonster(){
        monster.setX(monster.getX());
        monster.setY(monster.getY());
        writer.drawString(monster.getX(), monster.getY(),"\u2639");
    }

    public void drawGoal(){
        goal.setX(goal.getX());
        goal.setY(goal.getY());
        writer.drawString(goal.getX(), goal.getY(), "0");
    }

    public void drawBorder() {
        writer.drawString(0, 0, "################################################################################");
        for (int i = 1; i < 23; i++) {
            writer.drawString(0, i, "#");
            writer.drawString(79, i, "#");
        }
        writer.drawString(0, 23, "################################################################################");
        screen.refresh();
    }
    public void collide(int x, int y, int x2,int y2) {
        if(x == x2 && y == y2 || x == 0 || x == 79 || y == 0 || y == 23)
            gameOver();
    }
    public void gameOver(){
        screen.clear();
        drawBorder();
        writer.drawString(20, 10, "##############################");
        writer.drawString(20, 11, "#         Game over!         #");
        writer.drawString(20, 12, "##############################");
    }
}