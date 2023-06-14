package com.asv.holachat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.asv.holachat.Adapter.FragmentAdapter;
import com.asv.holachat.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();
        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ){
            case R.id.settings:
                Toast.makeText(this, "Opening Settings!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logOut:
                Toast.makeText(this, "SigningOut!!", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                Toast.makeText(this, "LoggedOut Successfully!!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.groupChat:
                Toast.makeText(this, "Opening GroupChat!!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}