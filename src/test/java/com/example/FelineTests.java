package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class FelineTests {


    @Test
    public void getFamilyIsCorrect() {
        String expectedFelineFamilyName = "Кошачьи"; // Ожидаемое название семейства кошачьих

        // Сравниваем фактическое название семейства с ожидаемым
        MatcherAssert.assertThat("Некорректное название семейства кошачьих",
                new Feline().getFamily(), // Создаем новый объект Feline
                equalTo(expectedFelineFamilyName) // Сравниваем с ожидаемым названием
        );
    }


    @Test
    public void getKittensInputCountIsCorrect() {
        int expectedCount = 5; // Ожидаемое количество котят

        // Сравниваем фактическое количество котят с ожидаемым
        MatcherAssert.assertThat("Некорректное количество котят",
                new Feline().getKittens(expectedCount), // Вызываем метод getKittens() с заданным количеством котят
                equalTo(expectedCount) // Сравниваем с ожидаемым количеством
        );
    }


    @Test
    public void getKittensDefaultIsCorrect() {
        int expectedCount = 1; // Ожидаемое количество котят по умолчанию

        // Сравниваем фактическое количество котят с ожидаемым
        MatcherAssert.assertThat("Некорректное количество котят",
                new Feline().getKittens(),
                equalTo(expectedCount) // Сравниваем с ожидаемым количеством по умолчанию
        );
    }


    @Test
    public void eatMeatIsCorrect() throws Exception {
        Feline feline = new Feline(); // Создаем новый объект Feline

        // Сравниваем фактический список еды с ожидаемым списком еды для хищника
        MatcherAssert.assertThat("Неправильный список еды",
                feline.eatMeat(),
                equalTo(feline.getFood("Хищник")) // Сравниваем с результатом вызова getFood("Хищник")
        );
    }
}