package Framework;

public class Auto {
    String colour;
    String brand;
    int qtyDoors;
    String motorType;
    public void setColour(String carColour){
        System.out.println("The colour of your car is: " + carColour);
    }

    public void setBrand(String carBrand){
        System.out.println("The brand of your car is: " + carBrand);
    }
    public void setQtyDoors(int carDoors){
        System.out.println("Your car has: " + carDoors + " doors");
    }
    public void setMotorType(String carMotor){
        System.out.println("Your engine type is: " + carMotor);
    }
    public void calcTorque(int engineRPM, int force){
        int torque;
        int waarde = 5252;
        torque = (force * waarde)/ engineRPM;
        System.out.println("Your car his torque is: " + torque + " nm");


    }

}
