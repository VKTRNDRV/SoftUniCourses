package MockExam19.kindergarten;

import java.util.*;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child){
        if(registry.size() < capacity){
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName){
        for (Child child : registry){
            if(child.getFirstName().equals(firstName)){
                registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount(){
        return registry.size();
    }

    public Child getChild(String firstName){
        for (Child child : registry){
            if(child.getFirstName().equals(firstName)){
                return child;
            }
        }
        return null;
    }

    public String registryReport(){
        Collections.sort(registry, (child1, child2) -> {
            int comparisonValue = Integer.compare(child1.getAge(), child2.getAge());
            if(comparisonValue == 0){
                comparisonValue = child1.getFirstName()
                        .compareTo(child2.getFirstName());
                if(comparisonValue == 0){
                    comparisonValue = child1.getLastName()
                            .compareTo(child2.getLastName());
                }
            }

            return comparisonValue;
        });
        StringBuilder output = new StringBuilder();
        output.append("Registered children in ")
                .append(name)
                .append(":");
        for(Child child : registry){
            output.append("\n--\n")
                    .append(child.toString());
        }
        return output.toString().trim();
    }
}
