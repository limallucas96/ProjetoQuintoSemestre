package com.example.lucas.piquinto;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, senha;
    private Button btnLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.editUsuario_id);
        senha = findViewById(R.id.editSenha_id);
        btnLogar = findViewById(R.id.btnLogar_id);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogin(view);
            }
        });



    }

    public void onLogin(View view){
        String user = usuario.getText().toString();
        String password = senha.getText().toString();
        String type = "login";

        BackGroundWork worker =  new BackGroundWork(this);
        worker.execute(type, user, password);
    }
}
