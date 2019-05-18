package handlers.enums;

public enum Coefficient {

    SMALL (16807),
    BIG (48271);

    private final int coefficient;

    Coefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }
}

