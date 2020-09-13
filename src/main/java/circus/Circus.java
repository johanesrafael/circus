package Circus;

import Circus.animal.Animal;
import Circus.animal.Duck;
import Circus.animal.Parrot;
import Circus.stuff.Cannon;
import Circus.stuff.Equipment;
import Circus.animal.Tiger;
import Circus.stuff.Cage;
import Circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {

//        makeAnimalsTalk();
//        System.out.println("Total value of equipments " + calculateValue(equipments));
//        System.out.println("Total value of animals " + calculateValue(animals));

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        animalArrayList.add(new Duck("Duckling"));
        Parrot parrot = new Parrot("Parrot");
        animalArrayList.add(parrot);
        System.out.println(animalArrayList.size());
        animalArrayList.sort(Animal.compareByName);
        for (Animal a : animalArrayList) {
            System.out.println(a.name);
        }
        System.out.println(animalArrayList.indexOf(parrot));

        makeAnimalsTalk();
        System.out.println("Total value of equipments " + calculateValue(equipments));
        System.out.println("Total value of animals " + calculateValue(animals));
        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Ducky");
        duckCage.lockUp(duck);
        Parrot parot = new Parrot("Parroty");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parot);

        Tiger tiger = new Tiger("Tigress");
        Cage<Tiger> tigerCage = new Cage<>();
        tigerCage.lockUp(tiger);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);
        cages.add(tigerCage);

        for (Cage c : cages) {
            c.release();
        }

    }
}
