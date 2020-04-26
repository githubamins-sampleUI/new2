package ir.amin.resturant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton btn_basket, btn_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_basket = findViewById(R.id.basket_btn);
        btn_home = findViewById(R.id.home_btn);

        btn_home.setOnClickListener(this);
        btn_basket.setOnClickListener(this);
        loadFragment(new FirstFragment());

    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public void onClick(View view) {
        Fragment f = null;
        switch (view.getId()){
            case R.id.basket_btn:
                loadFragment(new FirstFragment());
                Toast.makeText(getApplicationContext(), "clicke basket", Toast.LENGTH_SHORT).show();
            break;

            case R.id.home_btn:
                loadFragment(new SecondFragment());
                Toast.makeText(getApplicationContext(), "clicke home", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
