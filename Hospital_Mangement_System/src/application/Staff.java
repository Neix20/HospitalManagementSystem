package application;

import java.util.Scanner;

public class Staff extends Person{
    private String designation, sex;
    private int salary;

    public Staff(String id, String name, String designation, String sex, int salary) {
        super(id,name);
        this.designation = designation;
        this.sex = sex;
        this.salary = salary;
    }

    public Staff(){
        this("","","","",0);
    }

    public String getDesignation() {
        return designation;
    }

    public String getSex() {
        return sex;
    }

    public int getSalary() {
        return salary;
    }

    public void newInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("New Staff Member");

        System.out.print("Enter the id of the staff: ");
        setId(input.nextLine());

        System.out.print("Enter the name of the staff: ");
        setName(input.nextLine());

        System.out.print("Enter the designation of the staff: ");
        designation = input.nextLine();

        System.out.print("Enter the sex of the staff: ");
        sex = input.nextLine();

        System.out.print("Enter the salary of the staff: ");
        String choice;
        do{
            choice = input.nextLine();
            if(!choice.matches("[0-9]+")) {
                System.out.println("Error! What you have just inputed is not an integer!!");
                System.out.printf("%-"+(10)+"s%s","",">> ");
            }
        }while(!choice.matches("[0-9]+"));
        salary = Integer.parseInt(choice);
    }

    public void showInfo(){
        System.out.printf("%-6s%-30s%-25s%-15s%s",getId(),getName(),designation,sex,"RM"+String.format("%.2f",salary*1.0)+"\n");
    }

    public String toString() {
        return getId()+",>"+getName()+",>"+designation+",>"+sex+",>RM"+ String.format("%.2f", salary * 1.0);
    }

    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
