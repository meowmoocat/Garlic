package garlic;

/* created by
 * Anna Davison	16382333
 * James Kearns	15467622
 * Orla Keating	15205679
 */

public class Weapon {

    private final String name;
    private final Coordinates position;

    //creates instance of weapon with name and coordinates
    Weapon(String name, Coordinates position) {
        this.name = name;
        this.position = position;
    }

    //moves weapon
    public void moveBy(Coordinates move) {
        position.add(move);
    }

    public String getName() {
        return name;
    }

    public Coordinates getPosition() {
        return position;
    }

    //returns true if string is equal to weapon name
    public boolean hasName(String name) {
        return this.name.toLowerCase().equals(name.toLowerCase().trim());
    }
}
