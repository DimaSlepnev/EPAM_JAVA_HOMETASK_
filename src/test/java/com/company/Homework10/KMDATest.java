package com.company.Homework10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.FeatureDescriptor;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class KMDATest {
String filepath1;
String filepath2;
String filepath3;
KMDA kmdaHelper;

    @BeforeEach
    void setUp() throws IOException {
        System.out.println("@Run Before");
        filepath1 = FileName.fileName1;
        filepath2 = FileName.fileName2;
        filepath3 = FileName.fileName3;
        kmdaHelper = new KMDA();
        kmdaHelper.GetUsersFromCSV(filepath1);
        kmdaHelper.GetUsersFromCSV(filepath2);
        kmdaHelper.GetUsersFromCSV(filepath3);
    }

    @AfterEach
    void tearDown() {
        System.out.println("@Run After");
    }

    @Test
    void maxSalary() {
            assertEquals(14763.0, kmdaHelper.MaxSalary());
    }

    @Test
    void getMinimumSalary() {
        assertEquals("[User{name='Кличко В. В.', post='Київський міський голова', salary=4720.0}\n" +
                "]", kmdaHelper.GetMinimumSalary().toString());
    }

    @Test
    void averageSalaryAnd20Percent() {
        assertEquals("[User{name='Кличко В. В.', post='Київський міський голова', salary=9768.0}\n" +
                ", User{name='Давтян Д. О.', post='Заступник голови КМДА', salary=12487.5}\n" +
                ", User{name='Мондриївський В. М.', post='Заступник голови КМДА', salary=13181.25}\n" +
                ", User{name='Непоп В. І.', post='Заступник голови КМДА', salary=13875.0}\n" +
                ", User{name='Пантелеєв П. О.', post='Заступник голови КМДА', salary=13181.25}\n" +
                ", User{name='Слончак В. В.', post='Заступник голови КМДА з питань здійснення самоврядних повноважень', salary=13875.0}\n" +
                ", User{name='Спасибко О. В.', post='Заступник голови КМДА', salary=12487.5}\n" +
                ", User{name='Хонда М. П.', post='Заступник голови КМДА з питань здійснення самоврядних повноважень', salary=13875.0}\n" +
                ", User{name='Поворозник М. Ю.', post='Перший заступник голови КМДА', salary=10500.0}\n" +
                ", User{name='Непоп В. І.', post='Заступник голови КМДА', salary=12500.0}\n" +
                ", User{name='Пантелеєв П. О.', post='Заступник голови КМДА', salary=10000.0}\n" +
                ", User{name='Слончак В. В.', post='Заступник голови КМДА з питань здійснення самоврядних повноважень', salary=10000.0}\n" +
                ", User{name='Спасибко О. В.', post='Заступник голови КМДА', salary=9343.75}\n" +
                ", User{name='Хонда М. П.', post='Заступник голови КМДА з питань здійснення самоврядних повноважень', salary=13125.0}\n" +
                ", User{name='2', post='Поворозник Микола Юрійович', salary=13965.0}\n" +
                ", User{name='3', post='Давтян Дмитро Олександрович', salary=13125.0}\n" +
                ", User{name='4', post='Мондриївський Валентин Миколайович', salary=13125.0}\n" +
                ", User{name='5', post='Непоп Вячеслав Іванович', salary=13125.0}\n" +
                ", User{name='6', post='Пантелеєв Петро Олександрович', salary=12468.75}\n" +
                ", User{name='7', post='Спасибко Олександр Валерійович', salary=13125.0}\n" +
                "]" , kmdaHelper.AverageSalaryAnd20Percent().toString());
    }

    @Test
    void averageSalarySeveralMonth() {
     assertEquals("[13054.83, 12493.94, 12020.28]", kmdaHelper.AverageSalarySeveralMonth());
    }
    @Test
    void maxAverageSalaryInMonth() {
        assertEquals("1", kmdaHelper.MaxAverageSalaryInMonth());
    }
}