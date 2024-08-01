public abstract class Converter {

    String text;

    int shift;

    public Converter(String text, int shift) {

        this.text = text;
        this.shift = shift;
    }

    public abstract String convert(String operation);
}
