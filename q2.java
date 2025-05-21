class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    Vehicle() {

    }
    Vehicle(String licencePlate, String ownerName, int hoursParked) {
        this.licensePlate = licencePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public int getHoursParked() {
        return hoursParked;
    }

}

class ParkingLot {
    int vehicleCount = 0;
    Vehicle[] vehicleArray = new Vehicle[5];

    public void park(Vehicle vehicle) {
        vehicleArray[vehicleCount++] = vehicle;
    }

    public void removeVehicle(String licensePlate) {
        int i = 0;
        for(; i<5; i++) {
            if(vehicleArray[i] != null) {
                if(vehicleArray[i].getLicensePlate() == licensePlate) {
                    vehicleArray[i] = null;
                    break;
                }
            }
        }
        while(vehicleArray[i] != null || i != vehicleArray.length-1) {
            vehicleArray[i++] = vehicleArray[i];
        }
    }

    public void displayDetails() {
        for(Vehicle vehicle : vehicleArray) {
            if(vehicle != null) {
                System.out.println("License Plate : "+vehicle.getLicensePlate()+" Owner Name : "+vehicle.getOwnerName()+" Hours Parked : "+vehicle.getHoursParked());
            }

        }
    }
}

class Demo {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(new Vehicle("ABC123", "John Doe", 2));
        parkingLot.park(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.park(new Vehicle("LMN456", "Bob Brown", 1));

        parkingLot.removeVehicle("XYZ789");

        parkingLot.displayDetails();


    }
}