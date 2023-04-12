package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public void push(String item){
        this.data.add(0, item);
    }

    public String pop(){
        if(this.data.isEmpty()){
            return null;
        }
        String str = this.data.get(0);
        this.data.remove(0);
        return str;
    }

    public String peek(){
        if(this.data.isEmpty()){
            return null;
        }
        return this.data.get(0);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
