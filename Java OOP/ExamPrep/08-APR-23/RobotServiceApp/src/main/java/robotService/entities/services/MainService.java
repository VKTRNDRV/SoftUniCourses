package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;

public class MainService extends BaseService{
    public MainService(String name) {
        super(name, 30);
    }

    @Override
    public void addRobot(Robot robot) {
        if(!robot.getClass().equals(MaleRobot.class)){
            throw new IllegalArgumentException(ConstantMessages
                    .UNSUITABLE_SERVICE);
        }
        super.addRobot(robot);
    }
}
