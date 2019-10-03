/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlogar.htl.pos3.lambdaproject;

import java.util.function.*;

/**
 *
 * @author bmayr
 */
public class BiConsumerBiPredicateundBiFunction {

    // Das funktionale Interface Predicate entscheidet, ob das im
    // Aufruf der test()-Methode übergebene Objekt die angegebenen
    // Kriterien erfüllt
    public static boolean vergleich(Predicate<Integer> predicate, Integer i) {
        return predicate.test(i);
    }

    // Das funktionale Interface Consumer definiert eine Methode
    // accept(), die ein Argument übergeben bekommt und kein Ergebnis
    // liefert; sie führt die in einem Lambda-Ausdruck mit dem Target-
    // Typ Consumer angegebene Operation aus
    public static void anzeige(Consumer<Integer> consumer, Integer i) {
        consumer.accept(i);
    }

    // Das funktionale Interface BiPredicate definiert eine Zwei-
    // Argumente-Version von Predicate und entscheidet, ob die im
    // Aufruf der test()-Methode übergebenen Objekte die angegebenen
    // Kriterien erfüllen
    public static boolean biVergleich(BiPredicate<Integer, Integer> biPredicate,
            Integer i1, Integer i2) {
        return biPredicate.test(i1, i2);
    }

    // Das funktionale Interface BiConsumer definiert eine Zwei-
    // Argumente-Version von Consumer; seine Methode accept(), die
    // zwei Argumente übergeben bekommt und ebenfalls kein Ergebnis
    // liefert, führt die angegebene Operation aus
    public static void biAnzeige(BiConsumer<Integer, Integer> biConsumer,
            Integer i1, Integer i2) {
        biConsumer.accept(i1, i2);
    }

    // Das funktionale Interface Function wendet eine Funktion auf das
    // im Aufruf seiner Methode apply() übergebene Argument an, die
    // als Ergebnis den Wert der Funktion liefert
    public static Integer berechnung(Function<Integer, Integer> function,
            Integer i) {
        return function.apply(i);
    }

    // Das funktionale Interface BiFunction wendet eine Funktion mit
    // zwei Variablen auf die im Aufruf seiner Methode apply()
    // übergebenen Objekte an und liefert zusammen mit dem
    // errechneten Funktionswert die Zwei-Argumente-Version von
    // Function
    public static Integer biBerechnung(
            BiFunction<Integer, Integer, Integer> biFunction, Integer i1, Integer i2) {
        return biFunction.apply(i1, i2);
    }

    // Das funktionale Interface BiFunction kann Argumente von
    // unterschiedlichen Typen übergeben bekommen
    public static Double berechnungmitFunction(
            BiFunction<Integer, Double, Double> biFunction1,
            Integer i1, Double d2) {
        return biFunction1.apply(i1, d2);
    }

    // Das von BiFunction<T,T,T> abgeleitete Interface
    // BinaryOperator<T> definiert eine Operation, in der beide
    // Operanden und das Ergebnis den gleichen Typ haben
    public static Integer berechnungmitBinaryOperator(
            BinaryOperator<Integer> binaryOperator, Integer i1, Integer i2) {
        return binaryOperator.apply(i1, i2);
    }

    public static void biAnzeige1(
            BiConsumer<Integer, Integer> biConsumer, Integer i1, Integer i2) {
        biConsumer.accept(i1, i2);
    }

    public static void biAnzeige2(BiConsumer<Integer, Double> biConsumer,
            Integer i1, Double d2) {
        biConsumer.accept(i1, d2);
    }

