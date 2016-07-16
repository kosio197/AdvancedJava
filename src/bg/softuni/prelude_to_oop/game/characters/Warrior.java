package bg.softuni.prelude_to_oop.game.characters;

import bg.softuni.prelude_to_oop.game.exception.OutOfEnergyException;

public class Warrior extends GameCharacter {
    private static final int BASE_HEALTH = 5000;
    private static final int BASE_POWER = 200;
    private static final int BASE_ENERGY = 1000;
    private static final int BASE_ATTACK_COST = 150;

    private static final double BLOCK_PERCENTAGE = 0.4;
    private static final double SURGE_OF_POWER_PERCENTAGE = 0.7;

    public Warrior(int health, int power, int energy, int attackCost, String name) {
        super(health, power, energy, attackCost, name);
    }

    public Warrior(String name) {
        this(BASE_HEALTH, BASE_POWER, BASE_ENERGY, BASE_ATTACK_COST, name);
    }

    @Override
    public void attack(GameCharacter other) throws OutOfEnergyException {
        if (other == this) {
            throw new IllegalStateException("Cannot attack itself");
        }

        if (getEnergy() < getAttackCost()) {
            throw new OutOfEnergyException(getName() + " is out of energy. Battle over.");
        }

        boolean surgeOfPower = Math.random() < SURGE_OF_POWER_PERCENTAGE; //30%

        if (surgeOfPower) {
            System.out.println(getName() + " was lucky. Free attack.");
        } else {
            setEnergy(getEnergy() - getAttackCost());

        }

        other.respond(getPower());
    }

    @Override
    public void respond(int damage) {
        boolean hasBlocked = Math.random() < BLOCK_PERCENTAGE; // 60%
        int damageCost = damage;
        if (hasBlocked) {
            System.out.println("Attack was blocked!");
            damageCost /= 2;
        }

        setHealth(getHealth() - damageCost);
        System.out.println(damage + " damage dealt!");
    }

}
