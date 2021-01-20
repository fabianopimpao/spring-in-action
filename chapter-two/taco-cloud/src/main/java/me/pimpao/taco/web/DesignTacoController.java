package me.pimpao.taco.web;

import me.pimpao.taco.Ingredient;
import me.pimpao.taco.Taco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static me.pimpao.taco.Ingredient.Type;

@Controller
@RequestMapping(path = "/design")
public class DesignTacoController {

    private static final Logger log = LoggerFactory.getLogger(DesignTacoController.class);

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
           new Ingredient("FLTO", "Tortilla", Type.WRAP),
           new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
           new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
           new Ingredient("CARN", "Carnitas", Type.PROTEIN),
           new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
           new Ingredient("LETC", "Lettuce", Type.VEGGIES),
           new Ingredient("CHED", "Cheddar", Type.CHEESE),
           new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
           new Ingredient("SLSA", "Salsa", Type.SAUCE),
           new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("design", new Taco());

        return "design";
    }

    @PostMapping
    public String processDesign(Taco design) {
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }

}
