package StrategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int result = Integer.compare(p1.getName().length(), p2.getName().length());
        if(result == 0){
            char firstPersonChar = p1.getName().charAt(0);
            if(Character.isUpperCase(firstPersonChar)){
                firstPersonChar = Character.toLowerCase(firstPersonChar);
            }

            char secondPersonChar = p2.getName().charAt(0);
            if(Character.isUpperCase(secondPersonChar)){
                secondPersonChar = Character.toLowerCase(secondPersonChar);
            }

            result = Character.compare(firstPersonChar, secondPersonChar);
        }

        return result;
    }
}
