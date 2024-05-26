import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    @Test
    void testMakeChildWithoutMarriage() {
        Creature human = new Human("burak", 20, "hasselt");
        Creature child = new Creature("child", 19, "hasselt");
        assertThrows(
                IllegalAccessException.class,
                () -> human.makeChild(child),
                "Expected makeChild() to throw, but it didn't"
        );
    }
    @Test
    void testMakeChildWithMarriage() {
        Creature human = new Human("Burak", 19, "Hasselt");
        Creature alien = new Alien("Bralien", 91, "Mars");
        human.marry(alien);
        Creature child = new Creature("child", 19, "hasselt");
        assertThrows(
                IllegalAccessException.class,
                () -> human.makeChild(child),
                "Expected doThing() to throw, but it didn't"
        );
    }

    @Test
    void testMarry() {
    }
}