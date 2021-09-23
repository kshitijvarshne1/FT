/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 22-Sep-21
 *   Time: 5:47 PM
 *   File: Animal.java
 */

package september.sep22_21;

// class Animal
public class Animal {
    // instance variable
    private String name;
    private String type;
    private int age;
    private boolean training;

    // constructor -> overload constructor with 4 variable
    public Animal(String name, String type, int age, boolean training) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.training = training;
    }

    // constructor -> overload constructor with 2 variable
    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        this.age = 0;
        this.training = false;
    }

    // default constructor
    // by default for type is dog
    public Animal() {
        this.name = "Max";
        this.type = "dog";
        this.age = 0;
        this.training = false;
    }

    // getter and setter method to get and initialise the values
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isTraining() {
        return training;
    }

    public void setTraining(boolean training) {
        this.training = training;
    }

    // toString method to print the details of the Object of animal
    @Override
    public String toString() {
        String trained = this.isTraining() ? "trained" : "not trained";
        return "the pets name is " + this.getName() + " the pet's age is " + this.getAge() + " the pet is " + trained ;
    }
}

