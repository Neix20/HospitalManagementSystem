package application;

import java.util.Scanner;

public class Lab extends Facility{
    private int cost;

    public Lab(String lab, int cost) {
        super(lab);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public Lab(){
        this("",0);
    }

    public void newLab(){
        Scanner input = new Scanner(System.in);
        System.out.println("New Lab");

        System.out.print("Enter the name of the facility: ");
        setFacility(input.nextLine());
        System.out.print("Enter the cost of the facility: ");
        String choice;
        do{
            choice = input.nextLine();
            if(!choice.matches("[0-9]+")) {
                System.out.println("Error! What you have just inputed is not an integer!!");
                System.out.printf("%-"+(10)+"s%s","",">> ");
            }
        }while(!choice.matches("[0-9]+"));
        cost = Integer.parseInt(choice);
    }

    public void labList(){
        System.out.printf("%-30s%s",getFacility(),"RM"+String.format("%.2f",cost*1.0)+"\n");
    }

    public String toString(){
        return getFacility()+",>RM"+String.format("%.2f",cost*1.0);
    }

    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
