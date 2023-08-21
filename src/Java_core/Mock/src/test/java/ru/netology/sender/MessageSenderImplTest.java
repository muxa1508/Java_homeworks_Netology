package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderImplTest {
    protected LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
    protected GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
    protected MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);


    @Test
    void sendRussian() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        Mockito.when(geoService.byIp("172.")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        assertEquals("Добро пожаловать", messageSender.send(headers), "Проверка на вывод русского текста");
    }

    @Test
    void sendEnglish() {
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        Mockito.when(geoService.byIp("96.")).thenReturn(new Location("New York", Country.USA, null,  0));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        assertEquals("Welcome", messageSender.send(headers), "Проверка на вывод английского текста");
    }
}