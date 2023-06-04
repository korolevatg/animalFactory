import animals.AbsAnimal;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        List<AbsAnimal> animals = new ArrayList<>();

        while(true) {
            String commandStr = "";
            do {
                System.out.println("Введите команду add/list/exit");
                commandStr = scanner.next().toUpperCase().trim();
            } while (!commandStr.equals("ADD") && !commandStr.equals("LIST") && !commandStr.equals("EXIT"));

            CommandsData commandsData = CommandsData.valueOf(commandStr);
            switch (commandsData) {
                case ADD: {
                    String animalStr = "";
                    do {
                        System.out.println("Введите животное cat/dog/duck");
                        animalStr = scanner.next().toUpperCase().trim();
                    } while (!animalStr.equals("CAT") && !animalStr.equals("DOG") && !animalStr.equals("DUCK"));
                    AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalStr);
                    AnimalFactory animalFactory = new AnimalFactory();

                    AbsAnimal animal = fillAnimalData(animalFactory.create(animalTypeData));

                    animals.add(animal);
                    animal.say();
                   break;
                }

                case LIST: {
                    animals.forEach((AbsAnimal animal) -> System.out.println(animal.toString()));
                   break;
                }


                case EXIT: {
                    System.exit(0);
                    break;
                }

            }

        }

    }
    private static AbsAnimal fillAnimalData(AbsAnimal animal) {
            System.out.println("Введите имя животного");
            String name = scanner.next();
            animal.setName(name);

            System.out.println("Введите возраст животного");
            String ageStr = scanner.next();
            animal.setAge(Integer.parseInt(ageStr));

            System.out.println("Введите вес животного: ");
            String weightStr = scanner.next();
            animal.setWeight(Integer.parseInt(weightStr));

            System.out.println("Введите цвет животного");
            String color = scanner.next();
            animal.setColor(color);

            return animal;
        }
    }

