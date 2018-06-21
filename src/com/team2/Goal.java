package com.team2;

public class Goal {
    public int x;
    public int y;
    private int moveMin = -1;
    private int movePlus = 1;
    Person person;


    public Goal(Person person) {
        this.x = 10;
        this.y = 10;
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
        if (person.getX() <= getX() && getY() < 78)
            this.x = x + movePlus;
        else if (getX() > 1)
            this.x = x + moveMin;
    }
}
