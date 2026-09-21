package lw01.unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {

        int totalDays = getDays();
        int charge = 0;

        if(totalDays <= 3) {
            charge = totalDays * 60000;
        } else {
            charge = ((3 * 60000) + (totalDays - 3) * 45000);
        }
        return charge + 20000;
    }

    @Override
    public String label() {
        return "Projector";
    }

}
