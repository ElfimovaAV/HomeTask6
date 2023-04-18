/*Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы.
Реализовать в Java.
Создать множество ноутбуков.

Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:

“Введите цифру, соответствующую необходимому критерию:
1 - бренд
2 - цвет

Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации
можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

СПОЙЛЕР:

1) создаете класс ноутбук (equals, hashCode)
2) создаете сет ноутбукоа
3) создаете и заполняете Map<Integer, Laptop>
4) запрашиваете через сканнер у пользователя критерий фильтрации
5) циклом проходите по Map.Entry<Integer, Laptop> entry: entries
6) В результирующий Set<Laptop> складываете ноутбуки entry.getValue() у которых
   равны критерию пользователя*/


package hometask6.tasks;

import java.util.Objects;

public class Laptops {
    private String brand;
    private String model;
    private String OS;
    private String RAM;
    private String SSD;
    private String color;

    // Конструктор класса
    public Laptops(String brand, String model, String OS,
                   String RAM, String SSD, String color) {

        this.brand = brand;
        this.model = model;
        this.OS = OS;
        this.RAM = RAM;
        this.SSD = SSD;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }


    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getSSD() {
        return SSD;
    }

    public void setSSD(String videoModel) {
        this.SSD = videoModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptops \n" +
                "brand = " + brand +
                ", model = " + model +
                ", OS = " + OS +
                ", RAM = " + RAM +
                ", SSD = " + SSD +
                ", color = " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Laptops))
            return false;
        Laptops notebooks = (Laptops) o;
        return Objects.equals(brand, notebooks.brand)
                && Objects.equals(model, notebooks.model)
                && Objects.equals(OS, notebooks.OS)
                && Objects.equals(RAM, notebooks.RAM)
                && Objects.equals(SSD, notebooks.SSD)
                && Objects.equals(color, notebooks.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, OS, RAM, SSD, color);
    }

}

