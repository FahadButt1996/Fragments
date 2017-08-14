package com.example.mfahad.fragments;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button btnA;
    private Button btnB;
    boolean checkA;
    boolean checkB;
    android.app.FragmentManager fm;
    FragmentTransaction ft ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = (Button) findViewById(R.id.f1);
        btnB = (Button) findViewById(R.id.f2);

        checkA = checkB = false;
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.f1 :{
                    if(checkA == false) {
                        fm = getFragmentManager();
                        ft = fm.beginTransaction();
                        FragmentA fragmentA = (FragmentA) fm.findFragmentByTag("fragmentA");
                        if (fragmentA == null) {
                            fragmentA = new FragmentA();
                            ft.add(R.id.fragentA, fragmentA, "fragmentA");
                            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                            ft.commit();
                        }
                        checkA = true;
                        btnA.setText("Remove Fragment A");
                    }else {
                        fm = getFragmentManager();
                        ft = fm.beginTransaction();
                        FragmentA fragmentA =  (FragmentA) fm.findFragmentByTag("fragmentA");
                        if(fragmentA != null)
                        {
                            ft.remove(fragmentA);
                            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                            ft.commit();
                        }
                        checkA = false;
                        btnA.setText(" Attach Fragment A");
                    }
                break;
            }

            case R.id.f2 :{
                if(checkB == false) {
                    fm = getFragmentManager();
                    ft = fm.beginTransaction();
                    FragmentB fragmentB = (FragmentB) fm.findFragmentByTag("fragmentB");
                    if (fragmentB == null) {
                        fragmentB = new FragmentB();
                        ft.add(R.id.fragmentB, fragmentB, "fragmentB");
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        ft.commit();
                    }
                    checkB = true;
                    btnB.setText("Remove Fragment B");
                }else {
                    fm = getFragmentManager();
                    ft = fm.beginTransaction();
                    FragmentB fragmentB =  (FragmentB) fm.findFragmentByTag("fragmentB");
                    if(fragmentB != null)
                    {
                        ft.remove(fragmentB);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                        ft.commit();
                    }
                    checkB = false;
                    btnB.setText(" Attach Fragment B");
                }
                break;
            }

            default:{
                break;
            }
        }

    }
}
