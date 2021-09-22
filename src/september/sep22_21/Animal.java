/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 22-Sep-21
 *   Time: 5:47 PM
 *   File: Animal.java
 */

package september.sep22_21;

public class Animal {
    private String name;
    private String type;
    private int age;
    private boolean training;

    public Animal(String name, String type, int age, boolean training) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.training = training;
    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

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

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", training=" + training +
                '}' + "\n";
    }
}

