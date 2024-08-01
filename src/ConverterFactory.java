public class ConverterFactory {

    public static Converter makeConverter(String method, String text, int shift) {

        if (method.equals("unicode")) {
            return new UnicodeConverter(text, shift);
        } else if (method.equals("shift")) {
            return new ShiftConverter(text, shift);
        } else {
            return null;
        }
    }
}
