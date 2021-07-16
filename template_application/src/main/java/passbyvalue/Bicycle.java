package passbyvalue;

public class Bicycle {

    private String color;

    public Bicycle(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "color='" + color + '\'' +
                '}';
    }
}
