package com.autoria.data;

import org.testng.annotations.DataProvider;

public class DataForApiTests {
    public static class TestData {
        public String[] items;

        public TestData(String... items) {
            this.items = items;
        }

        public String get(int x) {
            return items[x];
        }
    }

    @DataProvider
    public Object[] dataForTestCities() {
        return new Object[][]{{new TestData("Винница", "Жмеринка", "Казатин", "Крыжополь", "Липовец", "Литин", "Могилев-Подольский", "Мурованые Куриловцы", "Немиров", "Оратов", "Песчанка", "Погребище", "Теплик", "Тывров", "Томашполь", "Тростянец", "Тульчин", "Хмельник", "Черновцы", "Чечельник", "Шаргород", "Ямполь", "Бар", "Бершадь", "Гайсин", "Ильинцы", "Калиновка", "Гнивань", "Ладыжин", "Якушинцы")},};
    }

    @DataProvider
    public Object[] dataOptions() {
        return new Object[][]{{new TestData("Бортовой компьютер", "Климат контроль", "Кондиционер", "Люк", "Подогрев зеркал", "Подогрев сидений", "Усилитель руля", "Сенсор дождя")},};
    }
}
