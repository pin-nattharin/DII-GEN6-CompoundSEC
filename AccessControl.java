import java.nio.channels.FileLock;

public interface AccessControl {
    boolean checkAccess(String floor, String room);

}