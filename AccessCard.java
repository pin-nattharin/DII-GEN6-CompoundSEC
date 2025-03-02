import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

public class AccessCard {
    private String cardId;
    private String name;
    private String employeeId;
    private RoleType role;
    private String encryptedData; // ข้อมูลของบัตรที่ถูกเข้ารหัส

    // คีย์สำหรับการเข้ารหัส (ควรเก็บคีย์นี้ในที่ปลอดภัย)
    private static final String SECRET_KEY = "ThisIsASecretKey";

    public AccessCard(String cardId, String name, RoleType role ) {
        this.cardId = cardId;
        this.name = name;
        this.role = role;
        this.encryptedData = encryptData(cardId + "|" + employeeId);
    }

    // เมธอดเข้ารหัสข้อมูลบัตร
    private String encryptData(String data) {
        try {
            // สร้างคีย์จาก SECRET_KEY
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

            // สร้าง Cipher สำหรับการเข้ารหัส
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // เพิ่ม Timestamp เพื่อให้คีย์เปลี่ยนแปลงตามเวลา
            String dataWithTimestamp = data + "|" + Instant.now().getEpochSecond();
            byte[] encryptedBytes = cipher.doFinal(dataWithTimestamp.getBytes(StandardCharsets.UTF_8));

            // แปลงข้อมูลเข้ารหัสเป็น Base64
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    // เมธอดถอดรหัสข้อมูลบัตร
    public String decryptData() {
        try {
            // สร้างคีย์จาก SECRET_KEY
            SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

            // สร้าง Cipher สำหรับการถอดรหัส
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // แปลงข้อมูลเข้ารหัสจาก Base64
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // แปลงข้อมูลถอดรหัสเป็น String
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }

    // เมธอดตรวจสอบความถูกต้องของบัตร
    public boolean isValid() {
        try {
            String decryptedData = decryptData();
            String[] parts = decryptedData.split("\\|");
            String cardId = parts[0];
            String employeeId = parts[1];
            long timestamp = Long.parseLong(parts[2]);

            // ตรวจสอบว่า Timestamp ยังไม่หมดอายุ (ตัวอย่าง: ภายใน 1 นาที)
            long currentTime = Instant.now().getEpochSecond();
            return (currentTime - timestamp) <= 60;  // หมดอายุภายใน 1 นาที
        } catch (Exception e) {
            return false;
        }
    }

    // Getter methods
    public String getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType newRole) {
        this.role = newRole;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public String getCardID() {
        return cardId;
    }
}