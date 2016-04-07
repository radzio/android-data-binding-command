package net.droidlabs.binding.command;

import android.databinding.BaseObservable;

public abstract class Command extends BaseObservable implements ICommand
{
    private boolean isEnabled;
    private boolean isRefreshing;

    public Command()
    {
        isEnabled(true);
        isRefreshing(false);
    }

    @Override
    public boolean isEnabled()
    {
        return this.isEnabled;
    }

    @Override
    public void isEnabled(boolean isEnabled)
    {
        this.isEnabled = isEnabled;
        notifyPropertyChanged(net.droidlabs.binding.command.BR.enabled);
    }

    @Override
    public void isRefreshing(boolean isRefreshing)
    {
        this.isRefreshing = isRefreshing;
        notifyPropertyChanged(net.droidlabs.binding.command.BR.refreshing);
    }

    @Override
    public boolean isRefreshing()
    {
        return this.isRefreshing;
    }
}
