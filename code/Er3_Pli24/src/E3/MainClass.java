package E3;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;


public class MainClass {
    public static ArrayList<Category> listOfCategories;
    
    public static void main(String[] args) {
        String url = "https://www.themealdb.com/api/json/v1/1/list.php?c=list";
        String jsonCategories = JSonAnalyzer.getJSonData(url);
        listOfCategories = JSonAnalyzer.getInformationAboutCategory(jsonCategories);
        for(Category category:listOfCategories){
            Category ctg = DBController.categoryExists(category);
            if(ctg == null){
                DBController.saveObject(category);
            } else {
                listOfCategories.set(listOfCategories.indexOf(category), ctg);
            }
        }
        MainGUI frame = new MainGUI();
        frame.setTitle("Easy Cooking");
        frame.setLocation(150,150);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    /**
     * Επιστρέφει το id μίας κατηγορίας
     * @param catstr η κατηγορία
     * @return to id
     */
    public static int getCategoryId(String catstr){
        TypedQuery<Category> query = DBController.manager.createNamedQuery("Category.findByName", Category.class);
        query.setParameter("name", catstr);
        List<Category> res = query.getResultList();
        return res.get(0).getId();
    }
    
    /**
     * ΕΠιστρέφει το όνομα μίας κατηγορίας
     * @param id
     * @return 
     */
    public static String getCategoryName(int id){
        TypedQuery<Category> q = DBController.manager.createNamedQuery("Category.findById", Category.class);
        q.setParameter("id", id);
        List<Category> res = q.getResultList();
        return res.get(0).getName();
    }
    
}
