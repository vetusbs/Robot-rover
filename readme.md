## Compile the project
 ./gradlew build

## Execute Application
  java -jar ./build/libs/rovotic-rover-1.0-SNAPSHOT.jar

## Available endpoints

| Endpoint | Example | Result |
| -------- | ------  | ------ |
| /position | curl localhost:8090/position -v | {"position":{"x":1,"y":3},"direction":"N"}
| /rover?sequence={sequence} | curl -X POST localhost:8090/rover?sequence=LMLMLMLMM -v |


Things to improve:
  * Exception handling should return proper objects
  * Validate rest entry before parsing Spring validator regex
  * Change enums to proper objects. This is not testeable
  * Check methods and classes protection. It might be wrong.
  * Make it more extensible
