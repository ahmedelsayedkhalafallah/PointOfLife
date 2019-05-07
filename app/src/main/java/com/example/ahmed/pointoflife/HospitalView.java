package com.example.ahmed.pointoflife;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HospitalView extends AppCompatActivity {

    public CardView fCardView;
    public CardView kCardView;
    boolean f = true;
    String carId, campaignId;
    TextView apb, anb, bpb, bnb, abpb, abnb, opb, onb,bbcount,bacount;
    int finalValue;
    //    Long apbs,apls,anbs,anls,bpbs,bpls,abpbs,abpls,abnbs,abnls,opbs,opls,onbs,onls;
    DatabaseReference mRoot;
    private Button btnap;
    private Button btnan;
    private Button btnbp;
    private Button btnbn;
    private Button btnabp;
    private Button btnabn;
    private Button btnop;
    private Button btnon;
    ProgressDialog mProgressDialog;
//    double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_view);
        mProgressDialog = new ProgressDialog(this);

        Intent intent = getIntent();
        carId = intent.getStringExtra("carID");
        campaignId = intent.getStringExtra("CampaignID");

bacount = findViewById(R.id.bloodamountcount);
        bbcount = findViewById(R.id.bloodbagcount);
        apb = findViewById(R.id.apb);

        anb = findViewById(R.id.anb);
        bpb = findViewById(R.id.bpb);
        abpb = findViewById(R.id.abpb);
        abnb = findViewById(R.id.abnb);
        bnb = findViewById(R.id.bnb);
        opb = findViewById(R.id.opb);
        onb = findViewById(R.id.onb);
        mProgressDialog.show();
        getValue("A+");
        getValue("A-");
        getValue("B+");
        getValue("AB+");
        getValue("AB-");
        getValue("B-");
        getValue("O+");
        getValue("O-");
        getValue("total");
        getValue("counter");


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

    void getValue(final String Type) {

        getValueOf(Type, new OnGetDataListener() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot, int value, String counter) {
                finalValue = value;
                switch (Type) {
                    case "A+":
                        apb.setText(String.valueOf(finalValue));
                        break;
                    case "A-":
                        anb.setText(String.valueOf(finalValue));
                        break;
                    case "B+":
                        bpb.setText(String.valueOf(finalValue));
                        break;
                    case "AB+":
                        abpb.setText(String.valueOf(finalValue));
                        break;
                    case "AB-":
                        abnb.setText(String.valueOf(finalValue));
                        break;
                    case "B-":
                        bnb.setText(String.valueOf(finalValue));
                        break;
                    case "O+":
                        opb.setText(String.valueOf(finalValue));
                        break;
                    case "O-":
                        onb.setText(String.valueOf(finalValue));
                        break;
                    case "total":
                        bacount.setText(String.valueOf(finalValue));
                        break;
                    case "counter":
                        bbcount.setText(String.valueOf(finalValue));
                        mProgressDialog.dismiss();
                        break;
                    default:
                        break;
                }
//                Toast.makeText(HospitalView.this, String.valueOf(finalValue), Toast.LENGTH_SHORT).show();
//                Toast.makeText(HospitalView.this, String.valueOf(value), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure() {

            }
        });

//        mRoot = FirebaseDatabase.getInstance().getReference().child("hospitals").child(id).child(Type).child(counter);
//        mRoot.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    value = dataSnapshot.getValue(double.class);
//                } else {
//                    value = 0.0;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        return value;
    }

    void getValueOf(String type, final OnGetDataListener onGetDataListener) {
        onGetDataListener.onStart();
        DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
        DatabaseReference typeRef = mRoot.child("campaigns").child(campaignId).child("records").child(type);
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int typeValue = dataSnapshot.getValue(Integer.class);
                onGetDataListener.onSuccess(dataSnapshot, typeValue, "");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        typeRef.addListenerForSingleValueEvent(valueEventListener);
    }
}
