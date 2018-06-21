package com.team2;

public class Goal {
    public float x;
    public float y;
    private float moveMin = -0.5f;
    private float movePlus = 0.5f;
    Person person;
    GameCourt game;


    public Goal(Person person){
        this.x = 50;
        this.y = 10;
        this.person = person;
    }


    public int getY() {
        return (int)y;
    }

    public int getX() {
        return (int)x;
    }

    public void setY(float y) {
        if(person.getY() <= getY())
            this.y = y + movePlus;
        else
            this.y = y + moveMin;
    }

    public void setX(float x) {

        if(person.getX() <= getX())
            this.x = x + movePlus;
        else
            this.x = x + moveMin;
    }
}
