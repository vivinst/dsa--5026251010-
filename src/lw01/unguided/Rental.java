package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    protected Rental(String id, int days) {
        if(days <= 0) {
            throw new IllegalArgumentException("Hari harus lebih dari 0");
        }

        this.id = id;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if(units <= 0) {
            throw new IllegalArgumentException("Jumlah unit harus lebih dari 0");
        }

        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
