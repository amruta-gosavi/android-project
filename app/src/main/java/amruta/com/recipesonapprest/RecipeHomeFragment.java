package amruta.com.recipesonapprest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;

import amruta.com.recipesonapprest.model.RecipeList;

import static android.R.attr.data;

/**
 * Created by AMRUTA on 8/17/16.
 *
 * This fragment class inflates recyclerView and shows recipe data fetched from server.
 */

public class RecipeHomeFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    RecyclerView recyclerView;


    public static RecipeHomeFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        RecipeHomeFragment fragment = new RecipeHomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }


    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
    }


    public void UpdateAdapter(RecipeList recipeList) {
        if (recipeList != null) {
            recyclerView.setAdapter(new RecipeListAdapter(recipeList));
        }
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_page, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recipe_list);

        //loading from server
        Log.d("LOG", "RecipeHomeFragment:onCreateView: Data from server :" + data);
        MainActivity activity = (MainActivity) getActivity();
        RecipeList data = activity.getMyData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecipeListAdapter(data));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Log.d("LOG", "RecipeHomeFragment: Data from server :DataPasser" + data);

        //UpdateAdapter(data);

        return recyclerView;
    }

    class RecipeListAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
        private final RecipeList recipeDetailsList;

        RecipeListAdapter(RecipeList recipeDetailsList) {
            this.recipeDetailsList = recipeDetailsList;
        }

        @Override
        public RecipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            final LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            final View v = layoutInflater.inflate(R.layout.recipe_card, viewGroup, false);
            return new RecipeViewHolder(v);
        }


        @Override
        public void onBindViewHolder(RecipeViewHolder recipeViewHolder, int i) {
            recipeViewHolder.recipeTitle.setText(recipeDetailsList.getRecipes()[i].getTitle());
            recipeViewHolder.recipeSource.setText(recipeDetailsList.getRecipes()[i].getSource_url());


            try {
                Log.d("LOG", "RecipeHomeFragment:onBindViewHolder");
                Picasso.with(getContext())
                        .load(recipeDetailsList.getRecipes()[i].getImage_url())
                        .resize(0, 325)
                        .into((ImageView) recipeViewHolder.itemView.findViewById(R.id.recipe_image));


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        @Override
        public int getItemCount() {
            return recipeDetailsList.getCount();
        }
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView recipeTitle;
        ImageView recipeImage;
        TextView recipeSource;

        RecipeViewHolder(View itemView) {
            super(itemView);
            recipeTitle = (TextView) itemView.findViewById(R.id.recipe_title);
            recipeImage = (ImageView) itemView.findViewById(R.id.recipe_image);
            recipeSource = (TextView) itemView.findViewById(R.id.src_url);

        }
    }


}