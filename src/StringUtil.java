import java.security.MessageDigest; //Donne acces a l'algo SHA256

public class StringUtil {

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Applique SHA-256 à notre input
            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            // Convertit le tableau de bytes du hash en une représentation hexadécimale
            StringBuffer hexString = new StringBuffer(); // Cette variable contiendra le hash en format hexadécimal
            // Convertit chaque byte du tableau de hash en sa représentation hexadécimale
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                } // Ajoute un '0' pour assurer deux chiffres hexadécimaux par byte
                hexString.append(hex); // Ajoute la représentation hexadécimale du byte au StringBuffer

            }

            return hexString.toString();
        } catch (Exception e) {
            // En cas d'erreur lors du calcul du hash, lance une RuntimeException
            throw new RuntimeException(e);
        }

    }
}

