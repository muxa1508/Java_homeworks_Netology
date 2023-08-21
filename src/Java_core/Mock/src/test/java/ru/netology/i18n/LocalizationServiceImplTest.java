package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    protected Country country;
    protected LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

    @Test
    void localeRussian() {
        country = Country.RUSSIA;
        String localizationServiceText = localizationService.locale(country);
        String testText = "Добро пожаловать";
        assertEquals(testText, localizationServiceText);
    }

    @Test
    void localeEnglish() {
        country = Country.USA;
        String localizationServiceText = localizationService.locale(country);
        String testText = "Welcome";
        assertEquals(testText, localizationServiceText);
    }
}