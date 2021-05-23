package pl.edu.wszib.jwd.jwdcolors.service;

import pl.edu.wszib.jwd.jwdcolors.model.SelectedColor;

public interface SelectedColorService {
    void save(SelectedColor selectedColor);

    void save(String color);

    Iterable<SelectedColor> getAllData();

}
