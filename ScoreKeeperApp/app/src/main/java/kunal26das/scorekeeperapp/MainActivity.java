package kunal26das.scorekeeperapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import kunal26das.scorekeeperapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setViewModel(viewModel);
        dataBinding.setLifecycleOwner(this);

        Button teamAScoreIncrement = findViewById(R.id.teamAScoreIncrement);
        Button teamBScoreIncrement = findViewById(R.id.teamBScoreIncrement);
        Button teamAScoreDecrement = findViewById(R.id.teamAScoreDecrement);
        Button teamBScoreDecrement = findViewById(R.id.teamBScoreDecrement);
        Button teamAPenaltyIncrement = findViewById(R.id.teamAPenaltyIncrement);
        Button teamBPenaltyIncrement = findViewById(R.id.teamBPenaltyIncrement);
        Button teamAPenaltyDecrement = findViewById(R.id.teamAPenaltyDecrement);
        Button teamBPenaltyDecrement = findViewById(R.id.teamBPenaltyDecrement);

        teamAScoreIncrement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer teamAScore = viewModel.teamAScore.getValue();
                if (teamAScore != null) {
                    viewModel.teamAScore.setValue(
                            teamAScore + 1
                    );
                }
            }
        });

        teamBScoreIncrement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer teamBScore = viewModel.teamBScore.getValue();
                if (teamBScore != null) {
                    viewModel.teamBScore.setValue(
                            teamBScore + 1
                    );
                }
            }
        });

        teamAScoreDecrement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer teamAScore = viewModel.teamAScore.getValue();
                if (teamAScore != null) {
                    viewModel.teamAScore.setValue(
                            teamAScore - 1
                    );
                }
            }
        });

        teamBScoreDecrement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer teamBScore = viewModel.teamBScore.getValue();
                if (teamBScore != null) {
                    viewModel.teamBScore.setValue(
                            teamBScore - 1
                    );
                }
            }
        });

        teamAPenaltyIncrement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer teamAPenalty = viewModel.teamAPenalty.getValue();
                if (teamAPenalty != null) {
                    viewModel.teamAPenalty.setValue(
                            teamAPenalty + 1
                    );
                }
            }
        });

        teamBPenaltyIncrement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer teamBPenalty = viewModel.teamBPenalty.getValue();
                if (teamBPenalty != null) {
                    viewModel.teamBPenalty.setValue(
                            teamBPenalty + 1
                    );
                }
            }
        });

        teamAPenaltyDecrement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer teamAPenalty = viewModel.teamAPenalty.getValue();
                if (teamAPenalty != null) {
                    viewModel.teamAPenalty.setValue(
                            teamAPenalty - 1
                    );
                }
            }
        });

        teamBPenaltyDecrement.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer teamBPenalty = viewModel.teamBPenalty.getValue();
                if (teamBPenalty != null) {
                    viewModel.teamBPenalty.setValue(
                            teamBPenalty - 1
                    );
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset: {
                viewModel.teamAScore.setValue(0);
                viewModel.teamBScore.setValue(0);
                viewModel.teamAPenalty.setValue(0);
                viewModel.teamBPenalty.setValue(0);
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
