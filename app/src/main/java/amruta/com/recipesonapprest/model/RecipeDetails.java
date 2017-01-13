package amruta.com.recipesonapprest.model;

import java.io.Serializable;

/**
 * Created by AMRUTA on 8/17/16.
 */

public class RecipeDetails implements Serializable
{
    private String publisher;
    private String image_url;
    private String title;
    private String source_url;
    private String recipe_id;
    private String social_rank;
    private String f2furl;
    private String publisher_url;


    public String getPublisher_url() {
        return publisher_url;
    }

    public void setPublisher_url(String publisher_url) {
        this.publisher_url = publisher_url;
    }

    public String getF2furl() {

        return f2furl;
    }

    public void setF2furl(String f2furl) {
        this.f2furl = f2furl;
    }

    public String getSocial_rank() {

        return social_rank;
    }

    public void setSocial_rank(String social_rank) {
        this.social_rank = social_rank;
    }

    public String getRecipe_id() {

        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getSource_url() {

        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public RecipeDetails()
    {

    }


}
