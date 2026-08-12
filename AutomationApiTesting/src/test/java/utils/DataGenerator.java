package utils;

import java.util.Random;

/**
 * Generates random test data for API payloads.
 */
public class DataGenerator {

    private static final Random rand = new Random();

    public static String patientName() {
        return "Patient" + rand.nextInt(100);
    }

    public static String age() {
        return String.valueOf(rand.nextInt(80));
    }

    public static String nik() {
        return "235790100595" + rand.nextInt(10000);
    }

    public static String phone() {
        return "08570300" + rand.nextInt(10000);
    }

    public static String address() {
        return "Jl.Cendrawasih" + rand.nextInt(100);
    }

    public static String npaIdi() {
        return "451" + rand.nextInt(1000);
    }

    public static String doctorName() {
        return "Doctor" + rand.nextInt(100);
    }

    public static int id() {
        return rand.nextInt(1000);
    }

    public static int queueNumber() {
        return rand.nextInt(100);
    }

    public static String note() {
        return "Obat " + rand.nextInt(3) + "x Sehari setelah makan";
    }

    public static String username() {
        return "DocUser" + rand.nextInt(1000);
    }

    public static String password() {
        return "DocPass" + rand.nextInt(1000);
    }
}
