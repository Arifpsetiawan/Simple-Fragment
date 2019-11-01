package id.apuse.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import id.apuse.fragment.Fragment.FavoriteFragment;
import id.apuse.fragment.Fragment.HomeFragment;
import id.apuse.fragment.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    FavoriteFragment favoriteFragment;
    ProfileFragment profileFragment;

    BottomNavigationView bnvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnvMain = findViewById(R.id.bnvMain);

        homeFragment = new HomeFragment();
        favoriteFragment = new FavoriteFragment();
        profileFragment = new ProfileFragment();

        changeFragment(homeFragment);

        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        changeFragment(homeFragment);
                        break;
                    case R.id.menuFavorite:
                        changeFragment(favoriteFragment);
                        break;
                    case R.id.menuProfile:
                        changeFragment(profileFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameMain, fragment).commit();
    }
}
