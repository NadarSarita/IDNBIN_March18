package com.app.idnbin.util;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.app.idnbin.LoginRegister.PhoneActivity;
import com.app.idnbin.LoginRegister.VerifyPhoneActivity;
import com.app.idnbin.R;
import com.app.idnbin.LoginRegister.UserDetails;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseActivity extends AppCompatActivity {
    private String[] permissions = new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE};
    private final int MULTIPLE_PERMISSIONS = 10;
    int REQUEST_PERMISSION_SETTING = 27;


    /*TODO Create Sharedprefrence for Storing Data*/
    private SharedPreferences getPrefData(Context context) {
        return context.getSharedPreferences(getResources().getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    /*TODO Get Data from Sharedprefrence*/
    public String getPref(Context context, String key) {
        return getPrefData(context).getString(key, "null");
    }

    /*TODO Set Data to Sharedprefrence*/
    public void setPref(Context context, String key, String value) {
        SharedPreferences.Editor editor = getPrefData(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void snackBar(View layout, String s) {
        Snackbar snackbar = Snackbar.make(layout, s.toUpperCase(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public String getTime() {
        Date currentTime = Calendar.getInstance().getTime();
        return currentTime.toString();
    }

    public void saveDetailsLater(UserDetails user) {

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

        sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("Id", user.getId());
        editor.putString("Email", user.getEmail());
        editor.putString("Phone", user.getPhone());
        editor.apply();
    }

    public void sendDataToClass(String mobile_no, String code, Class nextClass) {
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                && PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)) {
            saveContacts(mobile_no);
            setPref(this, "username", mobile_no);

            Intent intent = new Intent(this, nextClass);
            intent.putExtra("mobileCode",code);
            intent.putExtra("mobile", mobile_no);
            startActivity(intent);
            finish();
        } else {
            checkPermissions();
        }
    }


    public void sendVerificationCode(String mobile, String mobileCode,PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobileCode + mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);

        Log.d("FALALA", "Sent");
    }

    public void verifyVerificationCode(FirebaseAuth mAuth,String mVerificationId,String code,String mobile, ConstraintLayout Cl_Verify) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
        phoneLogin(mAuth,credential,mobile,Cl_Verify);
    }
    private void phoneLogin(FirebaseAuth mAuth, PhoneAuthCredential credential, String mobile, ConstraintLayout Cl_Verify) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
                        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                        if (firebaseUser != null) {
                            Log.d("GAHHAA", "" + mobile);
                            UserDetails user = new UserDetails(firebaseUser.getUid(), firebaseUser.getEmail(), "", "", currentDateTimeString,"");
                            GlobalConstants.UsersInstance.child(firebaseUser.getUid()).setValue(user);
                        }

                        if (task.getResult() != null) {
                            FirebaseUser user = task.getResult().getUser();

                            if (user != null) {
                                GlobalConstants.UsersInstance.child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                                        if (!dataSnapshot.exists()) {
                                            updateUI(user);
                                        } else {
                                            updateUI(user);
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
                            }
                        }


                    } else {
                        if (task.getException() != null) {
                            snackBar(Cl_Verify, "" + task.getException().getMessage());
                        }
                    }
                });
    }

    public void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            retrieveUserDetail(currentUser);
        }
    }

    private void sendToSetting() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                    && PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)) {
                Toast.makeText(this, "Thank You For Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void alertDialogPermission(boolean check) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Need Permission");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);

        if (check) {
            builder.setMessage("Please Allow Permission,\nWhich will help us to Improve your App Experience");
            builder.setPositiveButton("Grant",(dialog, id) -> {
                checkPermissions();
                dialog.cancel();
            });
        } else {
            builder.setMessage("App Need Contact Permission,\nGrant Permission in Setting➟Permissions");
            builder.setPositiveButton("Grant",(dialog, id) -> {
                sendToSetting();
                dialog.cancel();
            });
        }

        builder.setNegativeButton("Cancel", (dialog, id) -> dialog.cancel());
        android.app.AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == MULTIPLE_PERMISSIONS) {
            if (grantResults.length > 0) {
                ArrayList<String> permissionsDenied = new ArrayList<>();
                for (String per : permissions) {
                    if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        permissionsDenied.add(per);
                    }
                }

                if (permissionsDenied.size() > 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS) || shouldShowRequestPermissionRationale(Manifest.permission.READ_PHONE_STATE)) {
                            alertDialogPermission(true);
                        } else {
                            alertDialogPermission(false);
                        }
                    }
                }
            }

        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void saveContacts(String user) {
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(ContactWork.class)
                .setInputData(createInputData(user))
                .setInitialDelay(2, TimeUnit.SECONDS)
                .build();
        WorkManager.getInstance(this).enqueue(workRequest);
    }

    private Data createInputData(String value) {
        return new Data.Builder().putString("keyUserName", value).build();
    }

    public void checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (listPermissionsNeeded.size() != 0) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[0]), MULTIPLE_PERMISSIONS);
        }
    }

    public void retrieveUserDetail(FirebaseUser fUser) {
        GlobalConstants.UsersInstance.child(fUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserDetails user = dataSnapshot.getValue(UserDetails.class);
                if (user != null)
                    saveDetailsLater(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
