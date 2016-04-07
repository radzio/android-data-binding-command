package net.droidlabs.binding.command;

import android.databinding.ObservableBoolean;

public interface ICommand
{
    ObservableBoolean canExecute();

    void canExecute(boolean enabled);

    void isRefreshing(boolean inProgress);

    ObservableBoolean isRefreshing();

    void execute();
}
