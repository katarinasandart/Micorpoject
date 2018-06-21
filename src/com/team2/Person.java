package com.team2;

public class Person {
    public int x;
    public int y;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x >= 1 && x <= 78)
            this.x = x;
    }

    public void setY(int y) {
        if (y >=1 && y <=22)
            this.y = y;
    }
}
