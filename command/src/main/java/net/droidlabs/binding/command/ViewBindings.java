package net.droidlabs.binding.command;

import android.databinding.BindingAdapter;
import android.view.View;

public class ViewBindings
{
    @BindingAdapter({"command"})
    public static void bindEditText(View view, final ICommand command)
    {
        if (view.getTag(R.id.commandBinded) == null)
        {
            view.setTag(R.id.commandBinded, true);
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
}
