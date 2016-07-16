package bg.softuni.prelude_to_oop.game.exception;

public class OutOfEnergyException extends Exception {
    private static final long serialVersionUID = -6931551611176354598L;

    public OutOfEnergyException(String message) {
        super(message);
    }
}
