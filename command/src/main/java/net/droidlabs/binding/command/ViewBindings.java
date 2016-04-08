package net.droidlabs.binding.command;

import android.databinding.BindingAdapter;
import android.view.View;

public class ViewBindings
{
    @BindingAdapter({"command"})
    public static void bindViewCommand(View view, final ICommand command)
    {
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                command.execute();
            }
        });
    }
}
