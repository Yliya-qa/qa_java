package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    Feline feline; // Создаем мок-объект для класса Feline

    // Тестируем метод getSound() класса Cat
    @Test
    public void getSoundIsCorrect() {
        String expectedString = "Мяу"; // Ожидаемое значение звука кота

        // Сравниваем фактический звук с ожидаемым значением
        MatcherAssert.assertThat("Кот мяукает не так",
                new Cat(feline).getSound(), // Создаем новый объект Cat и вызываем метод getSound()
                equalTo(expectedString) // Сравниваем с ожидаемым звуком
        );
    }

    // Тестируем метод getFood() класса Cat
    @Test
    public void getFoodIsCorrect() throws Exception {
        Cat cat = new Cat(feline); // Создаем новый объект Cat с мок-объектом Feline
        List<String> expectedListOfFood = List.of("Мясо"); // Ожидаемый список еды для кота

        // Настраиваем мок, чтобы метод eatMeat() возвращал ожидаемый список еды
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        // Сравниваем фактический список еды с ожидаемым
        MatcherAssert.assertThat("Вернулся некорректный список еды",
                cat.getFood(), // Вызываем метод getFood() кота
                equalTo(expectedListOfFood) // Сравниваем с ожидаемым списком еды
        );
    }
}