package com.vetus.robotic.rover.scenario;

public enum Direction {
    N {
        public Direction turnLeft() {
            return Direction.W;
        }

        public Direction turnRight() {
            return Direction.E;
        }
    },
    S {
        public Direction turnLeft() {
            return Direction.E;
        }

        public Direction turnRight() {
            return Direction.W;
        }
    }, E {
        public Direction turnLeft() {
            return Direction.N;
        }

        public Direction turnRight() {
            return Direction.S;
        }
    }, W {
        public Direction turnLeft() {
            return Direction.S;
        }

        public Direction turnRight() {
            return Direction.N;
        }
    };

    public abstract Direction turnRight();

    public abstract Direction turnLeft();
}
