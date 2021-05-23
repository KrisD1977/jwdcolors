package pl.edu.wszib.jwd.jwdcolors.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.jwd.jwdcolors.model.SelectedColor;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SelectedColorDaoTest {

    public static final String COLOR_BLUE = "blue";
    public static final String COLOR_RED = "red";
    public static final int TOTAL_COLORS = 3;

    @Autowired
    SelectedColorDao selectedColorDao;

    @BeforeEach
    void setUp() {
        SelectedColor selectedColor1 = new SelectedColor(COLOR_BLUE, new Date());
        SelectedColor selectedColor2 = new SelectedColor(COLOR_RED, new Date());
        SelectedColor selectedColor3 = new SelectedColor(COLOR_RED, new Date());

        assertNull(selectedColor1.getId());
        assertNull(selectedColor2.getId());
        assertNull(selectedColor3.getId());

        selectedColorDao.save(selectedColor1);
        selectedColorDao.save(selectedColor2);
        selectedColorDao.save(selectedColor3);

        assertNotNull(selectedColor1.getId());
        assertNotNull(selectedColor2.getId());
        assertNotNull(selectedColor3.getId());



    }

    @Test
    void testFetchData() {
        SelectedColor selectedColor = selectedColorDao.findFirstByColor(COLOR_RED);
        assertEquals(COLOR_RED, selectedColor.getColor(), "znaleziono nieprawidłowy kolor");

    }

    @Test
    void testFetchAllData() {
        Collection selectedColors = (Collection)selectedColorDao.findAll();
        assertEquals(TOTAL_COLORS, selectedColors.size(), "nieprwidłowa liczba kolorów");
    }
}
