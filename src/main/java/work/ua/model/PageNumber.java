package work.ua.model;

public class PageNumber {

    private String numberl;

    public PageNumber(String numberl) {
        this.numberl = numberl;
    }

    public String getNumberl() {
        return numberl;
    }

    public void setNumberl(String numberl) {
        this.numberl = numberl;
    }

    @Override
    public String toString() {
        return "PageNumber{" +
                "numberl=" + numberl +
                '}';
    }
}
