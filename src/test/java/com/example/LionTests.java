package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThrows;

// Указываем, что тесты будут запущены с использованием MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline; // Создаем мок-объект для класса Feline

    // Тестируем, что создание льва с некорректным полом выбрасывает IllegalArgumentException
    @Test
    public void createLionThrowsException() {
        // Проверяем, что выбрасывается IllegalArgumentException при создании льва с некорректным полом
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                new Lion(feline, "Не определено")
        );

        // Проверяем, что сообщение об ошибке соответствует ожидаемому
        MatcherAssert.assertThat(exception.getMessage(), equalTo("Используйте допустимые значения пола животного - самец или самка"));
    }

    // Тестируем метод getKittens() класса Lion
    @Test
    public void getKittensIsCorrect() throws Exception {
        Lion lion = new Lion(feline, "Самец"); // Создаем объект Lion с мок-объектом feline
        int expectedCount = 5; // Ожидаемое количество котят

        // Настраиваем мок, чтобы метод getKittens() возвращал ожидаемое количество котят
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);

        // Сравниваем фактическое количество котят с ожидаемым
        MatcherAssert.assertThat("Некорректное количество котят",
                lion.getKittens(), // Вызываем метод getKittens()
                equalTo(expectedCount) // Сравниваем с ожидаемым количеством
        );
    }

    // Тестируем метод getFood() класса Lion
    @Test
    public void getFoodIsCorrect() throws Exception {
        Lion lion = new Lion(feline, "Самец"); // Создаем объект Lion с мок-объектом feline
        List<String> expectedListOfFood = List.of("Пища"); // Ожидаемый список еды

        // Настраиваем мок, чтобы метод eatMeat() возвращал ожидаемый список еды
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        // Сравниваем фактический список еды с ожидаемым
        MatcherAssert.assertThat("Некорректный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood) // Сравниваем с ожидаемым списком еды
        );
    }
}