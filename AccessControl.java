import java.nio.channels.FileLock;

public interface AccessControl {
    boolean checkAccess(String area);

}