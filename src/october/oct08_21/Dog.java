/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 08-Oct-21
 *   Time: 12:47 AM
 *   File: Dog.java
 */

package october.oct08_21;

public class Dog extends Animal {
    private final int AKCnumber;
    private final boolean vaccinated;

    public Dog(String name, String breed, int age, int AKCnumber, boolean vaccinated) {
        super(name, breed, age);
        this.AKCnumber = AKCnumber;
        this.vaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return super.toString() + " Dog{" +
                "AKCnumber=" + AKCnumber +
                ", vaccinated=" + vaccinated +
                '}';
    }
}

