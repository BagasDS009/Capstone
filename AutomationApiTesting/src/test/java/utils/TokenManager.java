package utils;

/**
 * In-memory token storage replacing file-based token sharing.
 * Tokens are stored during login and retrieved by other test classes.
 */
public class TokenManager {

    private static String adminToken;
    private static String doctorToken;

    public static void setAdminToken(String token) {
        adminToken = token;
    }

    public static String getAdminToken() {
        if (adminToken == null || adminToken.isEmpty()) {
            throw new IllegalStateException("Admin token not set. Ensure login admin test runs first.");
        }
        return adminToken;
    }

    public static void setDoctorToken(String token) {
        doctorToken = token;
    }

    public static String getDoctorToken() {
        if (doctorToken == null || doctorToken.isEmpty()) {
            throw new IllegalStateException("Doctor token not set. Ensure login doctor test runs first.");
        }
        return doctorToken;
    }

    public static void clear() {
        adminToken = null;
        doctorToken = null;
    }
}
