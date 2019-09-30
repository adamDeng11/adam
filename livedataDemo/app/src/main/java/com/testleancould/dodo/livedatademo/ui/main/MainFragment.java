package com.testleancould.dodo.livedatademo.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.testleancould.dodo.livedatademo.R;
import com.testleancould.dodo.livedatademo.bean.Dome;

import java.util.concurrent.TimeUnit;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Unbinder unbinder;
    @BindView(R.id.btn1)
    private Button btn1;
    /*@BindView(R.id.number1_txt)*/
    private TextView numbertxt;
    /*@BindView(R.id.password1_txt)*/
    private TextView passwordtxt;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this,view);

        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.postDomeInfo("adamfragmet","654321");

            }
        });
        return view;
    }
    @Override
    public void onViewCreated(View view,@Nullable Bundle bundle)
    {
        super.onViewCreated(view,bundle);

        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        numbertxt=view.findViewById(R.id.number1_txt);
        passwordtxt=view.findViewById(R.id.password1_txt);



       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Fragment销毁的时候解绑 ButterKnife
        unbinder.unbind();
    }


}
