package application;

public abstract class Person {
    private String id,name;

    public Person(String id,String name){
        this.id = id;
        this.name = name;
    }

    public Person(){
        this("","");
    }

    public abstract void newInfo();
    public abstract void showInfo();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj){
        if(obj == this)
            return true;

        if(!(obj instanceof Person))
            return false;

        Person comparedObj = (Person) obj;

        if(comparedObj.id.equals(this.id) || comparedObj.name.equals(this.name))
            return true;

        return false;
    }

}
