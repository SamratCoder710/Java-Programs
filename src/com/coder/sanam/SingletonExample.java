package com.coder.sanam;



class DemoSingletonTutorial{
    //Lazy Initialization
    private static DemoSingletonTutorial instance = null;

    private DemoSingletonTutorial(){

    }

    public static DemoSingletonTutorial getInstance(){
        if(instance == null){
            //double-checked locking pattern
            synchronized (DemoSingletonTutorial.class){
                if(instance == null){
                    instance = new DemoSingletonTutorial();
                }
            }

        }
        return instance;
    }
}


class DemoSingletonTutorialEarly {
    //Lazy Initialization
    private static DemoSingletonTutorialEarly instance = new DemoSingletonTutorialEarly();

    private DemoSingletonTutorialEarly(){

    }

    public static DemoSingletonTutorialEarly getInstance(){
        return instance;
    }
}

//Only One Object
public class SingletonExample {

    public static void main(String[] args) {
        DemoSingletonTutorialEarly obj = DemoSingletonTutorialEarly.getInstance();

        DemoSingletonTutorialEarly instance = DemoSingletonTutorialEarly.getInstance();

//        DemoSingletonTutorial obj = DemoSingletonTutorial.getInstance();
//
//        DemoSingletonTutorial instance = DemoSingletonTutorial.getInstance();

        //same hashcode
        System.out.println(obj.hashCode());
        System.out.println(instance.hashCode());

        //Hexadecimal representation of Hash code
        System.out.println(obj);
        System.out.println(instance);

        //If they point to same reference
        if(obj == instance){
            System.out.println("They point to same memory location");
        }else{
            System.out.println("They don't point to same memory location");
        }

    }
}
