package com.testleancould.dodo.livedatademo.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import butterknife.BindView;
import butterknife.Unbinder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.testleancould.dodo.livedatademo.MainActivity;
import com.testleancould.dodo.livedatademo.R;
import com.testleancould.dodo.livedatademo.bean.Dome;

public class MainFragment2 extends Fragment {

    private MainViewModel mViewModel;
    private Unbinder unbinder;
    @BindView(R.id.btn2)
    private Button btn2;
    /*@BindView(R.id.number2_txt)*/
    private TextView numbertxt;
   /* @BindView(R.id.password2_txt)*/
    private TextView passwordtxt;

    public static MainFragment2 newInstance() {
        return new MainFragment2();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }


    @Override
    public void onViewCreated(View view,@Nullable Bundle bundle)
    {
        super.onViewCreated(view,bundle);
        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        numbertxt=view.findViewById(R.id.number2_txt);
        passwordtxt=view.findViewById(R.id.password2_txt);

        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.postDomeInfo("adamfragmet222","654321");
                /*view v getView()都可以,都是同一个*/

            }
        });
        mViewModel.getDomeMutableLiveData().observe(this, new Observer<Dome>() {
            @Override
            public void onChanged(@Nullable Dome dome) {
                numbertxt.setText(dome.getPhone_str());
                passwordtxt.setText(dome.getPwd_str());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }
    }


