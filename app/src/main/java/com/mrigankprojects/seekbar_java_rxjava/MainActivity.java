package com.mrigankprojects.seekbar_java_rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Task> taskObservable = Observable
                .fromIterable(DataSource.createDataSource()) //get each element one by one from a list
                .subscribeOn(Schedulers.io()) //which thread is the action happening
                .filter(new Predicate<Task>() { // Predicate for filtering the elements after the test
                    @Override
                    public boolean test(Task task) throws Exception {
                        Log.d(TAG, task.Description());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return task.IsComplete(); // Doesn't matter if this is complete or not. It just returns the value
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()); // where is the output observed on

        taskObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe");
            }

            @Override
            public void onNext(Task task) {
                Log.d(TAG, Thread.currentThread().getName());

//                Non parallel way - Do sleep here and observe how the seek bar doesn't appear until all the elements have been received
//                Log.d(TAG, task.description);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError", e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        });
    }
}
