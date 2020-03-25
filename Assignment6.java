package com.company.JavaAssignment6;

import java.util.ArrayList;
import java.util.logging.Logger;

class ConstructorOverloading {
    Logger LOGGER = Logger.getAnonymousLogger();
    ConstructorOverloading() {
        this("calling parameterised constructor");
       LOGGER.info("non parameterised constructor");
    }
    ConstructorOverloading(String str) {
        LOGGER.info("parameterised constructor with variable " + str);
    }
    public static void main(String[] args) {
        ConstructorOverloading constructor = new ConstructorOverloading();
    }
}
class Constructor {
    Logger LOGGER = Logger.getAnonymousLogger();
    Constructor(String string){
        LOGGER.info("parameterised constructor with variable:" + string);
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
class VampireNumbers{
    static Logger LOGGER = Logger.getAnonymousLogger();
    // finding all permutations
    public static ArrayList<String> getAllpermutations(String str, String result, ArrayList<String> permutations)
    {
        //if string is empty
        if (str.length() == 0) {
            permutations.add(result);
        }
        for (int i = 0; i < str.length(); i++) {

            // storing ith character
            char ch = str.charAt(i);
            String subStringAfterExcluding_i = str.substring(0, i) + str.substring(i + 1, (int)str.length());
            // Recurvise call
            getAllpermutations(subStringAfterExcluding_i, result + ch, permutations);
        }
        return permutations;
    }
    // to check wether the given string is even length or not
    public static Boolean isEvenLength(String number) {
        if(number.length() % 2 == 0)
            return true;
        return false;
    }
    // to check whether number having trailing zeros. If so, it is multiple of ten
    public static Boolean isNotMultipleOfTen(long number) {
        if(number % 10 == 0) {
            return true;
        }
        return false;
    }
    // checking whether the number is vampire or not
    public static Boolean isVampire(String permutation, long number) {
        String x = permutation.substring(0, (int)permutation.length()/2);
        String y = permutation.substring((int)permutation.length()/2, (int)permutation.length());
        if((isNotMultipleOfTen(Long.parseLong(x)) && isNotMultipleOfTen(Long.parseLong(y))) == false) {
            if (Long.parseLong(x) * Long.parseLong(y) == number) {   //if the number equals to number came after multiplying two halves
                return true;
            }
        }
        return false;
    }
    public static void main(String []args) {
        long number = 10;
        int range = 100;
        try {
            while (number > 0 && range > 0) {
                if (isEvenLength(String.valueOf(number))) {
                    ArrayList<String> permutations = new ArrayList<String>();
                    getAllpermutations(String.valueOf(number), "", permutations);
                    for (String permutation : permutations) {
                        if (isVampire(permutation, number)) {
                            LOGGER.info(String.valueOf(number));
                            range -= 1;
                            break;
                        }
                    }
                }
                number += 1;

            }
        }
        catch (Exception e) {
            LOGGER.info(String.valueOf(e));
        }

    }

}
