package com.example.app.utils;

import java.util.Random;

/**
 * Random test data generator for mobile UI tests.
 */
public class General {

    private static final Random rand = new Random();

    public static String randomName() {
        return "Patient" + rand.nextInt(100);
    }

    public static String randomUmur() {
        return String.valueOf(rand.nextInt(80));
    }

    public static String randomNik() {
        return "23579010059527" + rand.nextInt(99);
    }

    public static String randomPhone() {
        return "08570300" + rand.nextInt(10000);
    }

    public static String randomAddress() {
        return "Jl.Cendrawasih" + rand.nextInt(100);
    }

    public static String randomNpaIdi() {
        return "451" + rand.nextInt(999);
    }

    public static String randomNameDoctor() {
        return "Doctor" + rand.nextInt(500);
    }

    public static String randomNote() {
        return "Obat " + rand.nextInt(3) + "x Sehari setelah makan";
    }

    public static String randomUsername() {
        return "DocUser" + rand.nextInt(500);
    }

    public static String randomPassword() {
        return "DocPass" + rand.nextInt(1000);
    }

    // Backward-compatible overloads (kept for existing callers during transition)
    public static String randomName(String ignored) { return randomName(); }
    public static String randomUmur(String ignored) { return randomUmur(); }
    public static String randomNik(String ignored) { return randomNik(); }
    public static String randomPhone(String ignored) { return randomPhone(); }
    public static String randomAddress(String ignored) { return randomAddress(); }
    public static String randomNpaIdi(String ignored) { return randomNpaIdi(); }
    public static String randomNameDoctor(String ignored) { return randomNameDoctor(); }
    public static String randomNote(String ignored) { return randomNote(); }
    public static String randomUsername(String ignored) { return randomUsername(); }
}
