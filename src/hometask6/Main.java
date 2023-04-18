package hometask6;

import hometask6.tasks.Laptops;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String selectedType;
        String parameterNumber;
        Scanner scanner = new Scanner(System.in);

        Laptops laptop = new Laptops("MacBook Air", "M2 Entry", "Apple macOS 12 Monterey", "8", "256", "Silver");
        Laptops laptop1 = new Laptops("MacBook Air", "M2 Entry","Apple macOS 12 Monterey", "16", "1024", "Black");
        Laptops laptop2 = new Laptops("MacBook Pro", "13", "Apple macOS 12 Monterey", "8", "256", "White");
        Laptops laptop3 = new Laptops("MacBook Pro", "13", "Apple macOS 12 Monterey", "16", "1024", "Gray");
        Laptops laptop4 = new Laptops("Asus Zenbook", "S 13 OLED", "Microsoft Windows 11 Home", "16", "1024", "Gray");
        Laptops laptop5 = new Laptops("Asus Zenbook", "S 13 OLED", "Microsoft Windows 11 Home", "16", "512", "Blue");
        Laptops laptop6 = new Laptops("Samsung Galaxy Book2", "Pro 13", "Microsoft Windows 11 Home", "8", "256", "Gray");
        Laptops laptop7 = new Laptops("Samsung Galaxy Book2", "Pro 13", "Microsoft Windows 11 Home", "8", "512", "Silver");
        Laptops laptop8 = new Laptops("Huawei MateBook", "13s", "Microsoft Windows 10 Home 64 Bit", "16", "512", "Blue");
        Laptops laptop9 = new Laptops("Huawei MateBook", "13s", "Microsoft Windows 10 Home 64 Bit", "16", "1024", "Black");
        Laptops laptop10 = new Laptops("Dell XPS", "13 9310 OLED", "Microsoft Windows 10 Home 64 Bit", "16", "512", "White");
        Laptops laptop11 = new Laptops("Dell XPS", "13 9310 OLED", "Microsoft Windows 10 Home 64 Bit", "16", "1024", "Silver");

        Map<Integer, Laptops> laptopsMap = new HashMap<Integer, Laptops>();

        laptopsMap.put(1, laptop);
        laptopsMap.put(2, laptop1);
        laptopsMap.put(3, laptop2);
        laptopsMap.put(4, laptop3);
        laptopsMap.put(5, laptop4);
        laptopsMap.put(6, laptop5);
        laptopsMap.put(7, laptop6);
        laptopsMap.put(8, laptop7);
        laptopsMap.put(9, laptop8);
        laptopsMap.put(10, laptop9);
        laptopsMap.put(11, laptop10);
        laptopsMap.put(12, laptop11);

        while (true) {
            System.out.print("\nYou can choose a parameter: 1. Brand; 2. Model; 3. OS; 4. RAM; 5. SSD; 6. Color");
            System.out.print("\nPrint number of the parameter from 1 to 6 or input 0 for exit: ");

            parameterNumber = scanner.nextLine();
            System.out.println(parameterNumber);

            if (parameterNumber.equals("0")) {
                System.out.println("Come again!");
                break;
            }

            switch (parameterNumber) {
                case "1":
                    getBrand(laptopsMap).forEach(System.out::println);
                    System.out.println("\nChoose and print brand: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterBrands(laptopsMap, selectedType)));
                    break;

                case "2":
                    getModels(laptopsMap).forEach(System.out::println);
                    System.out.print("\nChoose and print model: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterModels(laptopsMap, selectedType)));
                    break;

                case "3":
                    getOS(laptopsMap).forEach(System.out::println);
                    System.out.print("\nChoose and print OS: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterOS(laptopsMap, selectedType)));
                case "4":
                    getRAM(laptopsMap).forEach(System.out::println);
                    System.out.print("\nChoose and print RAM: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterRAM(laptopsMap, selectedType)));
                    break;
                case "5":
                    getVideoModels(laptopsMap).forEach(System.out::println);
                    System.out.print("\nChoose and print SSD: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterSSD(laptopsMap, selectedType)));
                    break;
                case "6":
                    getColors(laptopsMap).forEach(System.out::println);
                    System.out.println("\nChoose and print color: ");
                    selectedType = scanner.nextLine();
                    outLaptop((filterByColor(laptopsMap, selectedType)));
                    break;
                default:
                    break;
            }
        }
        scanner.close();

    }

    public static Collection<Laptops> filterBrands(Map<Integer, Laptops> laptopsMap, String brand) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getBrand().equals(brand))
                .sorted(Comparator.comparing(Laptops::getBrand))
                .collect(Collectors.toList());
    }

    public static Collection<Laptops> filterModels(Map<Integer, Laptops> laptopsMap, String Model) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getModel().equals(Model))
                .sorted(Comparator.comparing(Laptops::getBrand))
                .collect(Collectors.toList());
    }

    public static Collection<Laptops> filterOS(Map<Integer, Laptops> laptopsMap, String OS) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getOS().equals(OS))
                .sorted(Comparator.comparing(Laptops::getBrand))
                .collect(Collectors.toList());
    }


    public static Collection<Laptops> filterRAM(Map<Integer, Laptops> laptopsMap, String RAM) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getRAM().equals(RAM))
                .sorted(Comparator.comparing(Laptops::getBrand))
                .collect(Collectors.toList());
    }

    public static Collection<Laptops> filterSSD(Map<Integer, Laptops> laptopsMap, String SSD) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getSSD().equals(SSD))
                .sorted(Comparator.comparing(Laptops::getBrand))
                .collect(Collectors.toList());
    }

    public static Collection<Laptops> filterByColor(Map<Integer, Laptops> laptopsMap, String color) {
        return laptopsMap.values().stream()
                .filter(laptop -> laptop.getColor().equals(color))
                .sorted(Comparator.comparing(Laptops::getBrand))
                .collect(Collectors.toList());
    }

    public static void outLaptop (Collection<Laptops> laptopsCollection) {
        laptopsCollection.stream()
                .forEach(laptop -> System.out.printf("%s —— \t %s | %s | %s | %s | %s \n",
                        laptop.getBrand(), laptop.getModel(), laptop.getOS(),
                        laptop.getRAM(), laptop.getSSD(),
                        laptop.getColor()));
    }

    public static Set<String> getColors(Map<Integer, Laptops> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getColor())
                .collect(Collectors.toSet());
    }

    public static Set<String> getBrand(Map<Integer, Laptops> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getBrand())
                .collect(Collectors.toSet());
    }

    public static Set<String> getModels(Map<Integer, Laptops> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getModel())
                .collect(Collectors.toSet());
    }

    public static Set<String> getOS(Map<Integer, Laptops> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getOS())
                .collect(Collectors.toSet());
    }


    public static Set<String> getRAM(Map<Integer, Laptops> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getRAM())
                .collect(Collectors.toSet());
    }

    public static Set<String> getVideoModels(Map<Integer, Laptops> laptopsMap) {
        return laptopsMap.keySet().stream()
                .map(key -> laptopsMap.get(key).getSSD())
                .collect(Collectors.toSet());
    }

}