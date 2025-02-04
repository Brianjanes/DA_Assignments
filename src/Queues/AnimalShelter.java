package Queues;

/*
 * An Animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of  all animals at the shelter, or they can select
 * whether they would prefer a dog or cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create a data structure to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and DequeueCat.
 */

import java.util.LinkedList;
import java.util.Queue;

// creating dog and cat types
enum AnimalType {Dog, Cat}

// animal class, giving us the ability to name the animal and give it a type
class Animal {
    private String name;
    private AnimalType type;

    public Animal (String name, AnimalType type){
        this.name = name;
        this.type = type;
    }

    // name getter
    public String getName() {
        return name;
    }

    // type getter
    public AnimalType getType() {
        return type;
    }
}

// this is putting it all together, create the animal shelter queue, add cats, add dogs, remove any, remove cat, remove dog, etc.
public class AnimalShelter {
    private Queue <Animal> animals = new LinkedList<>();

    public void enQueue(Animal animal) {
        animals.add(animal);
    }

    public Animal deQueueAny() {
        return animals.isEmpty() ? null : animals.poll();
    }

    private Animal deQueueByType(AnimalType type) {
        for (Animal animal : new LinkedList<>(animals)) {
            if (animal.getType() == type) {
                animals.remove(animal);
                return animal;
            }
        }
        return null;
    }

    public Animal deQueueDog() {
        return deQueueByType(AnimalType.Dog);
    }

    public Animal deQueueCat() {
        return deQueueByType(AnimalType.Cat);
    }

    // Main method for showing it working
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enQueue(new Animal("Nico", AnimalType.Dog));
        shelter.enQueue(new Animal("Beepy", AnimalType.Cat));
        shelter.enQueue(new Animal("Stevie", AnimalType.Dog));
        shelter.enQueue(new Animal("Jackie", AnimalType.Cat));

        System.out.println("Dequeue any: " + shelter.deQueueAny().getName());

        Animal dog = shelter.deQueueDog();
        System.out.println("Dequeue dog: " + (dog != null ? dog.getName() : "No dogs available"));

        Animal cat = shelter.deQueueCat();
        System.out.println("Dequeue cat: " + (cat != null ? cat.getName() : "No cats available"));

        dog = shelter.deQueueDog();
        System.out.println("Dequeue dog: " + (dog != null ? dog.getName() : "No dogs available"));

        cat = shelter.deQueueCat();
        System.out.println("Dequeue cat: " + (cat != null ? cat.getName() : "No cats available"));
    }
}



