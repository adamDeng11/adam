package com.testleancould.dodo.livedatademo.ui.main;

import com.testleancould.dodo.livedatademo.bean.Dome;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<Dome> domeMutableLiveData=new MutableLiveData<>();
    /**
     * 改变 LiveData 中的数据
     * 使用 setValue()
     * @param phone_str
     * @param password_str
     * setValue()要在主线程中调用
     */

    public void setDomeInfo(String phone_str,String password_str)
    {
        domeMutableLiveData.setValue(new Dome(phone_str,password_str));

    }

    /**
     * 改变 LiveData 中的数据
     * 使用 postValue()
     * postValue()既可在主线程也可在子线程中调用
     */
    public void postDomeInfo(String phone_str,String password_str)
    {
        domeMutableLiveData.postValue(new Dome(phone_str,password_str));
    }

    public MutableLiveData<Dome> getDomeMutableLiveData()
    {

        return domeMutableLiveData;
    }


    @Override
    protected void onCleared()
    {
        super.onCleared();
    }
    // TODO: Implement the ViewModel
}
