package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseWorker implements Worker{

    private String name;

    private int strength;

    private Collection<Tool> tools;

    public BaseWorker(String name, int strength){
        setName(name);
        setStrength(strength);
        this.tools = new ArrayList<>();
    }

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages
                    .WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setStrength(int strength) {
        if(strength < 0){
            throw new IllegalArgumentException(ExceptionMessages
                    .WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public void working() {
        decrementStrength(10);
        if(this.strength < 0){
            this.strength = 0;
        }
    }

    protected void decrementStrength(int amount){
        this.strength -= amount;
    }

    @Override
    public void addTool(Tool tool) {
        tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return (this.strength > 0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return tools;
    }
}
