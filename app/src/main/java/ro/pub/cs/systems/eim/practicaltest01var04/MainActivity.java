package ro.pub.cs.systems.eim.practicaltest01var04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox1, checkBox2;
    private EditText editText1, editText2;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_var04_main);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        button = findViewById(R.id.btnDisplayInformation);
        textView = findViewById(R.id.information);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.EDITTEXT1)) {
                editText1.setText(savedInstanceState.getString(Constants.EDITTEXT1));
            } else {
                editText1.setText("");
            }
            if (savedInstanceState.containsKey(Constants.EDITTEXT2)) {
                editText2.setText(savedInstanceState.getString(Constants.EDITTEXT2));
            } else {
                editText2.setText("");
            }
        } else {
            editText1.setText("");
            editText2.setText("");
        }


        button.setOnClickListener(view -> {
            String text = "";
            if (checkBox1.isChecked()) {
                String text1 = editText1.getText().toString();
                if (text1.isEmpty()) {
                    showToastError();
                    return;
                } else {
                    text += editText1.getText().toString();
                }
            }
            if (checkBox2.isChecked()) {
                String text2 = editText2.getText().toString();
                if (text2.isEmpty()) {
                    showToastError();
                    return;
                } else {
                    text += editText2.getText().toString();
                }
            }
            textView.setText(text);
        });
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.EDITTEXT1, editText1.getText().toString());
        savedInstanceState.putString(Constants.EDITTEXT2, editText2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.EDITTEXT1)) {
            editText1.setText(savedInstanceState.getString(Constants.EDITTEXT1));
        } else {
            editText1.setText("");
        }
        if (savedInstanceState.containsKey(Constants.EDITTEXT2)) {
            editText2.setText(savedInstanceState.getString(Constants.EDITTEXT2));
        } else {
            editText2.setText("");
        }
    }

    private void showToastError() {
        Toast.makeText(this, "Completează toate câmpurile marcate.", Toast.LENGTH_SHORT).show();
    }
}