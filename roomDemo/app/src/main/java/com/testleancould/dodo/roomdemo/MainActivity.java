package com.testleancould.dodo.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.testleancould.dodo.roomdemo.bean.User;
import com.testleancould.dodo.roomdemo.bean.UserDao;
import com.testleancould.dodo.roomdemo.db.AppDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private UserDao mUserDao;
    private StringBuffer mBuffer;
    private TextView findInput;
    private String TAG = "thedata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"roomDemo_database").build();
        mUserDao=db.userDao();
        textView=findViewById(R.id.tv);
        findInput=findViewById(R.id.find_input);
        findInput.setInputType(InputType.TYPE_CLASS_NUMBER);
        mBuffer=new StringBuffer();

    }


    public void onClick(View view)
    {
        mBuffer.delete(0,mBuffer.length());
        switch(view.getId())
        {
            case R.id.insert_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Long along=mUserDao.insert(new User("deng","adam",21));
                        if(along>0)
                        {
                            String msg="插入成功,插入位置是:"+along.toString();
                            mBuffer.append(msg);

                        }else
                            {
                                String msg="插入失败";
                                mBuffer.append(msg);

                            }
                        MainActivity.this.setMsg();



                    }
                }).start();
                break;
            case R.id.insert_some:
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        ArrayList<User> users=new ArrayList<>();
                        users.add(new User("Deng","jack",21));
                        users.add(new User("Deng","Mike",21));
                        List<Long> longs=mUserDao.insertAll(users);
                        if (longs!=null&&longs.size()>0)
                        {
                            for (Long along:longs)
                            {
                                String msg="插入成功,插入位置是:"+along.toString();
                                mBuffer.append(msg+"\n");

                            }

                        }else
                            {
                                String msg="插入失败";
                                mBuffer.append(msg);
                            }



                        MainActivity.this.setMsg();
                    }
                }).start();
                break;

            case R.id.update_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random=new Random().nextInt(9)+1;
                        int update=mUserDao.update(new User(random,"Li","Blue"));
                        if (update>0)
                        {
                            String msg="更新成功,更新位置是:"+random;
                            mBuffer.append(msg);


                        }else
                        {
                            String msg="更新失败";
                            mBuffer.append(msg);
                        }


                        MainActivity.this.setMsg();
                    }
                }).start();
                break;
            case R.id.delete_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int random=new Random().nextInt(9)+1;
                        int delete=mUserDao.delete(new User(random));
                        if (delete>0)
                        {
                            String msg="删除成功,删除位置是:"+random;
                            mBuffer.append(msg);
                        }else
                            {
                                String msg="删除失败";
                                mBuffer.append(msg);
                            }

                        MainActivity.this.setMsg();
                    }
                }).start();
                break;

            case R.id.delete_all:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<User> all=mUserDao.getAll();
                        if (all!=null&&all.size()>0)
                        {
                            int i=mUserDao.deleteAll(all);
                            String msg="删除成功,删除条数是:"+i;
                            mBuffer.append(msg);

                        }else
                            {
                                String msg="删除失败,列表为空";
                                mBuffer.append(msg);
                            }

                        MainActivity.this.setMsg();
                    }
                }).start();
                break;

            case R.id.find_one:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int input=Integer.parseInt(findInput.getText().toString());
                        User user=mUserDao.findByUid(input);
                        if (user!=null)
                        {
                            String msg="查询成功，位置是:"+input+"内容："+user;
                            mBuffer.append(msg);
                        }else
                            {
                                String msg="查询失败,位置是："+input+"内容不存在";
                                mBuffer.append(msg);
                            }
                        MainActivity.this.setMsg();
                    }
                }).start();
                break;

            case R.id.find_all:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<User> all=mUserDao.getAll();
                        if(all!=null&&all.size()>0)
                        {
                            for (User user:all)
                            {
                                String msg="查询成功,内容："+user.toString();
                                mBuffer.append(msg+"\n");
                            }

                        }
                        else
                            {
                                String msg="查询失败";
                                mBuffer.append(msg);

                            }
                        MainActivity.this.setMsg();
                    }
                }).start();
                break;



        }





    }

    private void setMsg()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String string=mBuffer.toString();
                textView.setText(string);
            }
        });

    }

}
