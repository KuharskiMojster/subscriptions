package si.kuharskimojster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import si.kuharskimojster.repositories.RecipeRepository;

import java.util.List;

@Service
public class RecipeService{

    @Autowired
    private RecipeRepository recipeRepository;

    @Transactional(readOnly = true)
    public List<Long> getUsereSubscriptions(Long userId){
        return (List<Long>) recipeRepository.getUsersSubscriptions(userId);
    }

}
