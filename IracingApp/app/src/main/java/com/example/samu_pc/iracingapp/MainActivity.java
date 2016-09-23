package com.example.samu_pc.iracingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





    }


    public void boton(View v){
        Button submit = (Button) v;

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                AppDB db = new AppDB(getApplicationContext());

                db.insertSeries(1,"imsa","monza","ruf","00:35/2h", "nota 1");
                db.insertSeries(2,"blancpain","imola","gt3","00:10/2h", "nota 2");

                Log.d("TOTAL", Integer.toString(db.getAllSeries().size()));//mostrar el total
                int[] ids = new int[db.getAllSeries().size()];
                String[] names = new String[db.getAllSeries().size()];
                String[] tracks = new String[db.getAllSeries().size()];
                String[] cars = new String[db.getAllSeries().size()];
                String[] schedules = new String[db.getAllSeries().size()];
                String[] notes = new String[db.getAllSeries().size()];

                for (int i = 0; i<db.getAllSeries().size();i++){
                    ids[i] = db.getAllSeries().get(i).getId();
                    names[i] = db.getAllSeries().get(i).getName();
                    tracks[i] = db.getAllSeries().get(i).getTrack();
                    cars[i] = db.getAllSeries().get(i).getCar();
                    schedules[i] = db.getAllSeries().get(i).getSchedule();
                    notes[i] = db.getAllSeries().get(i).getNotes();
                    Log.d(""+ids[i], names[i] + ", "+ tracks[i] + ", " + cars[i] + ", " + schedules[i] + ", " + notes[i]);

                }
                TextView editSeries = (TextView) findViewById(R.id.series);
                editSeries.setText(""+names[0] + ", "+ tracks[0] + ", " + cars[0] + ", " + schedules[0] + ", " + notes[0]);
            }
        });



    }
}
