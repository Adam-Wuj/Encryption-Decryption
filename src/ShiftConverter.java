import java.util.Scanner;

public class ShiftConverter extends Converter {

    public ShiftConverter(String text, int shift) {

        super(text, shift);
    }

    @Override
    public String convert(String operation) {

        if (operation.equals("enc")) {
            return encoder();
        } else if (operation.equals("dec")) {
            return decoder();
        } else return null;
    }


    private String encoder() {

        StringBuilder newMessage = new StringBuilder();
        Scanner messageObject = new Scanner(text);
        while (messageObject.hasNext()) {

            String nextToken = messageObject.next();
            for (int i = 0; i < nextToken.length(); i++) {
                char nextChar = nextToken.charAt(i);
                char encodedCharacter = (char) (nextChar < 65 || nextChar > 90 ? nextChar : ((nextChar - 65) + shift) % 26 + 65);
                encodedCharacter = nextChar < 97 || nextChar > 122 ? encodedCharacter : (char) (((char) ((nextChar - 97) + shift) % 26) + 97);
                newMessage.append(encodedCharacter);
            }
            newMessage.append(" ");
        }

        return newMessage.toString();
    }

    private String decoder() {

        StringBuilder newMessage = new StringBuilder();
        Scanner messageObject = new Scanner(text);
        while (messageObject.hasNext()) {

            String nextToken = messageObject.next();
            for (int i = 0; i < nextToken.length(); i++) {
                char nextChar = nextToken.charAt(i);
                char encodedCharacter = (char) (nextChar < 65 || nextChar > 90 ? nextChar : (26 + (nextChar - 65) - shift) % 26 + 65);
                encodedCharacter = ((nextChar < 97) || (nextChar > 122)) ? encodedCharacter : (char) (((char) (26 + (nextChar - 97) - shift) % 26) + 97);
                newMessage.append(encodedCharacter);
            }
            newMessage.append(" ");
        }

        return newMessage.toString();
    }
}
