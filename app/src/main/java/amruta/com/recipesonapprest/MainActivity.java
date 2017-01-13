package amruta.com.recipesonapprest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.astuetz.PagerSlidingTabStrip;

import java.io.IOException;

import amruta.com.recipesonapprest.httpclient.RecipeHttpClient;
import amruta.com.recipesonapprest.model.RecipeList;

public class MainActivity extends AppCompatActivity {


    PagerSlidingTabStrip tabsStrip;
    RecipeList recipeList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager()));

        // Give the PagerSlidingTabStrip the ViewPager
        tabsStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);

        // Attach the page change listener to tab strip and **not** the view pager inside the activity
        tabsStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {

            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });


        try {

            recipeList = new DownloadImagesTask().execute("").get();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public RecipeList getMyData() {

        return recipeList;
    }


    private class DownloadImagesTask extends AsyncTask<String, Void, RecipeList> {

        @Override
        protected RecipeList doInBackground(String... params) {

            RecipeList recipeDetailsArrayList = null;

            try {
                Thread.sleep(1000);

                RecipeHttpClient recipeHttpClient = new RecipeHttpClient("http://food2fork.com/api/search", "51152b2219c8471c51efb231ff9c5fbd");
                try {
                    recipeDetailsArrayList = recipeHttpClient.getRecipeList("potato", 1, "r");


                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return recipeDetailsArrayList;
        }

        @Override
        protected void onPostExecute(RecipeList result) {
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }

    }


}
