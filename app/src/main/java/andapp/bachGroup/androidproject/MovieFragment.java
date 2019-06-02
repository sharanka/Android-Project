package andapp.bachGroup.androidproject;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovieFragment extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment_event", "MovieListFragment onAttach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment_event", "MovieListFragment onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment_event", "MovieListFragment onStart");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fragment_event", "MovieListFragment onActivityCreated");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("fragment_event", "MovieListFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentview, container,false);
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment_event", "MovieListFragment onDestroyView");
    }

    @Override
    public void onPause() {
        //DO NOTHING
        super.onPause();
        Log.i("fragment_event", "MovieListFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment_event", "MovieListFragment onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_event", "MovieListFragment onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment_event", "MovieListFragment onDestroy");
    }
}
