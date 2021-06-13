package application;

import java.util.Scanner;

public class Facility {
    private String facility;

    public Facility(String facility){
        this.facility = facility;
    }

    public Facility(){
        this("");
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public void newFacility(){
        Scanner input = new Scanner(System.in);
        System.out.println("New Facility");

        System.out.print("Enter the name of the facility: ");
        facility = input.nextLine();
    }

    public void showFacility(){
        System.out.println(facility);
    }

    public String toString(){
        return facility;
    }

    public boolean equals(Object obj){
        if(obj == this)
            return true;

        if(!(obj instanceof Facility))
            return false;

        Facility compared = (Facility) obj;

        return compared.facility.equals(this.facility);
    }
}
