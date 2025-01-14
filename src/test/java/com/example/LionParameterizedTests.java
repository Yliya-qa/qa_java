package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.hamcrest.CoreMatchers.equalTo;


@RunWith(Parameterized.class)
public class LionParameterizedTests {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule(); // Создаем правило Mockito для управления жизненным циклом моков

    @Mock
    Feline feline; // Создаем мок-объект для класса Feline, который будет использоваться в тестах

    private final String sex; // Пол льва
    private final boolean hasMane; // Наличие гривы для льва


    public LionParameterizedTests(String sex, boolean hasMane) {
        this.sex = sex; // Инициализируем пол льва
        this.hasMane = hasMane; // Инициализируем наличие гривы
    }

    // Метод, который возвращает параметры для тестов
    @Parameterized.Parameters(name = "Класс Lion. Пол: {0}")
    public static Object[][] setSexForLion() {
        return new Object[][] {

                {"Самец", true}, // Параметры для самца
                {"Самка", false}, // Параметры для самки
        };
    }


    @Test
    public void doesHaveManeIsCorrect() throws Exception {
        // Создаем объект Lion с мок-объектом feline и заданным полом
        Lion lion = new Lion(feline, this.sex);

        // Сравниваем фактическое наличие гривы с ожидаемым значением
        MatcherAssert.assertThat("Грива есть только у льва",
                lion.doesHaveMane(), // Вызываем метод doesHaveMane()
                equalTo(hasMane) // Сравниваем с ожидаемым значением наличия гривы
        );
    }
}