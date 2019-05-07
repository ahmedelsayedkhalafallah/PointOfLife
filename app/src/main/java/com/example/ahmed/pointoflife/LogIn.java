package com.example.ahmed.pointoflife;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {

    DatabaseReference mRoot,campaignIdRoot;
    Map<String,Car> h;
    boolean campaignIdFound = false;
//    Map<String,Hospital> h2;
//    Map<String,Admin> h3;
    EditText name,password,campaignNumber;
    String Id,Pass,CNumber,campaignDate,currentDate;
    Button login;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        currentDate = getDate();
        mProgressDialog = new ProgressDialog(this);

        h = new HashMap<String, Car>();
//        h2 = new HashMap<String, Hospital>();
//        h3 = new HashMap<String, Admin>();
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        campaignNumber = findViewById(R.id.CNum);
        mRoot = FirebaseDatabase.getInstance().getReference().child("cars");
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog.show();
        Id = name.getText().toString();
        Pass = password.getText().toString();
        CNumber = campaignNumber.getText().toString();
        if(CNumber.length() == 0){
            CNumber="x";
        }

                getValues(new OnGetDataListener(){
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot, int value, String counter) {
                        mProgressDialog.dismiss();
                        if(!(h.isEmpty())){
                            if(h.containsKey(Id)) {
                                if (Pass.equals(String.valueOf(h.get(Id).getPassword()))) {
                                    if(CNumber != "x") {
                                        if (campaignIdFound){
                                            if(campaignDate.equals(currentDate)) {
                                                DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference().child("campaigns").child(CNumber).child("logs");
                                                mRoot.child(getLogTime()).setValue(Id);
                                                campaignIdFound = false;
                                                Intent intent = new Intent(LogIn.this, choose.class);
                                                intent.putExtra("carID", h.get(Id).getId().toString());
                                                intent.putExtra("CampaignID", String.valueOf(CNumber));
                                                startActivity(intent);
                                            }
                                            else{
                                                Toast.makeText(LogIn.this, "This campaign has ended", Toast.LENGTH_SHORT).show();
                                            }
                                    }
                                    else{
                                            Toast.makeText(LogIn.this, "Wrong Campaign number", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else
                                    {
                                        Toast.makeText(LogIn.this, "Please enter your campaign number", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else {
                                    Toast.makeText(LogIn.this, "wrong password", Toast.LENGTH_SHORT).show();

                                }
                            }
                            else{
                                Toast.makeText(LogIn.this, "User Not found", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(LogIn.this, "No registered users", Toast.LENGTH_SHORT).show();
                        }

//                        if(!(h2.isEmpty())){
//                            if(h2.containsKey(Id)) {
//                                if (Pass.equals(String.valueOf(h2.get(Id).getPassword()))) {
//                                    Intent intent = new Intent(LogIn.this, choose.class);
//                                    intent.putExtra("id",h2.get(Id).getId());
//                                    startActivity(intent);
//                                }
//                                else{
//                                    Toast.makeText(LogIn.this, "wrong password", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        }
//                        else{
//
//                        }
//
//                        if(!(h3.isEmpty())){
//                            if(h3.containsKey(Id)) {
//                                if (Pass.equals(String.valueOf(h3.get(Id).getPassword()))) {
//                                    Intent intent = new Intent(LogIn.this, hospitals.class);
//                                    intent.putExtra("id", h3.get(Id).getName());
//                                    startActivity(intent);
//                                }
//                                else{
//                                    Toast.makeText(LogIn.this, "wrong password", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        }
//                        else{
//                            Toast.makeText(LogIn.this, "User not found", Toast.LENGTH_SHORT).show();
//                        }

                    }

                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onFailure() {

                    }
                });
//        mRoot.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
//                    Car car = new Car();
//                    car.setHospital(childSnapshot.child("hospital").getValue(Long.class));
//                    car.setId(childSnapshot.child("id").getValue(Long.class));
//                    car.setPassword(childSnapshot.child("password").getValue(Long.class));
//                    h.put(car.getId().toString(),car);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        mRoot = FirebaseDatabase.getInstance().getReference().child("hospitals");
//                mRoot.addChildEventListener(new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                        for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
//                            Hospital hospital = new Hospital();
//                            hospital.setBags(childSnapshot.child("bags").getValue(String.class));
//                            hospital.setId( childSnapshot.child("id").getValue(String.class));
//                            hospital.setName( childSnapshot.child("name").getValue(String.class));
//                            hospital.setPassword( childSnapshot.child("password").getValue(String.class));
//
//                            h2.put(hospital.getId(), hospital);
//                        }
//
//                    }
//
//                    @Override
//                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });


            }
});
    }
    String getDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }
    String getLogTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-kk-mm-ss-SSS");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }
void getValues(final OnGetDataListener onGetDataListener){
    onGetDataListener.onStart();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference carsRef = rootRef.child("cars");
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                Car car = ds.getValue(Car.class);
                h.put(car.getId().toString(),car);
            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            System.out.print(databaseError.getMessage());}
    };
    carsRef.addListenerForSingleValueEvent(valueEventListener);

    DatabaseReference cIdRef = rootRef.child("campaigns").child(CNumber).child("date");
    ValueEventListener valueEventListener1 = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(dataSnapshot.getValue() != null) {
                String s = dataSnapshot.getValue(String.class);
                if (s.length() == 10) {
                    campaignIdFound = true;
                    campaignDate = s;
                }
            }
            onGetDataListener.onSuccess(dataSnapshot,0,"");

            }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    cIdRef.addListenerForSingleValueEvent(valueEventListener1);

//    DatabaseReference rootRef2 = FirebaseDatabase.getInstance().getReference();
//    DatabaseReference hospitalsRef = rootRef2.child("hospitals");
//    ValueEventListener valueEventListener2 = new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                Hospital hospital = ds.getValue(Hospital.class);
//                h2.put(hospital.getId(),hospital);
//            }
//            onGetDataListener.onSuccess(dataSnapshot,0.0,"");
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError databaseError) {
//            System.out.print(databaseError.getMessage());
//        onGetDataListener.onFailure();
//        }
//    };
//    hospitalsRef.addListenerForSingleValueEvent(valueEventListener2);

//    DatabaseReference rootRef3 = FirebaseDatabase.getInstance().getReference();
//    DatabaseReference adminsRef = rootRef3.child("admins");
//    ValueEventListener valueEventListener3 = new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//            for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                Admin admin = ds.getValue(Admin.class);
//                h3.put(admin.getName(),admin);
//            }
//            onGetDataListener.onSuccess(dataSnapshot,0.0,"");
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError databaseError) {
//            System.out.print(databaseError.getMessage());
//            onGetDataListener.onFailure();
//        }
//    };
//    adminsRef.addListenerForSingleValueEvent(valueEventListener3);

    }


}
