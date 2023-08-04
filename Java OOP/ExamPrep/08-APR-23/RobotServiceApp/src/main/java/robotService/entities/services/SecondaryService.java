package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.Robot;

public class SecondaryService extends BaseService{
    public SecondaryService(String name) {
        super(name, 15);
    }

    @Override
    public void addRobot(Robot robot) {
        if(!robot.getClass().equals(FemaleRobot.class)){
            throw new IllegalArgumentException(ConstantMessages
                    .UNSUITABLE_SERVICE);
        }
        super.addRobot(robot);
    }
}
