package net.droidlabs.binding.commandsample.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import net.droidlabs.binding.commandsample.R;
import net.droidlabs.binding.commandsample.databinding.ActivityMainBinding;
import net.droidlabs.binding.commandsample.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements IMainView
{
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        viewModel = new MainActivityViewModel(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        initToolbar(binding);
    }

    private void initToolbar(ActivityMainBinding binding)
    {
        setSupportActionBar(binding.toolbar);
    }

    @Override
    public void showMessage(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
