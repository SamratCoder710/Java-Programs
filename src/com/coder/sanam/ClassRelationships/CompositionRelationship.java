package com.coder.sanam.ClassRelationships;


//Composition is a stronger form of aggregation where one class owns the other. If the owner class is destroyed, its components are also destroyed.

//Example: A Car has an Engine.
class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Car {
    private Engine engine;

    public Car(String engineType) {
        this.engine = new Engine(engineType);
    }

    public void showDetails() {
        System.out.println("Car has a " + engine.getType() + " engine.");
    }
}


public class CompositionRelationship {
    public static void main(String[] args) {
        Car car = new Car("V8");
        car.showDetails();
    }
}
