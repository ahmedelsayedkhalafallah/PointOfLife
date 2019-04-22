package com.example.ahmed.pointoflife;

import com.google.firebase.database.DataSnapshot;

public interface OnGetDataListener {
    void onSuccess(DataSnapshot dataSnapshot, double value, String counter);
    void onStart();
    void onFailure();
}
