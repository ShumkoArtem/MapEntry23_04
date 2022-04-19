import java.util.*;

public class main {

    public static Map<String, Integer> employee = new HashMap<>(); //Task 0
    public static Map<String, Product> toes = new HashMap<>(); // Task 1
    public static Set<Student> students = new HashSet<>(); // Task2

    public static void main(String[] args) {

        System.out.println("***********Task 0***********");
        /**
         * 0 Напишите Java-программу для итерации объекта типа HashMap
         * с использованием цикла while и улучшенного цикла for.
         */

        employeeAdd(employee); //заполняем Map<String, Integer> employee
        System.out.println("For :");
        employeeForEach(employee); //улучшенный цикл For
        System.out.println("While :");
        employeeWhile(employee); // перебор Мар с помощью While


        System.out.println("***********Task 1***********");
        /**
         * 1 Создайте HashMap, содержащий пары значений  - имя игрушки и объект игрушки (класс Product).
         *  Перебрать и распечатать пары значений - entrySet().
         * Перебрать и распечатать набор из имен продуктов  - keySet().
         * Перебрать и распечатать значения продуктов - values().
         * Для каждого перебора создать свой метод.
         */

        toesPut(toes); // Заполняем MAP (Task 1)
        toesEntry(toes); //Перебрать и распечатать пары значений - entrySet()
        toesKeySet(toes); //Перебрать и распечатать набор из имен продуктов  - keySet()
        toesValues(toes); //Перебрать и распечатать значения продуктов - values()

        System.out.println("***********Task 2***********");
        /**
         * 2 Добавить студентов в коллекцию. Создать класс Student, содержащий
         * следующие характеристики – имя, группа, курс, оценки по предметам.
         * Создать коллекцию, содержащую объекты класса Student.
         * 1. Написать метод, который удаляет студентов со средним баллом <3.
         * 2. Если средний балл>=3, студент переводится на следующий курс.
         * 3. Напишите метод printStudents(List<Student> students, int course),
         * который получает список студентов и номер курса.
         * 4. Напечатат на консоль имена тех студентов из списка, которые обучаются на данном курсе.
         */

        studentAdd(students); // добавляем студентов в коллекцию
        System.out.println(students);
        printStudents(students, 2); //Напишите метод printStudents(List<Student> students, int course)
        studentsRemove(students); //Написать метод, который удаляет студентов со средним баллом <3
        studentsCurs(students); //Если средний балл>=3, студент переводится на следующий курс
        System.out.println(students);
    }

    //Напишите метод printStudents(List<Student> students, int course) (Task 2)
    private static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCurs() == course) {
                System.out.println("Студент " + s.getName() + " учится на " + course + " курсе.");
            }
        }
    }

    //Если средний балл>=3, студент переводится на следующий курс (Task 2)
    private static void studentsCurs(Set<Student> students) {
        Set<Student> s2 = new HashSet<>();
        for (Student s : students) {
            if (s.getAvg() >= 3) {
                s2.add(new Student(s.getName(), s.getGruppa(), s.getCurs() + 1, s.getAvg()));
            }
        }
        students.removeIf(x -> x.getAvg() >= 3);
        students.addAll(s2);
    }


    //Написать метод, который удаляет студентов со средним баллом <3 (Task 2)
    private static void studentsRemove(Set<Student> students) {
        students.removeIf(x -> x.getAvg() < 3);
    }

    // добавляем студентов в коллекцию (Task 2)
    private static void studentAdd(Set<Student> students) {
        students.add(new Student("Bob", "12", 2, 7.5));
        students.add(new Student("John", "11", 1, 2.5));
        students.add(new Student("Robert", "13", 3, 2.8));
        students.add(new Student("Kate", "12", 2, 2.7));
        students.add(new Student("Boris", "14", 4, 4.2));
    }


    //Перебрать и распечатать значения продуктов - values() (Task 1)
    private static void toesValues(Map<String, Product> toes) {
        for (Map.Entry<String, Product> t : toes.entrySet()) {
            System.out.print(t.getValue().getCount() + " ");
        }
        System.out.println();
    }

    //Перебрать и распечатать набор из имен продуктов  - keySet() (Task 1)
    private static void toesKeySet(Map<String, Product> toes) {
        for (Map.Entry<String, Product> t : toes.entrySet()) {
            System.out.print(t.getValue().getType() + " ");
        }
        System.out.println();
    }

    //Перебрать и распечатать пары значений - entrySet() (Task 1)
    private static void toesEntry(Map<String, Product> toes) {
        for (Map.Entry<String, Product> t : toes.entrySet()) {
            System.out.println("Toes : " + t);
        }
    }

    // Заполняем MAP (Task 1)
    private static void toesPut(Map<String, Product> toes) {
        toes.put("car", new Product("audi", 10));
        toes.put("doll", new Product("Barbi", 12));
        toes.put("puzzles", new Product("sity", 5));
        toes.put("board games", new Product("yno", 18));
    }

    // перебор Мар с помощью While (Task 0)
    private static void employeeWhile(Map<String, Integer> employee) {
        Iterator<Map.Entry<String, Integer>> e1 = employee.entrySet().iterator();
        while (e1.hasNext()) {
            Map.Entry<String, Integer> e2 = e1.next();
            System.out.println("Name: " + e2.getKey() + ", Id: " + e2.getValue());
        }
    }

    //улучшенный цикл For (Task 0)
    private static void employeeForEach(Map<String, Integer> employee) {
        for (Map.Entry<String, Integer> e : employee.entrySet()) {
            System.out.println("Name: " + e.getKey() + ", Id: " + e.getValue());
        }
    }

    //заполняем Map<String, Integer> employee (Task 0)
    private static void employeeAdd(Map<String, Integer> employee) {
        employee.put("Bob", 555);
        employee.put("John", 235);
        employee.put("Robert", 110);
        employee.put("Bill", 99);
        employee.put("Willy", 347);
    }
}
