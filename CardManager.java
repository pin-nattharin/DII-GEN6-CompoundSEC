import java.util.HashMap;
import java.util.Map;

public class CardManager {
    private static CardManager instance;
    private Map<String, AccessCard> cardDatabase;

    private CardManager() {
        cardDatabase = new HashMap<>();
    }

    public static CardManager getInstance() {
        if (instance == null) {
            instance = new CardManager();
        }
        return instance;
    }

    // เพิ่มบัตรใหม่
    public void addCard(String cardID,String name, RoleType role) {
        if (cardDatabase.containsKey(cardID)) {
            System.out.println("❌ Card already exists!");
        } else {
            AccessCard newCard = new AccessCard(cardID, name, role);
            cardDatabase.put(cardID, newCard);
            System.out.println("(✅ Card added) CardID: " + cardID + " Name: "+name+ " with role " + role);
        }
    }

    // แก้ไขสิทธิ์บัตร
    public void modifyCard(String cardID, RoleType newRole) {
        if (cardDatabase.containsKey(cardID)) {
            cardDatabase.get(cardID).setRole(newRole);
            System.out.println("✅ Card modified: " + cardID + " new role is " + newRole);
        } else {
            System.out.println("❌ Card not found!");
        }
    }

    // เพิกถอนบัตร
    public void revokeCard(String cardID) {
        if (cardDatabase.containsKey(cardID)) {
            cardDatabase.remove(cardID);
            System.out.println("✅ Card revoked: " + cardID);
        } else {
            System.out.println("❌ Card not found!");
        }
    }

    // ตรวจสอบสิทธิ์ของบัตร
    public AccessCard getCard(String cardID) {
        return cardDatabase.get(cardID);
    }
}