    public static void main(String[] args) {
        // In den oben definierten Methoden werden Lambda-Ausdrücke mit
        // dem erwarteten Target-Typ übergeben; die in den Variablen
        // resultx zugewiesenen Werte werden im Nachhinein nicht mehr
        // abgeändert, so dass diese effectivaly final sind
        boolean result1 = biVergleich((a, b) -> a == b * 2, 10, 5);
        biAnzeige((Integer i1, Integer i2)
                -> System.out.println("Das Ergebnis des Tests "
                        + i2 + " * 2 == " + i1 + " mit BiPredicate ist "
                        + result1), 10, 5);
        boolean result2 = biVergleich((a, b) -> a / 2 == b, 20, 5);
        biAnzeige((Integer i1, Integer i2)
                -> System.out.println("Das Ergebnis des Tests "
                        + i1 + " / 2 == " + i2 + " mit BiPredicate ist "
                        + result2), 20, 5);
        boolean result3 = vergleich((a) -> a == 2, 2);
        anzeige((Integer i)
                -> System.out.println("Das Ergebnis des Tests "
                        + i + " == 2" + " mit Predicate ist " + result3), 2);
        boolean result4 = vergleich((a) -> a + a == 4, 2);
        anzeige((Integer i)
                -> System.out.println("Das Ergebnis des Tests "
                        + i + " + " + i + " == 4" + " mit Predicate ist " + result4), 2);
        Integer result5 = berechnung((Integer i)
                -> {
            if (i >= 10) {
                return i;
            }
            return i + 10;
        }, 5);
        anzeige((Integer i)
                -> System.out.println("Der Wert der Function mit dem Argument "
                        + i + " ist " + result5), 5);
        Integer result6 = biBerechnung((Integer i1, Integer i2)
                -> i1 + i2, 5, 10);
        biAnzeige((Integer i1, Integer i2)
                -> System.out.println("Der Wert der BiFunction mit den "
                        + "Argumenten " + i1 + " und " + i2 + " ist " + result6), 5, 10);
        Double result7 = berechnungmitFunction(
                (Integer i1, Double d2) -> i1 + d2, 5, 10.);
        biAnzeige2((Integer i1, Double d2)
                -> System.out.println("Der Wert der BiFunction mit den "
                        + "Argumenten " + i1 + " und " + d2 + " ist "
                        + result7), 5, 10.);
        Integer result8 = berechnungmitBinaryOperator(
                (Integer i1, Integer i2) -> i1 * i2, 5, 10);
        biAnzeige1((Integer i1, Integer i2)
                -> System.out.println("Der Wert des BinaryOperators mit den "
                        + "Argumenten " + i1 + " und " + i2 + " ist "
                        + result8), 5, 10);
        // BinaryOperatoren mit den statischen Methoden des Interface
        // BinaryOperator erzeugen; weil BinaryOperator ein Unterinterface
        // von BiFunction ist, können Instanzen vom Typ BinaryOperator
        // auch mittles Referenzen vom Typ des Oberinterface in der
        // Methode biBerechnung() übergeben werden
        BinaryOperator<Integer> maxByOperator
                = BinaryOperator.<Integer>maxBy(Integer::compareTo);
        BinaryOperator<Integer> minByOperator = BinaryOperator.<Integer>minBy(
                (v1, v2) -> Integer.compare(v1, v2));
        Integer result9 = biBerechnung(maxByOperator, 5, 10);
        biAnzeige((Integer i1, Integer i2)
                -> System.out.println("Der Wert des BinaryOperators maxBy "
                        + "mit den Argumenten " + i1 + " und " + i2 + " ist "
                        + result9), 5, 10);
        Integer result10 = biBerechnung(minByOperator, 5, 10);
        biAnzeige((Integer i1, Integer i2)
                -> System.out.println("Der Wert des BinaryOperators minBy "
                        + "mit den Argumenten " + i1 + " und " + i2 + " ist "
                        + result10), 5, 10);
        // Einen UnaryOperator mit der statischen Methode des Interface
        // UnaryOperator erzeugen; weil UnaryOperator<T> ein
        // Unterinterface von Function<T,T> ist, kann auch eine Referenz
        // von diesem Typ in der Methode berechnung() zugewiesen werden;
        // ein UnaryOperator definiert eine Operation mit einem einzigen
        // Operanden, die ein Ergebnis vom gleichen Typ wie der des
        // Operanden liefert; der Identity-Operator gibt das übergebene
        // Argument unverändert zurück
        UnaryOperator<Integer> identityOperator = UnaryOperator.<Integer>identity();
        Integer result11 = berechnung(identityOperator, 5);
        anzeige((i) -> System.out.println("Der Wert des "
                + "UnaryOperators mit dem Argument " + i + " ist " + result11), 5);
        // Die Default-Methode <V> Function<T,V> andThen(
        // Function<? super R,? extends V> after) des Function-Interface
        // gibt eine zusammengesetzte Funktion zurück, die zuerst die
        // Funktion, an der die Methode aufgerufen wird, auf die
        // Input-Daten anwendet und danach die im Aufruf übergebene
        // Funktion
        Function<Integer, Integer> function1 = (i)
                -> {
            if (i >= 10) {
                return i;
            }
            return i + 10;
        };
        Function<Integer, Integer> function2 = (i) -> i * 2;
        Integer result12 = berechnung(function1.andThen(function2), 5);
        Integer result13 = berechnung(function2.andThen(function1), 5);
        anzeige((i) -> System.out.println("Der Wert der "
                + "zusammengesetzten Funktion function2(function1(x)) mit "
                + "dem Argument" + i + " ist " + result12), 5);
        anzeige((i) -> System.out.println("Der Wert der "
                + "zusammengesetzten Funktion function1(function2(x)) mit "
                + "dem Argument" + i + " ist " + result13), 5);
    }

}
