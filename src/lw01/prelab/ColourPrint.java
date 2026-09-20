package lw01.prelab;

public class ColourPrint extends PrintJob {
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int totalPages = getPages();
        int baseCharge = 0;

        if(totalPages <= 10) {
            baseCharge = totalPages * 1500;
        }

        else {
            baseCharge = (10 * 1500) + ((totalPages - 10) * 1000);
        }

        int totalCharge = baseCharge + 2000;

        return totalCharge;
    }

    @Override
    public String label() {
        return "Colour";
    }
}
