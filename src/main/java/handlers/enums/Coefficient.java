package handlers.enums;

public enum Coefficient {

    A (16807),
    B (48271);

    private final int coefficient;

    Coefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }
}

