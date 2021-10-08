/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 08-Oct-21
 *   Time: 12:45 AM
 *   File: Animal.java
 */

package october.oct08_21;

public class Animal {
    private String name;
    private String breed;
    private int age;

    public Animal(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name : " + this.name + " , Breed : " + this.breed + " , Age : " + this.age;
    }
}

