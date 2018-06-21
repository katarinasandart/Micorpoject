package com.team2;

public class Monster {
    public int x;
    public int y;
    private int moveMin = -1;
    private int movePlus = 1;
    Person person;
    GameCourt game;


    public Monster(Person person) {
        this.x = 10;
        this.y = 2;
        this.person = person;
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        if (person.getY() >= getY())
            this.y = y + movePlus;
        else if (getY() > 1)
            this.y = y + moveMin;
    }

    public void setX(int x) {
        if (person.getX() >= getX())
            this.x = x + movePlus;
        else if (getX() > 1)
            this.x = x + moveMin;
    }
}
