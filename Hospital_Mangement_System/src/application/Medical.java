package application;

import java.util.Scanner;

public class Medical {
    private String name, manufacturer, expiryDate;
    private int cost, count;

    public Medical(String name, String manufacturer, String expiryDate, int cost, int count) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.expiryDate = expiryDate;
        this.cost = cost;
        this.count = count;
    }

    public Medical(){
        this("","","",0,0);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getCost() {
        return cost;
    }

    public int getCount() {
        return count;
    }

    public String getName(){
        return this.name;
    }

    public void newMedical(){
        Scanner input = new Scanner(System.in);
        System.out.println("New Medical Object ");

        System.out.print("Enter the of the Medical Object: ");
        name = input.nextLine();

        System.out.print("Enter the manufacturer of the Medical Object: ");
        manufacturer = input.nextLine();

        System.out.print("Enter the expiry Date of the Medical Object: ");
        expiryDate = input.nextLine();

        System.out.print("Enter the cost of the Medical Object: ");
        String choice;
        do{
            choice = input.nextLine();
            if(!choice.matches("[0-9]+")) {
                System.out.println("Error! What you have just inputed is not an integer!!");
                System.out.printf("%-"+(10)+"s%s","",">> ");
            }
        }while(!choice.matches("[0-9]+"));
        cost = Integer.parseInt(choice);

        System.out.print("Enter the number of units of the Medical Object: ");
        do{
            choice = input.nextLine();
            if(!choice.matches("[0-9]+")) {
                System.out.println("Error! What you have just inputed is not an integer!!");
                System.out.printf("%-"+(10)+"s%s","",">> ");
            }
        }while(!choice.matches("[0-9]+"));
        count = Integer.parseInt(choice);
    }

    public void findMedical(){
        System.out.printf("%-15s%-20s%-20s%-10s%s",name,manufacturer,expiryDate,"RM"+String.format("%.2f",cost*1.0),count+"\n");
    }

    public String toString(){
        return name+",>"+manufacturer+",>"+expiryDate+",>"+"RM"+String.format("%.2f",cost*1.0)+",>"+count;
    }

    public boolean equals(Object obj){
        if(obj == this)
            return true;

        if(!(obj instanceof Medical))
            return false;

        Medical comparedObj = (Medical) obj;

        return comparedObj.name.equals(this.name);
    }
}
