public class EncryptionService {
    private EncryptionStrategy strategy;

    public void setEncryptionStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    public String encrypt(String data) {
        if (strategy == null) {
            throw new IllegalStateException("Encryption strategy is not set!");
        }
        return strategy.encrypt(data);
    }

    public String decrypt(String data) {
        if (strategy == null) {
            throw new IllegalStateException("Encryption strategy is not set!");
        }
        return strategy.decrypt(data);
    }
}
