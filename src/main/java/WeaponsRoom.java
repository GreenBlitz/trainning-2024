import java.util.Base64;

public class WeaponsRoom extends Room {
    public WeaponsRoom(double w, double l, double h) {
        super(w, l, h);
    }
    @Override
    public void Intercom(String message) {
        String encodedString = Base64.getEncoder().encodeToString(message.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i += 2) {
            sb.append(encodedString.charAt(i));
        }
        for (int i = 1; i < encodedString.length(); i += 2) {
            sb.append(encodedString.charAt(i));
        }
        System.out.println(sb);
    }
}