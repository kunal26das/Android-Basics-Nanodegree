package kunal26das.musicalstructureapp.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.Picasso;

import kunal26das.musicalstructureapp.R;
import kunal26das.musicalstructureapp.adapter.CustomObject;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private NavController navController;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.musicFragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
            NavigationUI.setupActionBarWithNavController(this, navController);
        }

        final AppCompatImageView albumCover = findViewById(R.id.album_cover);
        albumCover.setMinimumHeight(albumCover.getWidth());
        viewModel.album.observe(this, new Observer<CustomObject>() {
            @Override
            public void onChanged(CustomObject object) {
                Picasso.get().load(object.getImageUrl()).into(albumCover);
            }
        });

        final AppCompatTextView songTitle = findViewById(R.id.song_title);
        viewModel.song.observe(this, new Observer<CustomObject>() {
            @Override
            public void onChanged(CustomObject object) {
                songTitle.setText(object.getTitle());
            }
        });

        final AppCompatImageView playback = findViewById(R.id.playback);
        viewModel.flagPlayback.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean playing) {
                if (playing) {
                    playback.setImageDrawable(getDrawable(R.drawable.ic_pause_circle_filled_black_24dp));
                } else {
                    playback.setImageDrawable(getDrawable(R.drawable.ic_play_circle_filled_black_24dp));
                }
            }
        });
        playback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewModel.switchPlayback();
            }
        });

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheet));
        bottomSheetBehavior.setPeekHeight(0);
        viewModel.flagBottomSheet.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean visible) {
                if (visible) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.list) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        return navController.navigateUp();
    }

    @Override
    public void onBackPressed() {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        super.onBackPressed();
    }

    public MainViewModel getViewModel() {
        return viewModel;
    }
}
