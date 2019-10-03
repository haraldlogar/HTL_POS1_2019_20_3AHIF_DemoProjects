/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

import java.util.*;
import java.util.function.BiConsumer;

/**
 *
 * @author bmayr
 */
public class GenericMapObjekte {

    private static String[] schule = new String[3];
    private static String[][] klasse = new String[3][3];
    private static String[][][] schueler = new String[3][3][3];
    private static List<String> schule1 = Arrays.asList(
            "Klasse11", "Klasse12", "Klasse13");
    private static List<String> schule2 = Arrays.asList(
            "Klasse21", "Klasse22", "Klasse23");
    private static List<String> schule3 = Arrays.asList(
            "Klasse31", "Klasse32", "Klasse33");

    // Instanzen der generischen Klasse TreeMap<K,V> erzeugen
    public static void main(String args[]) {
        TreeMap<String, String> map1 = new TreeMap<String, String>();
        TreeMap<String, Map<String, String>> map2
                = new TreeMap<String, Map<String, String>>();
        TreeMap<String, List<String>> map3 = new TreeMap<String, List<String>>();
        Map mapEintrag[][] = new Map[3][3];
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                mapEintrag[i][j] = new TreeMap<String, String>();
            }
        }
        // Die Elemente von Arrays initialisieren
        for (int i = 1; i < 3; i++) {
            schule[i] = new String("Schule" + i);
            for (int j = 1; j < 3; j++) {
                klasse[i][j] = new String("Klasse" + i + j);
                for (int k = 1; k < 3; k++) {
                    schueler[i][j][k] = new String("Schueler" + i + j + k);
                }
            }
        }
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                // Den Schlüsseln der Abbildung map1 Werte zuordnen
                map1.put(klasse[i][j], schule[i]);
            }
        }
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                mapEintrag[i][j].put(klasse[i][j],
                        map1.get(klasse[i][j]));
                for (int k = 1; k < 3; k++) {
                    // Den Schlüsseln der Abbildung map2 Werte zuordnen
                    map2.put(schueler[i][j][k], mapEintrag[i][j]);
                }
            }
        }
        System.out.println("\nEinfache for-Schleifen:");

        // Die zu den Schlüsseln von Maps korrespondierende Werte
        // ermitteln
        System.out.println();
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                for (int k = 1; k < 3; k++) {
                    System.out.println("Der " + schueler[i][j][k]
                            + " ist in der " + klasse[i][j] + " der "
                            + (map2.get(schueler[i][j][k])).get(klasse[i][j]));
                }
            }
        }
        System.out.println("\nDie forEach()-Methoden der "
                + "Interfaces Iterator und Map:\n");

        // Die Methode entrySet() liefert eine Set-View auf alle Einträge
        // einer Abbildung, die als Instanzen von einem parametrisierten
        // Typ der generischen Klasse Map.Entry<K,V> repräsentiert werden
        Set<Map.Entry<String, String>> mapEntrys = map1.entrySet();

        // Zu deren Anzeigen einen Iterator über die
        // Set<Map.Entry<String,String>>-Instanz legen
        Iterator<Map.Entry<String, String>> iterator = mapEntrys.iterator();

        // und als Übung im Umgang mit Lambdas die forEach()-Methode
        // des Iterator-Interface aufrufen
        /* iterator.forEach((Map.Entry<String,String> map) ->
        System.out.print(map + " "));*/
        // Alternativ dazu die hasNext()- und next()-Methoden des
        // Iterators aufrufen
        while (iterator.hasNext()) {
            Map.Entry<String, String> mapEin = iterator.next();
            String s1 = mapEin.getKey();
            String s2 = mapEin.getValue();
            System.out.println("Die " + s1 + " ist in der " + s2);
        }
        System.out.println();

        // Die Schlüssel und Werte der Abbildung map1 mittels eines
        // Lambda-Ausdrucks anzeigen
        BiConsumer<String, String> biConsumer
                = (String s1, String s2) -> System.out.println("In der " + s2
                        + " befindet sich die " + s1);
        map1.forEach(biConsumer);
        // Alternativ den Lambda-Ausdruck direkt im Methodenaufruf angeben
        /* map1.forEach((String s1, String s2) ->
        System.out.println("In der " + s2 + " befindet sich die "
        + s1)); */
        System.out.println();

        // Die Schlüssel und Werte der Abbildung map2 mittels eines
        // Lambda-Ausdrucks anzeigen
        map2.forEach((s, map)
                -> {
            System.out.print("\nDer " + s);
            map.forEach((String s1, String s2)
                    -> System.out.print(" ist in der " + s1 + " der " + s2));
        });
        System.out.println();
        System.out.println();

        // Den Schlüsseln der Abbildung map3 Werte zuordnen
        map3.put("Schule1", schule1);
        map3.put("Schule2", schule2);
        map3.put("Schule3", schule3);

        // und diese mittels eines Lambda-Ausdrucks anzeigen
        map3.forEach((String s, List<String> schule)
                -> System.out.println(s + " " + schule));

        // Die Einträge von Maps können mit foreach() durchlaufen und mit
        // replace() bzw. replaceAll() einzeln oder alle abgeändert werden
        map2.forEach((String s, Map<String, String> schulklassen)
                -> {
            schulklassen.replace("Klasse11", "Schule1", "Schule1Neu");
            schulklassen.replace("Klasse21", "Schule2", "Schule2Neu");
            // schulklassen.replaceAll((String k, String v)->v + "Neu");
        }
        );

        // Die durchgeführten Änderungen anzeigen
        System.out.println();
        map2.forEach((s, map)
                -> {
            System.out.println("\nDer " + s);
            map.forEach((String s1, String s2)
                    -> System.out.print(" ist in der " + s1 + " der " + s2));
        });
        System.out.println();
        System.out.println();
        map2.forEach((String s, Map<String, String> schulklassen)
                -> {
            schulklassen.put("KlasseNeu", "SchuleNeu");
            schulklassen.putIfAbsent("KlasseAlt", "SchuleAlt");
            String wert = schulklassen.get("Klasse11");
            if (wert != null) {
                System.out.println("Der " + s + " ist in der Klasse11 der " + wert);
            }
            wert = schulklassen.get("KlasseNeu");
            if (wert != null) {
                System.out.println("Der " + s + " ist in der KlasseNeu der " + wert);
            }
            wert = schulklassen.get("KlasseAlt");
            if (wert != null) {
                System.out.println("Der " + s + " ist in der KlasseNeu der " + wert);
            }
        });
    }
}
