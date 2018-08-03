package Framework;

import org.testng.annotations.Test;

public class carTest extends Auto {
   @Test
   public void createCar(){
       Auto car = new Auto();
       car.setBrand("BMW");
       car.setColour("Yellow");
       car.setQtyDoors(3);
       car.setMotorType("Inline 6, 3.0liter");
       calcTorque(5390,431);
   }
}

