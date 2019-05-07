package com.example.ahmed.pointoflife;

import com.google.firebase.database.DataSnapshot;

public interface OnGetDataListener {
    void onSuccess(DataSnapshot dataSnapshot, int value, String counter);
    void onStart();
    void onFailure();
}
