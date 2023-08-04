package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseService implements Service{

    private String name;

    private int capacity;

    private Collection<Supplement> supplements;

    private Collection<Robot> robots;

    public BaseService(String name, int capacity){
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages
                    .SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if(this.robots.size() >= this.capacity){
            throw new IllegalStateException(ConstantMessages
                    .NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        robots.forEach(Robot::eating);
    }

    @Override
    public int sumHardness() {
        return supplements.stream()
                .mapToInt(Supplement::getHardness)
                .sum();
    }

    @Override
    public String getStatistics() {
        List<String> robotNames = new ArrayList<>();
        this.robots.forEach(r -> robotNames.add(r.getName()));
        if(robotNames.size() == 0){
            robotNames.add("none");
        }
        return String.format("%s %s:\n" + "Robots: %s\n" +
                        "Supplements: %d Hardness: %d",
                this.name, this.getClass().getSimpleName(),
                String.join(" ", robotNames),
                this.supplements.size(), sumHardness());
    }
}
