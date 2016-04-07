package net.droidlabs.binding.command;

import android.databinding.Bindable;
import android.databinding.Observable;

public interface ICommand extends Observable
{
    @Bindable
    boolean isEnabled();

    void isEnabled(boolean isEnabled);

    @Bindable
    boolean isRefreshing();

    void isRefreshing(boolean isRefreshing);

    void execute();
}
