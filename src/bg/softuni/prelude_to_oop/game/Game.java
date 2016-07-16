package bg.softuni.prelude_to_oop.game;

import bg.softuni.prelude_to_oop.game.characters.GameCharacter;
import bg.softuni.prelude_to_oop.game.characters.Mage;
import bg.softuni.prelude_to_oop.game.characters.Warrior;
import bg.softuni.prelude_to_oop.game.exception.OutOfEnergyException;

public class Game {
    public static void main(String[] args) {
        GameCharacter goshoTheWarrior = new Warrior("Gosho");
        GameCharacter peshoTheMage = new Mage("Pesho");

        int round = 0;
        boolean mageFirst = false;

        while (true) {
            System.out.println("Rpound: " + ++round);

            try {
                if (mageFirst) {
                    peshoTheMage.attack(goshoTheWarrior);
                    goshoTheWarrior.attack(peshoTheMage);
                } else {
                    goshoTheWarrior.attack(peshoTheMage);
                    peshoTheMage.attack(goshoTheWarrior);
                }

                mageFirst = !mageFirst;
            } catch (OutOfEnergyException e) {
                System.out.println(e.getMessage());
                break;
            }

            System.out.println();
        }

        System.out.println("The winner is " + (goshoTheWarrior.getHealth() > peshoTheMage.getHealth() ? "Gosho the Warrior" : "Pesho the Mage"));
    }
}
