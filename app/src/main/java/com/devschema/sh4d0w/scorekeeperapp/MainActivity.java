package com.devschema.sh4d0w.scorekeeperapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvStartId,tvTeamAScore,tvTeamBScore;
    Button btnReset;
    private int TeamAScore = 0;
    private int TeamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();


        // Random Select Team To Play
        String[] array = {"Team A  ", "Team B" };
        String randomStr = array[new Random().nextInt(array.length)];
        tvStartId.setText("Team Random Selection  = " + randomStr);
        //Save Instance for screen orientation
        if(savedInstanceState!=null){
            TeamAScore=savedInstanceState.getInt("TeamAScore");
            TeamBScore=savedInstanceState.getInt("TeamBScore");
            tvTeamAScore.setText(String.valueOf(TeamAScore));
            tvTeamBScore.setText(String.valueOf(TeamBScore));

        }

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeamAScore = 0;
                TeamBScore = 0;
                tvTeamAScore.setText(String.valueOf(TeamAScore));
                tvTeamBScore.setText(String.valueOf(TeamBScore));
            }
        });//btnReset


    }

    private void findViewById()
    {
        tvStartId= (TextView)findViewById(R.id.tvStartId);
        tvTeamAScore= (TextView)findViewById(R.id.tvTeamAScore);
        tvTeamBScore= (TextView)findViewById(R.id.tvTeamBScore);

        btnReset=(Button)findViewById(R.id.btnReset);

    }//findViewById

    public void TeamAOne(View view) {
        TeamAScore+=1;
        tvTeamAScore.setText(String.valueOf(TeamAScore));
        CheckResult(TeamAScore,"A");
    }

    public void TeamATwo(View view) {
        TeamAScore+=2;
        tvTeamAScore.setText(String.valueOf(TeamAScore));
        CheckResult(TeamAScore,"A");
    }

    public void TeamAFree(View view) {
        TeamAScore+=1;
        tvTeamAScore.setText(String.valueOf(TeamAScore));
        CheckResult(TeamAScore,"A");
    }

    public void TeamBOne(View view) {
        TeamBScore+=1;
        tvTeamBScore.setText(String.valueOf(TeamBScore));
        CheckResult(TeamBScore,"B");
    }

    public void TeamBTwo(View view) {
        TeamBScore+=2;
        tvTeamBScore.setText(String.valueOf(TeamBScore));
        CheckResult(TeamBScore,"B");
    }

    public void TeamBFree(View view) {
        TeamBScore+=1;
        tvTeamBScore.setText(String.valueOf(TeamBScore));
        CheckResult(TeamBScore,"B");
    }

    private void CheckResult(int total,String team)
    {
        if (total >=10)
        {
            tvStartId.setText("Team  " + team + " Won The Game with "+ total +" Points");

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TeamAScore",TeamAScore);
        outState.putInt("TeamBScore",TeamBScore);

    }
}
