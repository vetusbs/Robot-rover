package com.vetus.robotic.rover.scenario;

public enum Command {
    L {
        public void execute(RoverRobot robot) {
            robot.turnLeft();
        }
    },
    R {
        public void execute(RoverRobot robot) {
            robot.turnRight();
        }
    },
    M {
        public void execute(RoverRobot robot) {
            robot.move();
        }
    };

    public abstract void execute(RoverRobot robot);

}
