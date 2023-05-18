/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.ItemRepository;
import java.util.List;
import java.util.stream.Collectors;
import model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Pedro
 */
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getTitles(Double rating) {
        List<Item> items = itemRepository.findItemsWithAverageRatingLowerThan(rating);
        return items.stream().map(Item::getTitle).collect(Collectors.toList());
    }
}
