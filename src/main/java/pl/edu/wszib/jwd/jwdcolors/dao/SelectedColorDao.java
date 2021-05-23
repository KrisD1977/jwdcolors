package pl.edu.wszib.jwd.jwdcolors.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.jwdcolors.model.SelectedColor;

@Repository
public interface SelectedColorDao extends CrudRepository<SelectedColor, Integer> {
    SelectedColor findFirstByColor(String color);

}
