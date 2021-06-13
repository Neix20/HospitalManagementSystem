package application;

import java.util.Scanner;

public class Patient extends Person {
    private String disease, sex, admitStatus;
    private int age;

    public Patient(String id, String name, String disease, String sex, String admitStatus, int age) {
        super(id,name);
        this.disease = disease;
        this.sex = sex;
        this.admitStatus = admitStatus;
        this.age = age;
    }

    public Patient(){
        this("","","","","",0);
    }

    public void newInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("New Patient ");

        System.out.print("Enter the id of the Patient: ");
        setId(input.nextLine());

        System.out.print("Enter the name of the Patient: ");
        setName(input.nextLine());

        System.out.print("Enter the disease of the Patient: ");
        disease = input.nextLine();

        System.out.print("Enter the sex of the Patient: ");
        sex = input.nextLine();

        System.out.print("Enter the status of the Patient: ");
        admitStatus = input.nextLine();

        System.out.print("Enter the age of the Patient: ");
        String choice;
        do{
            choice = input.nextLine();
            if(!choice.matches("[0-9]+")) {
                System.out.println("Error! What you have just inputed is not an integer!!");
                System.out.printf("%-"+(10)+"s%s","",">> ");
            }
        }while(!choice.matches("[0-9]+"));
        age = Integer.parseInt(choice);
    }

    public void showInfo(){
        System.out.printf("%-6s%-30s%-25s%-10s%-15s%s",getId(),getName(),disease,sex,admitStatus,age+"\n");
    }

    public String getDisease() {
        return disease;
    }

    public String getSex() {
        return sex;
    }

    public String getAdmitStatus() {
        return admitStatus;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return getId()+",>"+getName()+",>"+disease+",>"+sex+",>"+admitStatus+",>"+age;
    }

    public boolean equals(Object obj){
        return super.equals(obj);
    }
}
