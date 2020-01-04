package lesson3.basic_collections.phonebook;

public class Main {
    /**
     *  Написать простой класс PhoneBook(внутри использовать HashMap):
     *   - В качестве ключа использовать фамилию
     *   - В каждой записи всего два поля: phone, e-mail
     *   - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
     *   и отдельный метод для поиска e-mail по фамилии.
     *   Следует учесть, что под одной фамилией может быть несколько записей.
     *   Итого должно получиться 3 класса Main, PhoneBook, Person.
     */

    public static void main(String[] args) {
        PhoneBook myBook = new PhoneBook();
        myBook.setPerson("Ivanov", new Person( "111111", "111111@ya.ru"));
        myBook.setPerson("Petrov", new Person("222222", "222222@ya.ru"));
        myBook.setPerson("Sidorov", new Person( "333333", "333333@ya.ru"));
        myBook.setPerson("Kozlov", new Person( "444444", "444444@ya.ru"));
        myBook.setPerson("Zaytsev", new Person( "555555", "555555@ya.ru"));
        myBook.setPerson("Ivanov", new Person( "666666", "666666@ya.ru"));

        System.out.println(myBook.getPersonPhone("Ivanov"));
        System.out.println(myBook.getPersonEmail("Ivanov"));
        System.out.println(myBook.getPersonPhone("Bobrov"));
        System.out.println(myBook.getPersonEmail("Bobrov"));
    }
}
