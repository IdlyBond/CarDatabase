package constants;

public enum Lines {
    NON_CORRECT("* Некорректный ввод. "),
    WHAT_TO_CHANGE("* Выберите, что вы хотите изменить: "),
    CHANGE_OPTIONS("1 - VIN.\n" +
            "2 - Регистрационный код.\n" +
            "3 - Модель.\n" +
            "4 - Пробег.\n" +
            "5 - Год выпуска.\n" +
            "6 - Цена.\n" +
            "7 - Все параметры.\n"),
    CHOOSE_LINE ("* Выберите один из пунктов меню:"),
    MAIN_OPTIONS_LINE ("1 - Меню поиска.\n" +
            "2 - Занести в базу данные по новой машине.\n" +
            "3 - Редактирование информации о машине по VIN коду\n" +
            "4 - Удалить машину с базы по VIN коду.\n" +
            "0 - Назад\n" +
            "-1 - Выход из программы."),
    SEARCH_OPTIONS_LINE(" 1 - Поиск по VIN коду машины.\n" +
            " 2 - Поиск по регистрационному номеру машины.\n" +
            " 3 - Поиск по модели.\n" +
            " 4 - Поиск по пробегу.\n" +
            " 5 - Поиск по году выпуска.\n" +
            " 6 - Поиск по цене.\n" +
            " 7 - Отобразить список всех машин \n" +
            " 0 - назад."),
    CHANGE_OPTIONS_LINE(" 1 - Изменить VIN код машины.\n" +
            " 2 - Изменить регистрационный номер машины.\n" +
            " 3 - Изменить модель.\n" +
            " 4 - Изменить пробег.\n" +
            " 5 - Изменить год выпуска.\n" +
            " 6 - Изменить цену.\n" +
            " 0 - назад."),
    ENTER_VIN_CODE("* Введите VIN код: "),
    ENTER_REG_NUMBER("* Введите регестрационный код: "),
    ENTER_MODEL("* Введите марку и модель: "),
    ENTER_PATH("* Введите пробег: "),
    ENTER_YEAR("* Введите год выпуска: "),
    ENTER_PRICE("* Введите цену: "),
    DEFAULT_VIN_1("HCBUZTH63KLC859BZ"),
    DEFAULT_VIN_2("5CBU54ZTH63KLC855"),
    DEFAULT_VIN_3("MZBU4GBC3KLC859BZ"),
    DEFAULT_VIN_4("BZ5643GBC3KLC59BZ"),
    DEFAULT_REG_NUM_1("AB4654CV"),
    DEFAULT_REG_NUM_2("AC4644BF"),
    DEFAULT_REG_NUM_3("BY5684BF"),
    DEFAULT_REG_NUM_4("CC5674BF"),
    DEFAULT_MODEL_1("Camry"),
    DEFAULT_MODEL_2("Wagen"),
    DEFAULT_MODEL_3("Porsche"),
    DEFAULT_MODEL_4("Lada"),
    NO_CARS_FOUND("* В базе не существует такой машины. "),
    FOUND_CAR("* Машина была найдена: "),
    ZERO_TO_EXIT("* Для возврата в предыдущее меню введите цифру 0. ")
    ;

    private String line;

    Lines(String line) {
        this.line = line;
    }

    public String getLine(){
        return line;
    }

    @Override
    public String toString() {
        return line;
    }
}
