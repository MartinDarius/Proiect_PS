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
        echipService.setInchiriat("80");
        assertEquals(observer.getNews(), "Echipamentul cu id-ul:80 a fost inchiriat.");
    }
}
