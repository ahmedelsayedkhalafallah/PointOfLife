package com.example.ahmed.pointoflife;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HospitalView extends AppCompatActivity {

    boolean f = true;
    private Button btnap;
    private Button btnan;
    private Button btnbp;
    private Button btnbn;
    private Button btnabp;
    private Button btnabn;
    private Button btnop;
    private Button btnon;
    public CardView fCardView;
    public CardView kCardView;
    String id;
    TextView apb,apl,anb,anl,bpb,bpl,bnb,bnl,abpb,abpl,abnb,abnl,opb,opl,onb,onl;
    Long apbs,apls,anbs,anls,bpbs,bpls,abpbs,abpls,abnbs,abnls,opbs,opls,onbs,onls;
    DatabaseReference mRoot;
    double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_view);


        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();


        apb = findViewById(R.id.apb);
        apl = findViewById(R.id.apl);
        anb = findViewById(R.id.anb);
        anl = findViewById(R.id.anl);
        bpb = findViewById(R.id.bpb);
        bpl = findViewById(R.id.bpl);
        abpb = findViewById(R.id.abpb);
        abpl = findViewById(R.id.abpl);
        abnb = findViewById(R.id.abnb);
        abnl = findViewById(R.id.abnl);
        bnb = findViewById(R.id.bnb);
        bnl = findViewById(R.id.bnl);
        opb = findViewById(R.id.opb);
        opl = findViewById(R.id.opl);
        onb = findViewById(R.id.onb);
        onl = findViewById(R.id.onl);


        apb.setText(String.valueOf(getValue("A+","bags")));
        apl.setText(String.valueOf(getValue("A+","litres")));
        anb.setText(String.valueOf(getValue("A-","bags")));
        anl.setText(String.valueOf(getValue("A-","litres")));
        bpb.setText(String.valueOf(getValue("B+","bags")));
        bpl.setText(String.valueOf(getValue("B+","litres")));
        abpb.setText(String.valueOf(getValue("AB+","bags")));
        abpl.setText(String.valueOf(getValue("AB+","litres")));
        abnb.setText(String.valueOf(getValue("AB-","bags")));
        abnl.setText(String.valueOf(getValue("AB-","litres")));
        bnb.setText(String.valueOf(getValue("B-","bags")));
        bnl.setText(String.valueOf(getValue("B-","litres")));
        opb.setText(String.valueOf(getValue("O+","bags")));
        opl.setText(String.valueOf(getValue("O+","litres")));
        onb.setText(String.valueOf(getValue("O-","bags")));
        onl.setText(String.valueOf(getValue("O-","litres")));


        btnap = (Button) findViewById(R.id.btnap_Button);
        btnbp = (Button) findViewById(R.id.btnbp_Button);
        btnan = (Button) findViewById(R.id.btnan_Button);
        btnbn = (Button) findViewById(R.id.btnbn_Button);
        btnabp = (Button) findViewById(R.id.btnabp_Button);
        btnabn = (Button) findViewById(R.id.btnabn_Button);
        btnop = (Button) findViewById(R.id.btnop_Button);
        btnon = (Button) findViewById(R.id.btnon_Button);


        fCardView = (CardView) findViewById(R.id.fCardView);
        final CardView sCardView = (CardView) findViewById(R.id.sCardView);
        final CardView tCardView = (CardView) findViewById(R.id.tCardView);
        final CardView rCardView = (CardView) findViewById(R.id.rCardView);
        kCardView = (CardView) findViewById(R.id.kCardView);
        final CardView saCardView = (CardView) findViewById(R.id.saCardView);
        final CardView sbCardView = (CardView) findViewById(R.id.sbCardView);
        final CardView tmCardView = (CardView) findViewById(R.id.tmCardView);




        btnap.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (f) {
                    fCardView.setVisibility(View.VISIBLE);
                    f = false;
                } else {
                    fCardView.setVisibility(View.GONE);
                    f = true;
                }
            }

        });


        btnbp.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (f) {
                    sCardView.setVisibility(View.VISIBLE);
                    f = false;
                } else {
                    sCardView.setVisibility(View.GONE);
                    f = true;
                }
            }

        });

        btnabp.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (f) {
                    tCardView.setVisibility(View.VISIBLE);
                    f = false;
                } else {
                    tCardView.setVisibility(View.GONE);
                    f = true;
                }
            }

        });


        btnop.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (f) {
                    rCardView.setVisibility(View.VISIBLE);
                    f = false;
                } else {
                    rCardView.setVisibility(View.GONE);
                    f = true;
                }
            }

        });

        btnan.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (f) {
                    kCardView.setVisibility(View.VISIBLE);

                    f = false;
                } else {
                    kCardView.setVisibility(View.GONE);
                    f = true;
                }
            }

        });

        btnbn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (f) {
                    saCardView.setVisibility(View.VISIBLE);
                    f = false;
                } else {
                    saCardView.setVisibility(View.GONE);
                    f = true;
                }
            }

        });


        btnabn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (f) {
                    sbCardView.setVisibility(View.VISIBLE);
                    f = false;
                } else {
                    sbCardView.setVisibility(View.GONE);
                    f = true;
                }
            }

        });


        btnon.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (f) {
                    tmCardView.setVisibility(View.VISIBLE);
                    f = false;
                } else {
                    tmCardView.setVisibility(View.GONE);
                    f = true;
                }
            }

        });

    }

    double getValue(String Type, String counter) {
        mRoot = FirebaseDatabase.getInstance().getReference().child("hospitals").child(id).child(Type).child(counter);
        mRoot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    value = dataSnapshot.getValue(double.class);
                } else {
                    value = 0.0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return value;
    }
}
