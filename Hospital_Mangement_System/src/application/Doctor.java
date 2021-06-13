package application;

import java.util.Scanner;

public class Doctor extends Person {
    private String specialist, workTime, qualification;
    private int room;

    public Doctor(String id, String name, String specialist, String workTime, String qualification, int room) {
        super(id,name);
        this.specialist = specialist;
        this.workTime = workTime;
        this.qualification = qualification;
        this.room = room;
    }

    public Doctor(){
        this("","","","","",0);
    }

    public void newInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("New Doctor");

        System.out.print("Enter the id of the Doctor: ");
        setId(input.nextLine());

        System.out.print("Enter the name of the Doctor: ");
        setName(input.nextLine());

        System.out.print("Enter the specialist of the Doctor: ");
        specialist = input.nextLine();

        System.out.print("Enter the workTime of the Doctor: ");
        workTime = input.nextLine();

        System.out.print("Enter the qualification of the Doctor: ");
        qualification = input.nextLine();

        System.out.print("Enter the Room Number of the Doctor: ");
        String choice;
        do{
            choice = input.nextLine();
            if(!choice.matches("[0-9]+")) {
                System.out.println("Error! What you have just inputed is not an integer!!");
                System.out.printf("%-"+(10)+"s%s","",">> ");
            }
        }while(!choice.matches("[0-9]+"));
        room = Integer.parseInt(choice);
    }

    public void showInfo(){
        System.out.printf("%-6s%-30s%-25s%-15s%-10s%s",getId(),getName(),specialist,workTime,qualification,room+"\n");
    }

    public String getSpecialist() {
        return specialist;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getQualification() {
        return qualification;
    }

    public int getRoom() {
        return room;
    }

    public String toString(){
        return getId()+",>"+getName()+",>"+specialist+",>"+workTime+",>"+qualification+",>"+room;
    }

    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
