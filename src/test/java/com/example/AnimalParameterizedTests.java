package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(Parameterized.class)
public class AnimalParameterizedTests {


    private final String animalKind; // Тип животного
    private final List<String> expectedListOfFood; // список еды для данного типа животного


    public AnimalParameterizedTests(String animalKind, List<String> expectedListOfFood) {
        this.animalKind = animalKind; // Инициализируем тип животного
        this.expectedListOfFood = expectedListOfFood; // Инициализируем ожидаемый список еды
    }

    // возвращаем параметры для тестов
    @Parameterized.Parameters(name = "Класс Animal. Тип животного: {0}")
    public static Object[][] setParamsForTest() {
        return new Object[][] {

                {"Хищник", List.of("Животные", "Птицы", "Рыба")}, // Параметры для хищника
                {"Травоядное", List.of("Трава", "Различные растения")} // Параметры для травоядного
        };
    }

    // проверяем правильность возвращаемого списка еды
    @Test
    public void getFoodIsCorrect() throws Exception {
        // Сравниваем ФР с ОР
        MatcherAssert.assertThat("Неправильный набор еды",
                new Animal().getFood(animalKind), // Вызываем метод getFood() с типом животного
                equalTo(this.expectedListOfFood) // Сравниваем с ожидаемым списком еды
        );
    }
}