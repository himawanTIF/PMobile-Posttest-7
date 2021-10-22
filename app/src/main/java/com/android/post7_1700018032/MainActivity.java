package com.android.post7_1700018032;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout Tab;
    private ViewPager Konten;
    private int[] tabIcons = {
            R.drawable.ic_profile,
            R.drawable.ic_implisit,
            R.drawable.ic_eksplisit
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tab = (TabLayout) findViewById(R.id.tabHeader);
        Konten = (ViewPager) findViewById(R.id.vpContent);

        Adapter adp = new Adapter(getSupportFragmentManager());
        Konten.setAdapter(adp);
            Tab.setupWithViewPager(Konten);
            setupTabIcons();
    }

    private void setupTabIcons() {
        Tab.getTabAt(0).setIcon(tabIcons[0]);
        Tab.getTabAt(1).setIcon(tabIcons[1]);
        Tab.getTabAt(2).setIcon(tabIcons[2]);
    }

    class Adapter extends FragmentStatePagerAdapter {
        Adapter(FragmentManager FM) {
            super(FM);
        }


        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                ProfileActivity profileActivity = new ProfileActivity();
                return profileActivity;
            } else if (position == 1) {
                ImplisitActivity implisitActivity = new ImplisitActivity();
                return implisitActivity;
            } else {
                EksplisitActivity eksplisitActivity = new EksplisitActivity();
                return eksplisitActivity;
            }
        }

        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "Profile";
            } else if (position == 1) {
                return "Implisit";
            } else {
                return "Eksplisit";
            }
        }
    }
}
