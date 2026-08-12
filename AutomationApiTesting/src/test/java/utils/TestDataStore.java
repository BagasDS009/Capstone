package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * In-memory storage for test data (IDs, usernames) shared between tests.
 * Replaces the file-based JSON storage approach.
 */
public class TestDataStore {

    private static final Map<String, String> store = new HashMap<>();

    // Common keys
    public static final String ID_DOKTER_NEW = "idDokterNew";
    public static final String ID_DOKTER_UPDATE = "idDokterUpdate";
    public static final String ID_PASIEN_NEW = "idPasienNew";
    public static final String ID_PASIEN_UPDATE = "idPasienUpdate";
    public static final String ID_JADWAL_NEW = "idJadwalNew";
    public static final String ID_JADWAL_UPDATE = "idJadwalUpdate";
    public static final String ID_USER_NEW = "idUserNew";
    public static final String ID_USER_UPDATE = "idUserUpdate";
    public static final String USED_USERNAME = "usedUsername";

    public static void set(String key, String value) {
        store.put(key, value);
    }

    public static String get(String key) {
        String value = store.get(key);
        if (value == null) {
            throw new IllegalStateException("Test data not found for key: " + key);
        }
        return value;
    }

    public static boolean has(String key) {
        return store.containsKey(key);
    }

    public static void clear() {
        store.clear();
    }
}
