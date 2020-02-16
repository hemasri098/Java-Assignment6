package com.company;
class ConstructorOverloading {
    ConstructorOverloading() {
        this("calling parameterised constructor");
        System.out.println("non parameterised constructor");
    }
    ConstructorOverloading(String str) {
        System.out.println("parameterised constructor with variable " + str);
    }
    public static void main(String[] args) {
        ConstructorOverloading constructor = new ConstructorOverloading();
    }
}
class Constructor {
    Constructor(String string){
        System.out.println("parameterised constructor with variable:" + string);
    }
}
class ArrayOfObjects {
    public static void main(String[] args) {
        Constructor[] arrayOfObjects =new Constructor[5]; //this does not create the objects
        for (int i = 0 ; i < 5 ; i++) {
            arrayOfObjects[0] = new Constructor("constructor Object " + i);
        }
        //without for loop there won't be any output displayed because objects are not created.
    }
}
public class Assignment6 {
    //vampire number
}
