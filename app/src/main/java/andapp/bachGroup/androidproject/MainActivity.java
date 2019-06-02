package andapp.bachGroup.androidproject;

import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ASyncTaskResponse {

    private RecyclerView theRecyclerView;
    private RecyclerView.Adapter theAdapter;
    private RecyclerView.LayoutManager theLayoutManager;
    private Random random;

    private ArrayList<Result> intArray;
    private ArrayList<Image> imageArrayList;
    private Thread thread;

    private volatile boolean isThreadRunning;
    private Retrofit retrofit;
    private String url = "https://api.themoviedb.org/";
    private WebService movieService;

    private LoadMovieTask loadmovie = new LoadMovieTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();

        loadmovie.aResponse = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


       // retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

      //  movieService = retrofit.create(WebService.class);

       theRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        theRecyclerView.setHasFixedSize(true);

        theLayoutManager = new GridLayoutManager(this, 2);
        theRecyclerView.setLayoutManager(theLayoutManager);

        intArray = new ArrayList<>();

        Result e = new Result();
        List<Movie> movies = new ArrayList<>();
        Movie m = new Movie();
        m.setTitle("petra");
        movies.add(m);
      //  m.setTitle("benny");
        //movies.add(m);
        e.setMovies(movies);
        intArray.add(e);

        //thread = new Thread(new Runnable() {
          //  @Override
            //public void run() {

              //      Call<Result> movies = movieService.loadMovies();
                //    try {
        //      intArray.add(movies.execute().body());
          //              System.out.println(intArray.get(0).toString());
            //        } catch (IOException e) {
              //          e.printStackTrace();

               // }
           // }
      //  });
       // thread.start();
         theAdapter = new MovieAdapter(intArray);
         theRecyclerView.setAdapter(theAdapter);
        // theAdapter.notifyDataSetChanged();




    }

    private ArrayList<Integer> generateIntegerArrayList(int amount){
        ArrayList<Integer> radom = new ArrayList<>();
        for (int i = 0; i<amount; i++){
            radom.add(random.nextInt(10000));
        }
        return radom;
    }

    private ArrayList<Image> fetchImages(){
        ArrayList<Image> temp = new ArrayList<>();


        return temp;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buttonClick(View view) {
        loadmovie.execute(url);
    }

    @Override
    public void response(ArrayList<Result> rc) {
        intArray.addAll(rc);
        theAdapter.notifyDataSetChanged();
    }
}
