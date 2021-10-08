/*   Created by IntelliJ IDEA.
 *   Author: Kshitij Varshney (kshitijvarshne1)
 *   Date: 08-Oct-21
 *   Time: 12:47 AM
 *   File: Dog.java
 */

package october.oct08_21;

public class Dog extends Animal {
    private int AKCnumber;
    private boolean vaccinated;

    public Dog(String name, String breed, int age, int AKCnumber, boolean vaccinated) {
        super(name, breed, age);
        this.AKCnumber = AKCnumber;
        this.vaccinated = vaccinated;
    }

    public int getAKCnumber() {
        return AKCnumber;
    }

    public void setAKCnumber(int AKCnumber) {
        this.AKCnumber = AKCnumber;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return super.toString() + " , AKC Number : " + this.AKCnumber + " , Vaccinates : " + this.vaccinated;

    }
}

