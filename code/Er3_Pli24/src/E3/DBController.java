package E3;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class DBController {
    public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Er3_2023PU");
    public static EntityManager manager = factory.createEntityManager();
    
    /**
     * Αποθήκευση αντικειμένου
     * @param o
     * @return 
     */
    public static boolean saveObject(Object o){
    try{
        manager.getTransaction().begin();
        manager.persist(o);
        manager.getTransaction().commit();
        return true;
    }catch(Exception e){
        System.out.println("Σφάλμα κατά την αποθήκευση δεδομένων");
        manager.getTransaction().rollback();
        return false;
    }
    }
    
    /**
     * Έλεγχος αν υπάρχει ένα γεύμα
     * @param meal
     * @return 
     */
    public static Meal mealExists(Meal meal){
        TypedQuery<Meal> query = DBController.manager.createNamedQuery("Meal.findByStrmeal", Meal.class);
        query.setParameter("strmeal", meal.getStrmeal());
        List<Meal> res = query.getResultList();
        if(res.isEmpty())
            return null;
        else
            return res.get(0);
    }
    
    /**
     * Αποθήκευση λίστας κατηγοριών
     * @param list 
     */
    public static void saveCategories(ArrayList<Category> list){
        try{
            manager.getTransaction().begin();
            for(Category cat:list){
                if(categoryExists(cat) == null){
                    manager.persist(cat);
                }
            } 
            manager.getTransaction().commit();
        }catch(Exception e){
            manager.getTransaction().rollback();
            System.out.println("Σφάλμα κατά την αποθήκευση.");
        }
    }
    
    /**
     * Διαγραφή όλων των κατηγοριών
     */
    public static void deleteCategories(){
        try {
            manager.getTransaction().begin();
            Query query = manager.createNativeQuery("DELETE FROM CATEGORY");
            query.executeUpdate();
            manager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Σφάλμα κατά τη διαγραφή");
            manager.getTransaction().rollback();
        }
    }
    
    /**
     * Αποθήκευση λίστας γευμάτων
     * @param data 
     */
    public static void storeMeals(ArrayList<Meal> data){
        try{
            manager.getTransaction().begin();
            for(Meal meal:data){
                // Έλεγχος αν υπάρχουν 
                if(mealExists(meal) == null){
                    manager.persist(meal);
                }
            }
            manager.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Σφάλμα κατά την αποθήκευση");
            manager.getTransaction().rollback();
        }
    }
    
    /**
     * Έλεγχος αν υπάρχει η κατηγορία αποθηκευμένη στη ΒΔ
     * @param category
     * @return η κατηγορία
     */
    public static Category categoryExists(Category category){
        TypedQuery<Category> query = DBController.manager.createNamedQuery("Category.findByName", Category.class);
        query.setParameter("name", category.getName());
        List<Category> results = query.getResultList();
        if(results.isEmpty()){
            return null;
        }else{
            return results.get(0);
        }
    }
    
    /**
     * Διαγραφή αντικειμένου από τη ΒΔ
     * @param o 
     */
    public static void deleteObject(Object o){
        try{
            manager.getTransaction().begin();
            manager.remove(o);
            manager.getTransaction().commit();
        }catch (Exception exc){
            manager.getTransaction().rollback();
            System.out.println(exc);
        }
    }
    
    /**
     * Τροποποίηση κάποιου αντικειμένου 
     * @param o
     * @return 
     */
    public static boolean modifyObject(Object o){
        try{
            manager.getTransaction().begin();
            manager.merge(o);
            manager.getTransaction().commit();
            return true;
        }catch(Exception e){
            System.out.println("Σφάλμα κατά την αποθήκευση των δεδομένων στη Β.Δ.");
            manager.getTransaction().rollback();
            return false;
        }
    }
    
    /**
     * Επιστροφή όλων των γευμάτων
     * @return 
     */
    public static ArrayList<Meal> getMeals(){
        TypedQuery<Meal> q = DBController.manager.createNamedQuery("Meal.findAll", Meal.class);
        return new ArrayList(q.getResultList());
    }
    
}
