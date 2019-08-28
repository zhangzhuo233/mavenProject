package com.bd.designPatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javacore
 * @description: 观察者模式
 * @author: Mr.zhang
 * @create: 2019-08-28 18:40
 **/
public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new Users(subject);
        new Users(subject);
        subject.setState(10);
    }
}

class Subject {
    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void notifyAllObservers() {
        for (Observer observer:
             observers) {
            observer.update();
        }
    }
}

abstract class Observer {
    Subject subject;
    abstract void update();
}

class Users extends Observer {
    public Users(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(subject +
                " " + subject.getState());
    }
}




