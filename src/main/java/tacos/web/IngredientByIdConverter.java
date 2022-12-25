package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.Ingredient;
import tacos.IngredientUDT;
import tacos.data.IngredientRepository;

import java.util.Optional;


@Component
public class IngredientByIdConverter implements Converter<String, IngredientUDT> {
    private final IngredientRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public IngredientUDT convert(String id) {
        Ingredient target = ingredientRepo.findById(id).orElse(null);
        return new IngredientUDT(target.getName(), target.getType());
    }
}
