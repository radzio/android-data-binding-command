package net.droidlabs.binding.commandsample.viewmodel;

import android.databinding.ObservableField;
import net.droidlabs.binding.command.Command;
import net.droidlabs.binding.command.ICommand;
import net.droidlabs.binding.commandsample.view.IMainView;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivityViewModel
{
    public final ObservableField<String> timer = new ObservableField<>();

    public ICommand fabCommand = new Command()
    {
        @Override
        public void execute()
        {
            MainActivityViewModel.this.view.showMessage("Hello from Command!");
        }
    };

    public ICommand enableButtonCommand = new Command()
    {
        @Override
        public void execute()
        {
            buttonCommand.isEnabled(!buttonCommand.isEnabled());
        }
    };

    public ICommand buttonCommand = new Command()
    {
        @Override
        public void execute()
        {
            this.isRefreshing(true);

            longOperation()
                    .doOnCompleted(new Action0()
                    {
                        @Override
                        public void call()
                        {
                            isRefreshing(false);
                        }
                    })
                    .subscribe(new Action1<Integer>()
                    {
                        @Override
                        public void call(Integer integer)
                        {
                            MainActivityViewModel.this.timer.set(integer.toString());
                        }
                    });
        }
    };

    private IMainView view;

    public MainActivityViewModel(IMainView view)
    {
        this.view = view;
        this.buttonCommand.isEnabled(false);
    }

    private Observable<Integer> longOperation()
    {
        return Observable.create(new Observable.OnSubscribe<Integer>()
        {
            @Override
            public void call(Subscriber subscriber)
            {
                for (int i = 0; i < 5; i++)
                {
                    subscriber.onNext(i);
                    try
                    {
                        Thread.sleep(800);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }

}
