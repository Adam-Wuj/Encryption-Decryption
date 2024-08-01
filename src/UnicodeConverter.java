public class UnicodeConverter extends Converter {

    public UnicodeConverter(String text, int shift) {

        super(text, shift);
    }

    @Override
    public String convert(String operation) {
        if(operation.equals("enc")) {
            return encoder();
        } else if (operation.equals("dec")) {
            return decoder();
        } else return null;
    }

    private String encoder() {


        StringBuilder newMessage = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char nextChar = text.charAt(i);
            char encodedCharacter = (char) ((nextChar + shift) % 255);

            newMessage.append(encodedCharacter);
        }

        return newMessage.toString();
    }

    private String decoder() {
        StringBuilder newMessage = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char nextChar = text.charAt(i);
            char encodedCharacter = (char) ((nextChar - shift) % 255);

            newMessage.append(encodedCharacter);
        }

        return newMessage.toString();
    }
}
