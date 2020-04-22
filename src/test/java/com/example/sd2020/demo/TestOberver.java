package com.example.sd2020.demo;

import com.example.sd2020.demo.entity.Admin;
import com.example.sd2020.demo.service.EchipamentService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOberver {

    @Test
    public void testObserver() {
        Admin observer = new Admin();
        EchipamentService echipService = new EchipamentService();

        echipService.addObserver(observer);
        echipService.inchiriazaEchipament(Long.valueOf(48),Long.valueOf(51));
        assertEquals(observer.getNews(), "Echipamentul cu id-ul:51 a fost inchiriat de catre clientul cu numele Darius");
    }
}
