package E3;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class JSonAnalyzer {
    private static ArrayList<Category> listCategories = new ArrayList();
    
    public static String getJSonData(String url){
        String urlToCall = url;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlToCall).build();
        try (Response response = client.newCall(request).execute()) {
                if(response.isSuccessful() && response.body() != null) {
                        String responseString =  response.body().string();
                        return responseString;
                }
        } catch (IOException e) {
                e.printStackTrace();
               return null;
        }
        return null;
    }
    
    
    public static ArrayList<Meal> getInformationAboutMeals(String jsonMealData, String category){  
        ArrayList<Meal> list = new ArrayList();
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(jsonMealData);

        JsonObject object = jsonTree.getAsJsonObject();
        JsonElement elem = object.get("meals");
        if(elem.toString().equals("null"))
            return list;
        JsonArray jsonArray = object.getAsJsonArray("meals");
        for(int i=0;i<jsonArray.size();i++){
            Meal newMeal = new Meal();
            String idOfMeal = null;
            String mealName = null;
            String mealCategory = null;
            String mealArea = null;
            String mealInstructions = null;
            for(Map.Entry<String, JsonElement> entry: jsonArray.get(i).getAsJsonObject().entrySet()) {
                String ek = entry.getKey();
                if(ek.equals("idMeal"))
                    idOfMeal = entry.getValue().getAsString();
                else if(ek.equals("strMeal"))
                    mealName = entry.getValue().getAsString();
                else if(ek.equals("strCategory"))
                    mealCategory = entry.getValue().getAsString();
                else if(ek.equals("strArea")) 
                    mealArea = entry.getValue().getAsString();                   
                else if(ek.equals("strInstructions"))
                    mealInstructions = entry.getValue().getAsString();                 
            }
            if(mealCategory == null)
                mealCategory = category;
            newMeal.setMealId(Integer.parseInt(idOfMeal));
            newMeal.setStrmeal(mealName);
            newMeal.setCategory(MainClass.getCategoryId(mealCategory));
            newMeal.setStrarea(mealArea);
            newMeal.setStrinstuctions(mealInstructions);
            list.add(newMeal);
       }
       return list;    
    }
    
    public static ArrayList<Category> getInformationAboutCategory(String jsonCatData){
        listCategories = new ArrayList();
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(jsonCatData);
        JsonObject obj = jsonTree.getAsJsonObject();
        JsonArray jsonArray = obj.getAsJsonArray("meals");
        for(int i=0;i<jsonArray.size();i++){
            Category category = new Category();
            String cat = jsonArray.get(i).getAsJsonObject().get("strCategory").getAsString();
            category.setName(cat);
            listCategories.add(category);
        }
        return listCategories;
    } 
}