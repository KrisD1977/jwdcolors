package pl.edu.wszib.jwd.jwdcolors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.jwd.jwdcolors.dao.SelectedColorDao;
import pl.edu.wszib.jwd.jwdcolors.model.SelectedColor;

import java.util.Date;

@Service
public class SelectedColorServiceImpl implements SelectedColorService {

    @Autowired
    SelectedColorDao selectedColorDao;

    @Override
    public void save(SelectedColor selectedColor) {
        /*selectedColorDao.save(selectedColor);*/
        save(selectedColor.getColor());
    }

    @Override
    public void save(String color) {
        selectedColorDao.save(new SelectedColor(color, new Date()));
    }

    @Override
    public Iterable<SelectedColor> getAllData() {
        return selectedColorDao.findAll();
    }
}
