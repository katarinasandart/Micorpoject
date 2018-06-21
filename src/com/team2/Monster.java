package com.team2;

public class Monster {
    public float x;
    public float y;
    private float moveMin = -0.5f;
    private float movePlus = 0.5f;
    Person person;


    public Monster(Person person) {
        this.x = 10;
        this.y = 2;
        this.person = person;
    }


    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
        if (person.getY() >= getY())
            this.y = y + movePlus;
        else if (getY() > 1)
            this.y = y + moveMin;
    }

    public void setX(float x) {
        if (person.getX() >= getX())
            this.x = x + movePlus;
        else if (getX() > 1)
            this.x = x + moveMin;
    }
}
