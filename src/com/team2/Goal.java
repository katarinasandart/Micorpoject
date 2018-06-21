package com.team2;

import java.util.Random;

public class Goal {
    public int x;
    public int y;
    private int moveMin = -1;
    private int movePlus = 1;
    Person person;

    Random random = new Random();


    public Goal(Person person) {
        this.x = random.nextInt(70);
        this.y = random.nextInt(19);
        this.person = person;
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        if (person.getY() <= getY() && getY() < 22)
            this.y = y + movePlus;
        else if (getY() > 1)
            this.y = y + moveMin;
    }

    public void setX(int x) {
        if (person.getX() <= getX() && getX() < 78)
            this.x = x + movePlus;
        else if (getX() > 1)
            this.x = x + moveMin;
    }
}
