package net.droidlabs.binding.command;

import android.databinding.ObservableBoolean;

public abstract class Command implements ICommand
{
    private final ObservableBoolean enabled;
    private final ObservableBoolean inProgress;

    public Command()
    {
        this.enabled = new ObservableBoolean(true);
        this.inProgress = new ObservableBoolean(false);
    }

    @Override
    public ObservableBoolean canExecute()
    {
        return this.enabled;
    }

    @Override
    public void canExecute(boolean enabled)
    {
        this.enabled.set(enabled);
    }

    @Override
    public void isRefreshing(boolean inProgress)
    {
        this.inProgress.set(inProgress);
    }

    @Override
    public ObservableBoolean isRefreshing()
    {
        return this.inProgress;
    }
}
