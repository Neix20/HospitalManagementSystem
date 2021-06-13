package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HospitalManagement extends Application{
    private Scene homeScene,scene[] = new Scene[6];
    private String[] str = {"Staff","Doctor","Patient","Medical","Lab","Facility"},rgbCode = {"#FF1493","#9932CC","#DC143C","#FF8C00","#32CD32","#0000FF"},rgbHover = {"#FF69B4","#DA70D6","#FA8072","#FFA500","#ADFF2F","#87CEFA"},func = {"Add","Modify","Show","Search","Delete","Exit"};
    private ArrayList<Staff> stf = new ArrayList<>();
    private ArrayList<Patient> pnt = new ArrayList<>();
    private ArrayList<Doctor> d = new ArrayList<>();
    private ArrayList<Lab> lb = new ArrayList<>();
    private ArrayList<Facility> f = new ArrayList<>();
    private ArrayList<Medical> m = new ArrayList<>();

    public HospitalManagement(){
        stf.add(new Staff("098", "Tan Xi En", "HR Department", "Male", 25700));
        stf.add(new Staff("113","Vanessa Irwin","IT Department","Female",700));
        stf.add(new Staff("111","Leonard Sheridan","HR Department","Male",700));
        stf.add(new Staff("608", "Beh Wen Xuan", "HR Department", "Male", 8840));
        stf.add(new Staff("112","Bill Collier","IT Department","Male",700));

        d.add(new Doctor("210","Tristan Oakley","Physician","5-11AM","MBBS,MD",1017));
        d.add(new Doctor("211","Ellouise Delgado","Surgeon","10-3AM","MBBS,MD",2217));
        d.add(new Doctor("212","Arianna Navarro","Therapist","5-11PM","MBBS,MD",1089));
        d.add(new Doctor("802", "Leong Mun Dee", "Physician", "10-3AM", "MBBS,MS", 45));
        d.add(new Doctor("098", "Tan Xi En", "Surgeon", "7-11AM", "MBBS,MD", 8));

        pnt.add(new Patient("310","Cinar Sutherland","Cancer","Female","y",30));
        pnt.add(new Patient("311","Maximilian Tate","Diabetes","Male","y",23));
        pnt.add(new Patient("312","Arissa Clemons","Maleriya","Female","y",45));
        pnt.add(new Patient("828", "Nathalie Ngu", "Cataract", "Female", "Ambulatory", 46));
        pnt.add(new Patient("098", "Tan Xi En", "Stomach disease", "Male", "Observation", 20));

        m.add(new Medical("Panadol","GSK Malaysia","18/8/2020",70,100));
        m.add(new Medical("Dulcolax","TXM Malaysia","4/9/2020",80,100));
        m.add(new Medical("Benadryl","YMK Malaysia","9/4/2000",90,100));
        m.add(new Medical("Eye drops", "Akorn", "05/11/2020", 35, 140));
        m.add(new Medical("Bonefos", "Bayer Oy", "14/12/2020", 427, 100));

        lb.add(new Lab("Emergency Room",20000));
        lb.add(new Lab("Radiotherapy",30000));
        lb.add(new Lab("Medical Lab 2", 100000));
        lb.add(new Lab("Pathology Lab 1", 120000));
        lb.add(new Lab("Pathology Lab 2", 150000));

        f.add(new Facility("Physiotherapy"));
        f.add(new Facility("CT Scan"));
        f.add(new Facility("MRI Scan"));
        f.add(new Facility("Blood Bank"));
        f.add(new Facility("X-ray"));

        sort();
    }//Initialize The Values

    public boolean isListEmpty(int x){
        switch(x){
            case 0: return stf.isEmpty();
            case 1: return d.isEmpty();
            case 2: return pnt.isEmpty();
            case 3: return m.isEmpty();
            case 4: return lb.isEmpty();
            case 5: return f.isEmpty();
        }
        return false;
    }

    public boolean checkLimit(int x){
        switch(x){
            case 0: return stf.size()>=100;
            case 1: return d.size()>=25;
            case 2: return pnt.size()>=100;
            case 3: return m.size()>=100;
            case 4: return lb.size()>=20;
            case 5: return f.size()>=20;
        }
        return false;
    }

    public boolean checkIfExist(int x, Object obj){
        switch(x){
            case 0: return stf.contains(obj);
            case 1: return d.contains(obj);
            case 2: return pnt.contains(obj);
            case 3: return m.contains(obj);
            case 4: return lb.contains(obj);
            case 5: return f.contains(obj);
        }
        return false;
    }

    public void addToList(int x,Object obj){
        switch(x){
            case 0: stf.add((Staff) obj); break;
            case 1: d.add((Doctor) obj); break;
            case 2: pnt.add((Patient) obj); break;
            case 3: m.add((Medical) obj); break;
            case 4: lb.add((Lab) obj); break;
            case 5: f.add((Facility) obj); break;
        }
    }

    public int listSize(int x){
        switch(x){
            case 0: return stf.size();
            case 1: return d.size();
            case 2: return pnt.size();
            case 3: return m.size();
            case 4: return lb.size();
            case 5: return f.size();
        }
        return 0;
    }

    public void sort(){
        stf = stf.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toCollection(ArrayList::new));
        d = d.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toCollection(ArrayList::new));
        pnt = pnt.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toCollection(ArrayList::new));
        m = m.stream().sorted(Comparator.comparing(Medical::getName)).collect(Collectors.toCollection(ArrayList::new));
        lb = lb.stream().sorted(Comparator.comparing(Facility::getFacility)).collect(Collectors.toCollection(ArrayList::new));
        f = f.stream().sorted(Comparator.comparing(Facility::getFacility)).collect(Collectors.toCollection(ArrayList::new));
    }//Sorts the arrayList according to its attributes

    //Check if the respective string exists within the respective arrayList
    public boolean checkStf(int x,int i,String stre){
        switch(x){
            case 0: return stf.get(i).getId().equals(stre);
            case 1: return stf.get(i).getName().equals(stre);
            case 2: return stf.get(i).getDesignation().equals(stre);
            case 3: return stf.get(i).getSex().equals(stre);
            case 4: return stf.get(i).getSalary() == Integer.parseInt(stre);
        }
        return false;
    }

    public boolean checkD(int x, int i, String stre){
        switch(x){
            case 0: return d.get(i).getId().equals(stre);
            case 1: return d.get(i).getName().equals(stre);
            case 2: return d.get(i).getSpecialist().equals(stre);
            case 3: return d.get(i).getWorkTime().equals(stre);
            case 4: return d.get(i).getQualification().equals(stre);
            case 5: return d.get(i).getRoom() == Integer.parseInt(stre);
        }
        return false;
    }

    public boolean checkPnt(int x, int i, String stre){
        switch(x){
            case 0: return pnt.get(i).getId().equals(stre);
            case 1: return pnt.get(i).getName().equals(stre);
            case 2: return pnt.get(i).getDisease().equals(stre);
            case 3: return pnt.get(i).getSex().equals(stre);
            case 4: return pnt.get(i).getAdmitStatus().equals(stre);
            case 5: return pnt.get(i).getAge() == Integer.parseInt(stre);
        }
        return false;
    }

    public boolean checkM(int x, int i, String stre){
        switch(x){
            case 0: return m.get(i).getName().equals(stre);
            case 1: return m.get(i).getManufacturer().equals(stre);
            case 2: return m.get(i).getExpiryDate().equals(stre);
            case 3: return m.get(i).getCost() == Integer.parseInt(stre);
            case 4: return m.get(i).getCount() == Integer.parseInt(stre);
        }
        return false;
    }

    public boolean checkLb(int x, int i, String stre){
        switch(x){
            case 0: return lb.get(i).getFacility().equals(stre);
            case 1: return lb.get(i).getCost() == Integer.parseInt(stre);
        }
        return false;
    }

    public boolean checkF(int i, String stre){
        return f.get(i).getFacility().equals(stre);
    }

    //Prints the rules for adding, modifying or searching attributes within the respective functions
    public String rulesStf(int x){
        switch(x){
            case 0: return "Allow User to add a new Staff\n\nRules: \n\n1. There are altogether 5 attributes.\n\n2. ID has to be three digits.\n\n3. You can only enter alphabets and whitespaces for Name, Specialist and Gender.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n4. The value for salary has to be integer value.\n\n5. Please do not leave any of the inputs blank.";
            case 1: return "Allow User to modify existing Staff(s)\n\nRules: \n\n1. There are altogether 5 attributes.\n\n2. ID has to be three digits.\n\n3. You can only enter alphabets and whitespaces for Name, Specialist and Gender.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n4. The value for salary has to be in this format (RMX.00).\n    Note: X can be any number of digits(E.g. RM2.00, RM36.00)\n\n5. Please do not leave any of the inputs blank.";
            case 2: return "Shows every existing Staff(s) in Staff List.";
            case 3: return "Allow User to search for existing Staff(s) according to selected attribute(s)\n\nRules: \n\n1. There are altogether 5 attributes.\n\n2. You can enter any string for ID, Name, Specialist and Gender.\n    Special Character and Digits are allowed.\n\n3. The value for salary has to be integer value.\n\n4. You can select more than one attribute\n\n5. Please do not leave any of the inputs blank.";
            case 4: return "Allow user to delete an existing Staff";
            case 5: return "Returns to Main Menu";
        }
        return "";
    }

    public String rulesD(int x){
        switch(x){
            case 0: return "Allow User to add a new Doctor\n\nRules: \n\n1. There are altogether 6 attributes.\n\n2. ID has to be three digits.\n\n3. You can only enter alphabets and whitespaces for Name and Designation.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n4. The value for Work Time has to be in this format (XX-XX[A,P][M,m]).\n    Note: X can be any number of digits(E.g. RM2.00, RM36.00).\n    AM and PM can be uppercase or lowercase.\n    E.g. Both 5-11Am and 10-12pM are accepted.\n\n5. You can only enter alphabets, whitespaces and commas for qualifications.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n6. The value for room has to be integer value.\n\n7. Please do not leave any of the inputs blank.";
            case 1: return "Allow User to modify existing Doctor(s)\n\nRules: \n\n1. There are altogether 6 attributes.\n\n2. ID has to be three digits.\n\n3. You can only enter alphabets and whitespaces for Name and Designation.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n4. The value for Work Time has to be in this format (XX-XX[A,P][M,m]).\n    Note: X can be any number of digits(E.g. RM2.00, RM36.00).\n    AM and PM can be uppercase or lowercase.\n    E.g. Both 5-11Am and 10-12pM are accepted.\n\n5. You can only enter alphabets, whitespaces and commas for qualifications.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n6. The value for room has to be integer value.\n\n7. Please do not leave any of the inputs blank.";
            case 2: return "Shows every existing Doctor(s) in Doctor List.";
            case 3: return "Allow User to search for existing Doctor(s) according to selected attribute(s)\n\nRules: \n\n1. There are altogether 6 attributes.\n\n2. You can enter any string for ID, Name, Designation, Work Time and\n    Qualification.\n    Special Character and Digits are allowed.\n\n3. The value for Room has to be integer value.\n\n4. You can select more than one attribute\n\n5. Please do not leave any of the inputs blank.";
            case 4: return "Allow user to delete an existing Doctor";
            case 5: return "Returns to Main Menu";
        }
        return "";
    }

    public String rulesPnt(int x){
        switch(x){
            case 0: return "Allow User to add a new Patient\n\nRules: \n\n1. There are altogether 6 attributes.\n\n2. ID has to be three digits.\n\n3. You can only enter alphabets and whitespaces for Name, Disease, Sex and Admit\n    Status.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n4. The value for Age has to be integer value.\n\n5. Please do not leave any of the inputs blank.";
            case 1: return "Allow User to modify existing Patient(s)\n\nRules: \n\n1. There are altogether 6 attributes.\n\n2. ID has to be three digits.\n\n3. You can only enter alphabets and whitespaces for Name, Disease, Sex and Admit\n    Status.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n4. The value for Age has to be integer value.\n\n5. Please do not leave any of the inputs blank.";
            case 2: return "Shows every existing Patient(s) in Patient List.";
            case 3: return "Allow User to search for existing Patient(s) according to selected attribute(s)\n\nRules: \n\n1. There are altogether 6 attributes.\n\n2. You can enter any string for ID, Name, Disease, Sex and Admit Status.\n    Special Character and Digits are allowed.\n\n3. The value for Age has to be integer value.\n\n4. You can select more than one attribute\n\n5. Please do not leave any of the inputs blank.";
            case 4: return "Allow user to delete an existing Patient";
            case 5: return "Returns to Main Menu";
        }
        return "";
    }

    public String rulesM(int x){
        switch(x){
            case 0: return "Allow User to add a new Medical Object\n\nRules: \n\n1. There are altogether 5 attributes.\n\n2. You can only enter alphabets and whitespaces for Name and Manufacturer.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n3. The value for Expiry Date has to be in Date format.\n    Slash and dash are accepted. The year can be 2 digits or 4 digits.\n    Example: 4/9/2020, 18/8/00, 9-4-00, 2-11-1966\n\n4. The value for Cost and Count has to be integer value.\n\n5. Please do not leave any of the inputs blank.";
            case 1: return "Allow User to modify existing Medical Object(s)\n\nRules: \n\n1. There are altogether 5 attributes.\n\n2. You can only enter alphabets and whitespaces for Name and Manufacturer.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n3. The value for Expiry Date has to be in Date format.\n    Slash and dash are accepted. The year can be 2 digits or 4 digits.\n    Example: 4/9/2020, 18/8/00, 9-4-00, 2-11-1966\n\n4. The value for Cost has to be in this format (RMX.00).\n    Note: X can be any number of digits(E.g. RM2.00, RM36.00)\n\n5. The value for Count has to be integer value.\n\n6. Please do not leave any of the inputs blank.";
            case 2: return "Shows every existing Medical Object(s) in Medical List.";
            case 3: return "Allow User to search for existing Medical Object(s) according to selected\nattribute(s)\n\nRules: \n\n1. There are altogether 5 attributes.\n\n2. You can enter any string for ID, Name, Menufacturer.\n    Special Character and Digits are allowed.\n\n3. The value for Cost and Count has to be integer value.\n\n4. You can select more than one attribute\n\n5. Please do not leave any of the inputs blank.";
            case 4: return "Allow user to delete an existing Medical Object";
            case 5: return "Returns to Main Menu";
        }
        return "";
    }

    public String rulesLb(int x){
        switch(x){
            case 0: return "Allow User to add a new Lab\n\nRules: \n\n1. There are altogether 2 attributes.\n\n2. You can only enter alphabets and whitespaces for Lab Name.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n3. The value for Cost has to be integer value.\n\n4. Please do not leave any of the inputs blank.";
            case 1: return "Allow User to modify existing Lab(s)\n\nRules: \n\n1. There are altogether 2 attributes.\n\n2. You can only enter alphabets and whitespaces for Lab Name.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n3. The value for Cost has to be in this format (RMX.00).\n    Note: X can be any number of digits(E.g. RM2.00, RM36.00)\n\n4. Please do not leave any of the inputs blank.";
            case 2: return "Shows every existing Lab(s) in Lab List.";
            case 3: return "Allow User to search for existing Lab(s) according to selected\nattribute(s)\n\nRules: \n\n1. There are altogether 2 attributes.\n\n2. You can enter any string for Lab Name.\n    Special Character and Digits are allowed.\n\n3. The value for Cost has to be integer value.\n\n4. You can select more than one attribute\n\n5. Please do not leave any of the inputs blank.";
            case 4: return "Allow user to delete an existing Lab";
            case 5: return "Returns to Main Menu";
        }
        return "";
    }

    public String rulesF(int x){
        switch(x){
            case 0: return "Allow User to add a new Facility\n\nRules: \n\n1. There is only 1 attributes.\n\n2. You can only enter alphabets and whitespaces for Facility.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n3. Please do not leave any of the inputs blank.";
            case 1: return "Allow User to modify existing Facility(ies)\n\nRules: \n\n1. There is only 1 attributes.\n\n2. You can only enter alphabets and whitespaces for Facility.\n    You cannot enter digits(E.g. 1,2,3...) or special characters(E.g. @,%,$....).\n\n3. Please do not leave any of the inputs blank.";
            case 2: return "Shows every existing Facility(ies) in Facility List.";
            case 3: return "Allow User to search for existing Lab(s) according to selected\nattribute(s)\n\nRules: \n\n1. There is only 1 attributes.\n\n2. You can enter any string for Facility.\n    Special Character and Digits are allowed.\n\n3. You can select more than one attribute\n\n4. Please do not leave any of the inputs blank.";
            case 4: return "Allow user to delete an existing Facility";
            case 5: return "Returns to Main Menu";
        }
        return "";
    }

    public VBox add(int x){
        VBox vbox = new VBox();
        GridPane gp = new GridPane();

        gp.setPadding(new Insets(5,5,5,5));
        gp.setVgap(10);
        gp.setHgap(10);

        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        if(checkLimit(x)){//If the number of Staff,Patient, Doctor..... exceed the limits, return a blank page
            vbox.getChildren().add(new Text("You cannot add any more new "+str[x]+" as it has exceeded the limit."));
            return vbox;
        }

        String str_list = "";
        int availability = 0;

        switch(x){
            case 0: str_list = "Id,>Name,>Specialist,>Gender,>Salary"; availability = 100 - stf.size(); break;
            case 1: str_list = "Id,>Name,>Designation,>Work Time,>Qualification,>Room"; availability = 25 - d.size(); break;
            case 2: str_list = "Id,>Name,>Disease,>Sex,>Admit Status,>Age"; availability = 100 - pnt.size(); break;
            case 3: str_list="Name,>Manufacturer,>Expiry Date,>Cost,>Count"; availability = 100 - m.size(); break;
            case 4: str_list="Lab Name,>Cost"; availability = 20 - lb.size();break;
            case 5: str_list="Facility"; availability = 20 - f.size();break;
        }

        String[] tmp = str_list.split(",>");
        TextField[] tf = new TextField[tmp.length];

        for(int i=0;i<tf.length;i++)
            tf[i] = new TextField();

        Text t1 = new Text("Availability: "+availability);
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));

        for(int i=0;i<tmp.length;i++){
            Text t = new Text(tmp[i]);
            t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            gp.add(t,0,i);
            gp.add(tf[i],1,i);
        }

        Button btn = new Button("Submit");
        gp.add(btn,4,1);

        btn.setOnAction(e -> {
            Text t = new Text();
            t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));

            //Input validation
            for(int i=0;i<tmp.length;i++){
                if(tf[i].getText().isEmpty()){
                    t.setText("Please Do Not Leave Empty Blanks!!");
                    vbox.getChildren().add(t);
                    return;
                }
            }

            switch(x){
                case 0:
                case 2:
                case 4:
                    if(!tf[0].getText().matches("\\d{3}")&&(x==0||x==2)){
                        t.setText("Id should only be 3 digits!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    if(!tf[0].getText().matches("([a-zA-z0-9]+\\s*)+")&&x==4){
                        t.setText(tmp[0]+" cannot have random characters!!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    for(int i=1;i<tmp.length - 1;i++){
                        if(!tf[i].getText().matches("([a-zA-z]+\\s*)+")){
                            t.setText(tmp[i]+" cannot have random characters!!");
                            vbox.getChildren().add(t);
                            return;
                        }
                    }
                    if(!tf[tmp.length-1].getText().matches("[0-9]+")){
                        t.setText("Please Change "+tmp[tmp.length-1]+" To Integer Value!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    break;
                case 1:
                    if(!tf[0].getText().matches("\\d{3}")&&(x==0||x==2)){
                        t.setText("Id should only be 3 digits!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    for(int i=1;i<3;i++){
                        if(!tf[i].getText().matches("([a-zA-z]+\\s*)+")){
                            t.setText(tmp[i]+" cannot have random characters!!");
                            vbox.getChildren().add(t);
                            return;
                        }
                    }
                    if(!tf[3].getText().matches("\\d{1,2}-\\d{1,2}[aAPp][Mm]")){
                        t.setText(tmp[3]+" has to be a valid format (E.g. 5-11AM)!!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    if(!tf[4].getText().matches("([a-zA-z]+\\s*[,]*)+")){
                        t.setText(tmp[4]+" cannot have random characters (Except for ,)!!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    if(!tf[tmp.length-1].getText().matches("[0-9]+")){
                        t.setText("Please Change "+tmp[tmp.length-1]+" To Integer Value!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    break;
                case 3:
                    for(int i=0;i<2;i++){
                        if(!tf[i].getText().matches("([a-zA-z]+\\s*)+")){
                            t.setText(tmp[i]+" cannot have random characters!!");
                            vbox.getChildren().add(t);
                            return;
                        }
                    }
                    if(!tf[2].getText().matches("\\d{1,2}[/-]\\d{1,2}[/-]\\d{2}|\\d{1,2}[/-]\\d{1,2}[/-]\\d{4}")){
                        t.setText(tmp[2]+" has to be a valid date format (dd/mm/yyyy)!!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    for(int i = 3;i<tmp.length;i++){
                        if(!tf[i].getText().matches("[0-9]+")){
                            t.setText("Please Change "+tmp[i]+" To Integer Value!");
                            vbox.getChildren().add(t);
                            return;
                        }
                    }
                    break;
                case 5:
                    if(!tf[0].getText().matches("([a-zA-z0-9]+\\s*)+")){
                        t.setText(tmp[0]+" cannot have random characters!!");
                        vbox.getChildren().add(t);
                        return;
                    }
                    break;
            }

            Object obj = new Object();
            switch(x){
                case 0: obj = new Staff(tf[0].getText(),tf[1].getText(),tf[2].getText(),tf[3].getText(),Integer.parseInt(tf[4].getText()));break;
                case 1: obj = new Doctor(tf[0].getText(),tf[1].getText(),tf[2].getText(),tf[3].getText(),tf[4].getText(),Integer.parseInt(tf[5].getText()));break;
                case 2: obj = new Patient(tf[0].getText(),tf[1].getText(),tf[2].getText(),tf[3].getText(),tf[4].getText(),Integer.parseInt(tf[5].getText()));break;
                case 3: obj = new Medical(tf[0].getText(),tf[1].getText(),tf[2].getText(),Integer.parseInt(tf[3].getText()),Integer.parseInt(tf[4].getText()));break;
                case 4: obj = new Lab(tf[0].getText(),Integer.parseInt(tf[1].getText()));break;
                case 5: obj = new Facility(tf[0].getText());break;
            }

            if(checkIfExist(x,obj)){
                t.setText("Error! A duplicate "+str[x]+" already exist in database");
                vbox.getChildren().add(t);
                return;
            }

            addToList(x,obj);

            sort();

            t.setText("Successfully Added a new "+str[x]+"!");
            vbox.getChildren().clear();
            vbox.getChildren().add(t);
        });

        Button btn2 = new Button("Clear");
        gp.add(btn2,4,2);

        btn2.setOnAction(e -> {
            for (TextField textField : tf) textField.setText("");
        });

        vbox.getChildren().addAll(t1,gp);
        return vbox;
    }

    public VBox modify(int x){
        VBox vbox = new VBox();
        GridPane gp = new GridPane();

        vbox.setPadding(new Insets(10,10,10,10));
        gp.setPadding(new Insets(5,5,5,5));
        gp.setVgap(10);
        gp.setHgap(10);

        if(isListEmpty(x)){//If there are no Staff,Doctor,Patients...., return an empty page
            vbox.getChildren().add(new Text(str[x]+" is currently empty...\nNothing to "+func[1]+"...\nTry to add something..."));
            return vbox;
        }

        String str_list = "";

        switch(x){
            case 0: str_list = "Id,>Name,>Specialist,>Gender,>Salary";break;
            case 1: str_list = "Id,>Name,>Designation,>Work Time,>Qualification,>Room";break;
            case 2: str_list = "Id,>Name,>Disease,>Sex,>Admit Status,>Age";break;
            case 3: str_list = "Name,>Manufacturer,>Expiry Date,>Cost,>Count";break;
            case 4: str_list = "Lab Name,>Cost";break;
            case 5: str_list = "Facility";break;
        }

        String[] tmp = str_list.split(",>");

        for(int i=0;i<tmp.length;i++){
            Text t = new Text(tmp[i]);
            t.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
            gp.add(t,i,0);
        }

        TextField[][] tf = new TextField[listSize(x)][tmp.length];
        for(int i=0;i<listSize(x);i++)
            for(int j=0;j<tmp.length;j++)
                tf[i][j] = new TextField();

        for(int k=0;k<listSize(x);k++){
            switch(x){
                case 0:tmp = stf.get(k).toString().split(",>");break;
                case 1:tmp = d.get(k).toString().split(",>");break;
                case 2:tmp = pnt.get(k).toString().split(",>");break;
                case 3:tmp = m.get(k).toString().split(",>");break;
                case 4:tmp = lb.get(k).toString().split(",>");break;
                case 5:tmp = f.get(k).toString().split(",>");break;
            }
            for(int i=0;i<tmp.length;i++){
                tf[k][i].setText(tmp[i]);
                tf[k][i].setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));
                gp.add(tf[k][i],i,(k+1));
            }
        }

        Button btn = new Button("Modify");

        String finalStr_list = str_list;
        btn.setOnAction(e -> {
            String[] txt = finalStr_list.split(",>");

            Text t = new Text();
            t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));

            //Input Validation
            for(int i=0;i<tf.length;i++){
                for(int j=0;j<tf[i].length;j++){
                    if(tf[i][j].getText().isEmpty()){
                        t.setText("Please Do Not Leave Empty Blanks!!");
                        vbox.getChildren().add(t);
                        return;
                    }
                }
                switch(x){
                    case 0:
                    case 2:
                    case 4:
                        if(!tf[i][0].getText().matches("\\d{3}")&&(x==0||x==2)){
                            t.setText("Id "+" of Row "+(i+1)+"should only be 3 digits!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        if(!tf[i][0].getText().matches("([a-zA-z0-9]+\\s*)+")&&x==4){
                            t.setText(txt[0]+" of Row "+(i+1)+" cannot have random characters!!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        for(int k=1;k<txt.length - 1;k++){
                            if(!tf[i][k].getText().matches("([a-zA-z]+\\s*)+")){
                                t.setText(txt[k]+" of Row "+(i+1)+" cannot have random characters!!");
                                vbox.getChildren().add(t);
                                return;
                            }
                        }
                        if(!tf[i][txt.length-1].getText().matches("RM[0-9]+.00")&&(x==0||x==4)){
                            t.setText("Please Change "+txt[txt.length-1]+" of Row "+(i+1)+" To RMXXX.00 format!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        if(!tf[i][txt.length-1].getText().matches("[0-9]+")&&x==2){
                            t.setText("Please Change "+txt[txt.length-1]+" of Row "+(i+1)+" To Integer Value!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        break;
                    case 1:
                        if(!tf[i][0].getText().matches("\\d{3}")){
                            t.setText("Id should only be 3 digits!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        for(int k=1;k<3;k++){
                            if(!tf[i][k].getText().matches("([a-zA-z]+\\s*)+")){
                                t.setText(txt[k]+" of Row "+(i+1)+" cannot have random characters!!");
                                vbox.getChildren().add(t);
                                return;
                            }
                        }
                        if(!tf[i][3].getText().matches("\\d{1,2}-\\d{1,2}[aAPp][Mm]")){
                            t.setText(txt[3]+" of Row "+(i+1)+" has to be a valid format (E.g. 5-11AM)!!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        if(!tf[i][4].getText().matches("([a-zA-z]+\\s*[,]*)+")){
                            t.setText(txt[4]+" of Row "+(i+1)+" cannot have random characters (Except for ,)!!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        if(!tf[i][txt.length-1].getText().matches("[0-9]+")){
                            t.setText("Please Change "+txt[txt.length-1]+" of Row "+(i+1)+" To Integer Value!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        break;
                    case 3:
                        for(int k=0;k<2;k++){
                            if(!tf[i][k].getText().matches("([a-zA-z]+\\s*)+")){
                                t.setText(txt[k]+" of Row "+(i+1)+" cannot have random characters!!");
                                vbox.getChildren().add(t);
                                return;
                            }
                        }
                        if(!tf[i][2].getText().matches("\\d{1,2}[/-]\\d{1,2}[/-]\\d{2}|\\d{1,2}[/-]\\d{1,2}[/-]\\d{4}")){
                            t.setText(txt[2]+" of Row "+(i+1)+" has to be a valid date format (dd/mm/yyyy)!!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        if(!tf[i][3].getText().matches("RM[0-9]+.00")){
                            t.setText("Please Change "+txt[3]+" of Row "+(i+1)+" To RMXXX.00 format!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        if(!tf[i][txt.length-1].getText().matches("[0-9]+")){
                            t.setText("Please Change "+txt[txt.length-1]+" of Row "+(i+1)+" To Integer Value!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        break;
                    case 5:
                        if(!tf[i][0].getText().matches("([a-zA-z0-9]+\\s*)+")){
                            t.setText(txt[0]+" of Row "+(i+1)+" cannot have random characters!!");
                            vbox.getChildren().add(t);
                            return;
                        }
                        break;
                }
            }

            ArrayList<Staff> tmpA = new ArrayList<>();
            ArrayList<Doctor> tmpB = new ArrayList<>();
            ArrayList<Patient> tmpC = new ArrayList<>();
            ArrayList<Medical> tmpD = new ArrayList<>();
            ArrayList<Lab> tmpE = new ArrayList<>();
            ArrayList<Facility> tmpF = new ArrayList<>();
            int num;

            //Prevent Duplicate
            for(int i = 0; i< tf.length; i++)
                switch(x){
                    case 0:
                        num = Integer.parseInt(tf[i][4].getText().substring(2,tf[i][4].getText().length()-3));
                        if(tmpA.contains(new Staff(tf[i][0].getText(),tf[i][1].getText(),tf[i][2].getText(),tf[i][3].getText(),num))) {
                            vbox.getChildren().add(new Text("Error! Row " + i + " is a duplicate! Please Change the values of Row " + i));
                            return;
                        }
                        tmpA.add(new Staff(tf[i][0].getText(),tf[i][1].getText(),tf[i][2].getText(),tf[i][3].getText(),num));
                        break;
                    case 1:
                        if(tmpB.contains(new Doctor(tf[i][0].getText(),tf[i][1].getText(),tf[i][2].getText(),tf[i][3].getText(),tf[i][4].getText(),Integer.parseInt(tf[i][5].getText())))){
                            vbox.getChildren().add(new Text("Error! Row " + i + " is a duplicate! Please Change the values of Row " + i));
                            return;
                        }
                        tmpB.add(new Doctor(tf[i][0].getText(),tf[i][1].getText(),tf[i][2].getText(),tf[i][3].getText(),tf[i][4].getText(),Integer.parseInt(tf[i][5].getText())));
                        break;
                    case 2:
                        if(tmpC.contains(new Patient(tf[i][0].getText(),tf[i][1].getText(),tf[i][2].getText(),tf[i][3].getText(),tf[i][4].getText(),Integer.parseInt(tf[i][5].getText())))){
                            vbox.getChildren().add(new Text("Error! Row " + i + " is a duplicate! Please Change the values of Row " + i));
                            return;
                        }
                        tmpC.add(new Patient(tf[i][0].getText(),tf[i][1].getText(),tf[i][2].getText(),tf[i][3].getText(),tf[i][4].getText(),Integer.parseInt(tf[i][5].getText())));
                        break;
                    case 3:
                        num = Integer.parseInt(tf[i][3].getText().substring(2,tf[i][3].getText().length()-3));
                        if(tmpD.contains(new Medical(tf[i][0].getText(),tf[i][1].getText(),tf[i][2].getText(),num,Integer.parseInt(tf[i][4].getText())))){
                            vbox.getChildren().add(new Text("Error! Row " + i + " is a duplicate! Please Change the values of Row " + i));
                            return;
                        }
                        tmpD.add(new Medical(tf[i][0].getText(),tf[i][1].getText(),tf[i][2].getText(),num,Integer.parseInt(tf[i][4].getText())));
                        break;
                    case 4:
                        num = Integer.parseInt(tf[i][1].getText().substring(2,tf[i][1].getText().length()-3));
                        if(tmpE.contains(new Lab(tf[i][0].getText(),num))){
                            vbox.getChildren().add(new Text("Error! Row " + i + " is a duplicate! Please Change the values of Row " + i));
                            return;
                        }
                        tmpE.add(new Lab(tf[i][0].getText(),num));
                        break;
                    case 5:
                        if(tmpF.contains(new Facility(tf[i][0].getText()))){
                            vbox.getChildren().add(new Text("Error! Row " + i + " is a duplicate! Please Change the values of Row " + i));
                            return;
                        }
                        tmpF.add(new Facility(tf[i][0].getText()));
                        break;
                }

            switch(x){
                case 0: stf = tmpA;break;
                case 1: d = tmpB;break;
                case 2: pnt = tmpC;break;
                case 3: m = tmpD;break;
                case 4: lb = tmpE;break;
                case 5: f = tmpF;break;
            }

            vbox.getChildren().clear();
            vbox.getChildren().add(new Text("Modified Successfully!"));
            sort();
        });

        gp.add(btn,7,1);
        vbox.getChildren().add(gp);
        return vbox;
    }

    public VBox show(int x){
        VBox vbox = new VBox();
        GridPane gp = new GridPane();

        gp.setPadding(new Insets(5,5,5,5));
        gp.setHgap(5);
        gp.setVgap(5);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        if(isListEmpty(x)){//If there are no Staff,Doctor,Patients...., return an empty page
            vbox.getChildren().add(new Text(str[x]+" is currently empty...\nNothing to "+func[2]+"...\nTry to add something..."));
            return vbox;
        }

        String str_list = "";

        switch(x){
            case 0: str_list = "Id,>Name,>Specialist,>Gender,>Salary";break;
            case 1: str_list = "Id,>Name,>Designation,>Work Time,>Qualification,>Room";break;
            case 2: str_list = "Id,>Name,>Disease,>Sex,>Admit Status,>Age";break;
            case 3: str_list="Name,>Manufacturer,>Expiry Date,>Cost,>Count";break;
            case 4: str_list="Lab Name,>Cost";break;
            case 5: str_list="Facility";break;
        }

        String[] tmp = str_list.split(",>");

        for(int i=0;i<tmp.length;i++){
            Text t = new Text(tmp[i]);
            t.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
            gp.add(t,i,0);
        }

        for(int k=0;k<listSize(x);k++){
            switch(x){
                case 0:tmp = stf.get(k).toString().split(",>");break;
                case 1:tmp = d.get(k).toString().split(",>");break;
                case 2:tmp = pnt.get(k).toString().split(",>");break;
                case 3:tmp = m.get(k).toString().split(",>");break;
                case 4:tmp = lb.get(k).toString().split(",>");break;
                case 5:tmp = f.get(k).toString().split(",>");break;
            }
            for(int i=0;i<tmp.length;i++){
                Text t = new Text(tmp[i]);
                t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));
                gp.add(t,i,(k+1));
            }
        }

        Text t = new Text("Table Size: "+listSize(x)+" rows x "+tmp.length+" columns");
        t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 15));
        vbox.getChildren().addAll(gp,t);
        return vbox;
    }

    public VBox search(int x){
        VBox vbox = new VBox();
        GridPane gp = new GridPane();

        gp.setPadding(new Insets(5,5,5,5));
        gp.setHgap(5);
        gp.setVgap(5);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        if(isListEmpty(x)){//If there are no Staff,Doctor,Patients...., return an empty page
            vbox.getChildren().add(new Text(str[x]+" is currently empty...\nNothing to "+func[3]+"...\nTry to add something..."));
            return vbox;
        }

        String str_list = "";

        switch(x){
            case 0: str_list = "Id,>Name,>Specialist,>Gender,>Salary"; break;
            case 1: str_list = "Id,>Name,>Designation,>Work Time,>Qualification,>Room"; break;
            case 2: str_list = "Id,>Name,>Disease,>Sex,>Admit Status,>Age"; break;
            case 3: str_list="Name,>Manufacturer,>Expiry Date,>Cost,>Count"; break;
            case 4: str_list="Lab Name,>Cost"; break;
            case 5: str_list="Facility"; break;
        }

        String[] tmp = str_list.split(",>");

        CheckBox[] cBox = new CheckBox[tmp.length];
        for(int i=0;i<cBox.length;i++) {
            cBox[i] = new CheckBox();
            gp.add(cBox[i],0,(i+1));
        }

        Text t1 = new Text("Attributes");
        t1.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
        gp.add(t1,1,0);

        for(int i=0;i<tmp.length;i++){
            Text t = new Text(tmp[i]);
            t.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
            gp.add(t,1,(i+1));
        }

        Text t2 = new Text("You can select more than one attribute.");
        t2.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));

        Button btn = new Button("Submit");
        btn.setOnAction(e -> {
            vbox.getChildren().clear();
            vbox.getChildren().add(search2(cBox,tmp,x));
        });

        vbox.getChildren().addAll(gp,t2,btn);
        return vbox;
    }

    public VBox search2(CheckBox[] cBox, String[] tmp,int x){
        VBox vbox = new VBox();
        GridPane gp = new GridPane(), gp2 = new GridPane();

        gp.setPadding(new Insets(5,5,5,5));
        gp.setHgap(10);
        gp.setVgap(10);

        gp2.setPadding(new Insets(5,5,5,5));
        gp2.setHgap(10);
        gp2.setVgap(10);

        for(int i=0;i<tmp.length;i++){
            Text t = new Text(tmp[i]);
            t.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
            gp2.add(t,i,0);
        }

        ArrayList<Integer> counter = new ArrayList<>();

        for(int i=0;i<cBox.length;i++)
            if(cBox[i].isSelected())
                counter.add(i);

        if(counter.isEmpty()) {
            vbox.getChildren().add(new Text("You have not chosen anything. \nPlease try again."));
            return vbox;
        }

        TextField[] tf = new TextField[cBox.length];
        for(int i=0;i<cBox.length;i++)
            tf[i] = new TextField();

        for(int i = 0;i<counter.size();i++){
            Text t = new Text(tmp[counter.get(i)]);
            gp.add(t,0,i);
            gp.add(tf[counter.get(i)],1,i);
        }

        Button btn = new Button("Submit");
        gp.add(btn,1,counter.size()+2);

        btn.setOnAction(e -> {
            for (Integer integer : counter) {
                if (tf[integer].getText().isEmpty()) {
                    vbox.getChildren().add(new Text("Please do not leave the input as blanks!"));
                    return;
                }
            }

            //Input Validation, if x =0, it is Staff, it's 4th textfield is salary, and does input validation
            //It only does validation for integers
            boolean flag = false;
            for (Integer value : counter) {//Input Validation, if x =0, it is Staff, it's 4th textfield is salary, and does input validation
                switch (x) {
                    case 0: flag = value == 4;break;
                    case 1:
                    case 2: flag = value == 5;break;
                    case 3: flag = value == 3 || value == 4;break;
                    case 4: flag = value == 1;break;
                    case 5: break;
                }
                if (flag && !tf[value].getText().matches("\\d+")) {
                    vbox.getChildren().add(new Text("Please Change " + tmp[value] + " To Integer Value!"));
                    return;
                }
            }

            int existing = 0;

            //List Size represents number of attributes it has to go through
            //If the flag does not fall when checking the number of attributes, then it must be true
            for(int i=0;i<listSize(x);i++){
                flag = true;
                for (Integer integer : counter) {
                    switch (x) {
                        case 0: if (!checkStf(integer, i, tf[integer].getText())) { flag = false; }break;
                        case 1: if (!checkD(integer, i, tf[integer].getText())) { flag = false; }break;
                        case 2: if (!checkPnt(integer, i, tf[integer].getText())) { flag = false; }break;
                        case 3: if (!checkM(integer, i, tf[integer].getText())) { flag = false; }break;
                        case 4: if (!checkLb(integer, i, tf[integer].getText())) { flag = false; }break;
                        case 5: if (!checkF(i, tf[integer].getText())) { flag = false; }break;
                    }
                }
                if(flag){
                    existing++;
                    String[] tmper = new String[tmp.length];

                    switch(x){
                        case 0: tmper = stf.get(i).toString().split(",>");break;
                        case 1: tmper = d.get(i).toString().split(",>");break;
                        case 2: tmper = pnt.get(i).toString().split(",>");break;
                        case 3: tmper = m.get(i).toString().split(",>");break;
                        case 4: tmper = lb.get(i).toString().split(",>");break;
                        case 5: tmper = f.get(i).toString().split(",>");break;
                    }

                    for(int k=0;k<tmper.length;k++){
                        Text t = new Text(tmper[k]);
                        t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));
                        gp2.add(t,k,existing);
                    }
                }
            }

            vbox.getChildren().clear();

            if(existing == 0){
                vbox.getChildren().add(new Text("No search results found.... \nTry again?"));
            }else{
                Text t = new Text("Table Size: "+existing+" rows x "+tmp.length+" columns");
                t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 15));
                vbox.setSpacing(10);
                vbox.getChildren().addAll(gp2,t);
            }
        });

        vbox.getChildren().add(gp);
        return vbox;
    }

    public VBox delete(int x){
        VBox vbox = new VBox();
        GridPane gp = new GridPane();

        vbox.setPadding(new Insets(10,10,10,10));
        gp.setPadding(new Insets(5,5,5,5));
        gp.setHgap(5);
        gp.setVgap(5);

        if(isListEmpty(x)){//If there are no Staff,Doctor,Patients...., return an empty page
            vbox.getChildren().add(new Text(str[x]+" is currently empty...\nNothing to "+func[4]+"...\nTry to add something..."));
            return vbox;
        }

        String str_list = "";

        switch(x){
            case 0: str_list = "Id,>Name,>Specialist,>Gender,>Salary";break;
            case 1: str_list = "Id,>Name,>Designation,>Work Time,>Qualification,>Room";break;
            case 2: str_list = "Id,>Name,>Disease,>Sex,>Admit Status,>Age";break;
            case 3: str_list="Name,>Manufacturer,>Expiry Date,>Cost,>Count";break;
            case 4: str_list="Lab Name,>Cost";break;
            case 5: str_list="Facility";break;
        }

        String[] tmp = str_list.split(",>");

        for(int i=0;i<tmp.length;i++){
            Text t = new Text(tmp[i]);
            t.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
            gp.add(t,(i+1),0);
        }

        for(int k=0;k<listSize(x);k++){
            switch(x){
                case 0:tmp = stf.get(k).toString().split(",>");break;
                case 1:tmp = d.get(k).toString().split(",>");break;
                case 2:tmp = pnt.get(k).toString().split(",>");break;
                case 3:tmp = m.get(k).toString().split(",>");break;
                case 4:tmp = lb.get(k).toString().split(",>");break;
                case 5:tmp = f.get(k).toString().split(",>");break;
            }
            for(int i=0;i<tmp.length;i++){
                Text t = new Text(tmp[i]);
                t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));
                gp.add(t,(i+1),(k+1));
            }
        }

        RadioButton rb[] = new RadioButton[listSize(x)];
        ToggleGroup group = new ToggleGroup();//Only allow one radio button to be selected
        for(int i=0;i<rb.length;i++){
            rb[i] = new RadioButton();
            rb[i].setToggleGroup(group);
            gp.add(rb[i],0,(i+1));
        }

        Button btn = new Button("Delete");
        btn.setOnAction(e -> {
            Text t = new Text();
            t.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 15));
            boolean nexisting = true;
            for(int i=0;i<rb.length;i++){
                if(rb[i].isSelected()){
                    switch(x){
                        case 0: stf.remove(i);break;
                        case 1: d.remove(i);break;
                        case 2: pnt.remove(i);break;
                        case 3: m.remove(i);break;
                        case 4: lb.remove(i);break;
                        case 5: f.remove(i);break;
                    }
                    t.setText("Deleted Successfully!");
                    nexisting = false;
                }
            }

            if(nexisting){
                vbox.getChildren().add(new Text("You have not selected anything..."));
                return;
            }

            vbox.getChildren().clear();
            vbox.getChildren().add(t);
        });

        gp.add(btn,8,1);
        vbox.getChildren().addAll(gp);
        return vbox;
    }

    public StackPane template(VBox vx){
        StackPane p = new StackPane(), mP = new StackPane();
        p.getChildren().add(vx);
        p.setStyle("-fx-border-color: black");
        mP.setPadding(new Insets(10,10,10,10));
        mP.getChildren().add(p);
        return mP;
    }

    public BorderPane timeAndDate(){
        BorderPane topBar = new BorderPane();
        StackPane dt = new StackPane(), tm = new StackPane(), bk = new StackPane();
        Text date = new Text("Date: "+printDate());
        Text time = new Text("Time: "+printTime());

        date.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
        date.setFill(Color.WHITE);

        time.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20));
        time.setFill(Color.WHITE);

        bk.setOnMousePressed(e -> {
            date.setText("Date: "+printDate());
            time.setText("Time: "+printTime());
        });

        dt.getChildren().add(date);
        tm.getChildren().add(time);

        topBar.setLeft(dt);
        topBar.setCenter(bk);
        topBar.setRight(tm);
        topBar.setStyle("-fx-background-color: black");
        return topBar;
    }

    public Scene page(Stage stage,int x){
        BorderPane bPane = new BorderPane();
        VBox vbox = new VBox();
        StackPane header = new StackPane();

        Text h1 = new Text(str[x]);
        h1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 50));
        h1.setFill(Color.WHITE);
        header.setStyle("-fx-background-color: "+rgbCode[x]);
        header.getChildren().add(h1);
        vbox.getChildren().addAll(timeAndDate(),header);

        StackPane centerPane = new StackPane();
        centerPane.setStyle("-fx-border-color: black");
        String default_str = "Welcome to the "+str[x]+" page!";
        Text txt = new Text(default_str);
        txt.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
        centerPane.getChildren().add(txt);
        centerPane.setAlignment(txt, Pos.CENTER);
        centerPane.setPadding(new Insets(10,10,10,10));

        StackPane[] sPane = new StackPane[func.length];
        VBox sideBar = new VBox();
        for(int i=0;i<func.length;i++){
            Text temp = new Text(func[i]);
            temp.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
            temp.setFill(Color.WHITE);
            sPane[i] = new StackPane();
            sPane[i].setMinSize(200,50);
            sPane[i].setStyle("-fx-background-color: "+rgbCode[x]);
            sPane[i].getChildren().add(temp);
            int finalI = i;
            sPane[i].setOnMouseEntered(e -> {
                sPane[finalI].setStyle("-fx-background-color: "+rgbHover[x]);
                switch(x){
                    case 0: txt.setText(func[finalI]+"\n\n"+rulesStf(finalI));break;
                    case 1: txt.setText(func[finalI]+"\n\n"+rulesD(finalI));break;
                    case 2: txt.setText(func[finalI]+"\n\n"+rulesPnt(finalI));break;
                    case 3: txt.setText(func[finalI]+"\n\n"+rulesM(finalI));break;
                    case 4: txt.setText(func[finalI]+"\n\n"+rulesLb(finalI));break;
                    case 5: txt.setText(func[finalI]+"\n\n"+rulesF(finalI));break;
                }
                centerPane.setAlignment(txt, Pos.TOP_LEFT);
            });
            sPane[i].setOnMouseExited(e -> {
                sPane[finalI].setStyle("-fx-background-color: "+rgbCode[x]);
                txt.setText(default_str);
                centerPane.setAlignment(txt, Pos.CENTER);
            });
            sideBar.getChildren().add(sPane[i]);
        }

        sideBar.setPadding(new Insets(10,10,10,10));
        sideBar.setSpacing(10);

        StackPane mainCenter = new StackPane();
        mainCenter.getChildren().add(centerPane);
        mainCenter.setPadding(new Insets(10,10,10,10));

        bPane.setTop(vbox);
        bPane.setLeft(sideBar);
        bPane.setCenter(mainCenter);

        sPane[0].setOnMouseClicked(e -> bPane.setCenter(template(add(x))));

        sPane[1].setOnMouseClicked(e -> {
            stage.setMaximized(true);
            bPane.setCenter(template(modify(x)));
        });

        sPane[2].setOnMouseClicked(e -> bPane.setCenter(template(show(x))));

        sPane[3].setOnMouseClicked(e -> bPane.setCenter(template(search(x))));

        sPane[4].setOnMouseClicked(e -> bPane.setCenter(template(delete(x))));

        sPane[func.length-1].setOnMouseClicked(e -> {
            stage.setMaximized(false);
            stage.setScene(homeScene);
            bPane.setCenter(mainCenter);
        });

        return new Scene(bPane,800,540);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //top Bar
        StackPane header = new StackPane();
        Text h1 = new Text("Hospital Management");
        h1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 50));
        h1.setFill(Color.WHITE);
        header.setStyle("-fx-background-color: #00fa9a");
        header.getChildren().add(h1);

        //HomePage
        GridPane menu = new GridPane();
        StackPane[] s = new StackPane[6];

        for(int i=0;i<s.length;i++)//Initializes the Stack Panes
            s[i] = new StackPane();

        Text[] t = new Text[6];
        for(int i=0;i<t.length;i++){
            t[i] = new Text(str[i]);
            t[i].setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 25));
            t[i].setFill(Color.WHITE);
            s[i].setMinSize(200,150);
            s[i].setStyle("-fx-background-color: "+rgbCode[i]);
            s[i].getChildren().add(t[i]);
            int finalI = i;
            s[i].setOnMouseEntered(e -> s[finalI].setStyle("-fx-background-color: "+rgbHover[finalI]));
            s[i].setOnMouseExited(e -> s[finalI].setStyle("-fx-background-color: "+rgbCode[finalI]));
            s[i].setOnMouseClicked(e -> stage.setScene(scene[finalI]));//Each Stack Pane when click will bring the user into the respective pages
        }
        menu.setPadding(new Insets(10, 10, 10, 10));
        menu.setVgap(10);
        menu.setHgap(10);
        for(int i=0;i<2;i++)
            for(int j=0;j<3;j++)
                menu.add(s[j+i*3],j,i);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(timeAndDate(),header,menu);

        homeScene = new Scene(vbox,650,420);

        //Each Scene represents a page, Staff, Doctor, Patient, Medical, Lab and Facility Page
        //E.g. scene[0] = Staff Page
        for(int i=0;i<str.length;i++){
            scene[i]=page(stage,i);
        }

        stage.setScene(homeScene);
        stage.show();
        stage.setTitle("Hospital Management System");
    }

    public static void main(String[] args){
        launch(args);
    }

    public static String printTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }

    public static String printDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return now.format(formatter);
    }
}