public class CaesarCipherStrategy implements EncryptionStrategy {
    private final int shift;
    public CaesarCipherStrategy(int shift)
    {
        this.shift = shift;
    }
    @Override
    public String encrypt(String data)
    {
        StringBuilder encrypted = new StringBuilder();
        for (char character : data.toCharArray())
        {
            if (Character.isLetter(character))
            {
                char shifted = (char) (character + shift);
                encrypted.append(shifted);
            } else
            {
                encrypted.append(character);
            }
        }
        return encrypted.toString();
    }
    @Override
    public String decrypt(String data)
    {
        StringBuilder decrypted = new StringBuilder();
        for (char character : data.toCharArray())
        {
            if (Character.isLetter(character)) {
                char shifted = (char) (character - shift);
                decrypted.append(shifted);
            } else {
                decrypted.append(character);
            }
        }
        return decrypted.toString();
    }
}
