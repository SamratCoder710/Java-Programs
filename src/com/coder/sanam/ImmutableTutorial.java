package com.coder.sanam;

import java.util.ArrayList;
import java.util.List;

//class should be final so that it can be inherited
final class ImmutableTutorial {

    //Make fields private so that direct access is not allowed
    //Make fields final so that value can't
    private final Integer id;
    private final String name;
    private final List<String> phones;

    //A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
    public ImmutableTutorial(Integer id,String name, List<String> phones){
        this.id = id;
        this.name = name;
        this.phones = new ArrayList<>(phones);
    }

    //There should be no setters or in simpler terms,
    // there should be no option to change the value of the instance variable.
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return phones;
    }
}

//        Cannot inherit from final 'com. coder. sanam. ImmutableTutorial'
//class ChildClass extends ImmutableTutorial{
//
//}