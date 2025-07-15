package com.example.pms.service;

import com.example.pms.model.Category;
import com.example.pms.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final Map<Long, Item> catalog = new ConcurrentHashMap<>();

    public ItemService() {
        // seed 3 items per category (IDs 1‑15)
        long id = 1;
        catalog.put(id,   new Item(id++, "Atta 5Kg       250Rs/-",   "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/da/cms-assets/cms/product/57aa51c9-0a42-4cb9-8173-f40bf3505703.png", Category.GROCERIES,250));
        catalog.put(id,   new Item(id++, "Rice 10Kg      500Rs/-",   "https://www.jiomart.com/images/product/original/493073264/good-life-arwa-katarni-rice-10-kg-product-images-o493073264-p596878369-0-202301030205.jpg?im=Resize=(360,360)", Category.GROCERIES,500));
        catalog.put(id,   new Item(id++, "Oil 1L         150Rs/-",     "https://content.jdmagicbox.com/quickquotes/images_main/organic-refined-oil-jar-801835876-9cjkd4vh.jpg?impolicy=queryparam&im=Resize=(360,360),aspect=fit", Category.GROCERIES,150));

        catalog.put(id,   new Item(id++, "Apples         300Rs/-",      "https://img500.exportersindia.com/product_images/bc-500/dir_35/1045864/fresh-fuji-apples-157639.jpg", Category.FRUITS_VEGETABLES,300));
        catalog.put(id,   new Item(id++, "Tomatoes       35Rs/-",    "https://png.pngtree.com/thumb_back/fh260/background/20250408/pngtree-realistic-red-tomatoes-with-natural-gloss-for-salad-designs-organic-recipe-image_17175249.jpg", Category.FRUITS_VEGETABLES,35));
        catalog.put(id,   new Item(id++, "Carrots        45Rs/-",     "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTB_NHm3vuWCxaXpqLrFCZU0JBbH18EIwG_FA&s", Category.FRUITS_VEGETABLES,45));

        catalog.put(id,   new Item(id++, "Paracetamol    27Rs/-", "https://content.jdmagicbox.com/quickquotes/images_main/paracetamol-bp-500-mg-387583774-x8ous.jpg?impolicy=queryparam&im=Resize=(360,360),aspect=fit", Category.MEDICALS,27));
        catalog.put(id,   new Item(id++, "Bandage        160Rs/-",     "https://t4.ftcdn.net/jpg/13/72/03/75/360_F_1372037559_chDSclPJcxEjIibq7RANCMu7cGaxJzFX.jpg", Category.MEDICALS,160));
        catalog.put(id,   new Item(id++, "Vitamins       300Rs/-",    "https://content.jdmagicbox.com/quickquotes/images_main/multivitamin-supplement-delicious-chocolate-flavor-tablet-802773633-mwfxb0hr.jpg?impolicy=queryparam&im=Resize=(360,360),aspect=fit", Category.MEDICALS,300));

        catalog.put(id,   new Item(id++, "Lego Set       800Rs/-",    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST0jaurHgLh0H9nOqxgWia6E5cqLboov8TFg&s", Category.TOYS,800));
        catalog.put(id,   new Item(id++, "Teddy Bear     700Rs/-",  "https://content.jdmagicbox.com/quickquotes/images_main/-12qu5y9o.jpg?impolicy=queryparam&im=Resize=(360,360),aspect=fit", Category.TOYS,700));
        catalog.put(id,   new Item(id++, "RC Car         600Rs/-",      "https://kipagaming.com/cdn/shop/files/1_c4135f03-7b34-4e41-a6de-518451552495.jpg?v=1746599782&width=360", Category.TOYS,600));

        catalog.put(id,   new Item(id++, "T‑Shirt        250Rs/-",     "https://mms-images-prod.imgix.net/mms/images/catalog/d1eddda521a0747fa7f1ff636edba3c6/categories/83.jpg?ixlib=rails-2.1.4&w=360&h=360&sharp=10&q=85&dpr=1&trim=auto&trimmd=0&fit=fill&bg=ffffff&fm=pjpg&auto=format", Category.CLOTHES,250));
        catalog.put(id,   new Item(id++, "Jeans          300Rs/-",       "https://img.freepik.com/free-photo/jeans_1203-8094.jpg?w=360", Category.CLOTHES,300));
        catalog.put(id,   new Item(id,   "Jacket         2000Rs/-",      "https://t4.ftcdn.net/jpg/13/84/66/53/360_F_1384665315_XKEAl7HUAMx2FAp9rB6TPC8YL3mmWUC6.jpg", Category.CLOTHES,200));
    }

    public List<Item> getByCategory(Category category) {
        return catalog.values().stream()
                .filter(it -> it.getCategory() == category)
                .limit(3) // exactly 3 per requirements
                .collect(Collectors.toList());
    }

    public Item findById(Long id) { return catalog.get(id); }
}